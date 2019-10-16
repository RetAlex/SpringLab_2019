package oleksii.epam.lab.spring2019.mvc.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
        return "NotView";
    }

    @GetMapping("/object")
    public Object getObject(){
        return new DummyObject("name", 20);
    }

    @RequestMapping(value = "/image", method = RequestMethod.GET, produces = "image/png")
    public byte[] getRestImage() throws IOException {
        return context.getResource("classpath:assets/internalImages/image.png").getInputStream().readAllBytes();
    }

    @Data
    @AllArgsConstructor
    private static class DummyObject{
        private String name;
        private int age;
    }
}
