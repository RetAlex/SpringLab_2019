package oleksii.epam.lab.spring2019.mvc.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/rest")
public class RestControllerExample {
    private final ApplicationContext context;

    public RestControllerExample(ApplicationContext context) {
        this.context = context;
    }

    @GetMapping("/secret")
    public String getPhrase(){
        return "redirect:/anotherUrl";
    }

    @GetMapping("/object")
    public Object getObject(HttpServletResponse response){
        return new DummyObject("name", 20);
    }

    @RequestMapping(value = "/image", method = RequestMethod.GET, produces = "image/png")
    public byte[] getRestImage() throws IOException {
        return context.getResource("classpath:assets/internalImages/image.png").getInputStream().readAllBytes();
    }
    @ExceptionHandler(NotAuthorizedException.class)
    public void handle(){

    }

    @Data
    @AllArgsConstructor
    private static class DummyObject{
        private String name;
        private int age;
    }
    @ResponseStatus(code = HttpStatus.FORBIDDEN)
    private static class NotAuthorizedException extends RuntimeException{

    }
}
