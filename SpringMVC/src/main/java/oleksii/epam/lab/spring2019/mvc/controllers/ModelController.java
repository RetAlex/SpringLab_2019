package oleksii.epam.lab.spring2019.mvc.controllers;

import lombok.Data;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ModelController {
    @GetMapping({"/index2", "/2"})
    public String getIndex(HttpServletRequest request, Model model){
        model.addAttribute("greetingText", "Secret2");
        return "index";
    }

    @PostMapping(value = {"/receiveUser"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String receiveUser(@RequestBody User user, Model model){
        model.addAttribute("username", user.username);
        return "user";
    }

    @Data
    private static class User{
        String username;
    }
}
