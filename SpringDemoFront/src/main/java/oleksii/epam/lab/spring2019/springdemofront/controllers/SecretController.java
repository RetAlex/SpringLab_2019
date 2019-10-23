package oleksii.epam.lab.spring2019.springdemofront.controllers;

import oleksii.epam.lab.spring2019.springdemofront.dto.Secret;
import oleksii.epam.lab.spring2019.springdemofront.services.SecretService;
import org.springframework.context.MessageSource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class SecretController {
    private final SecretService secretService;
    private final MessageSource messageSource;

    public SecretController(SecretService secretService, MessageSource messageSource) {
        this.secretService = secretService;
        this.messageSource = messageSource;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/secret")
    public String renderSecretPage(Model model){
        String username = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        model.addAttribute("secret", secretService.getSecret(username));
        return "secret";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/secret")
    public String setSecret(@Valid @ModelAttribute Secret secret, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            System.err.println("We have an error");
            throw new RuntimeException("Ex");
        }
        String username = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        secretService.sendSecret(new Secret(username, secret.getSecret()));
        return "redirect:/secret";
    }
}
