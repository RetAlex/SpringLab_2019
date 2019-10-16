package oleksii.epam.lab.spring2019.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ModelAndViewController {
    @GetMapping("/")
    public ModelAndView getIndex(ModelAndView mav){
        mav.setViewName("index");
        return mav;
    }
}
