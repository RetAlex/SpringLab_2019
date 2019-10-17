package oleksii.epam.lab.spring2019.mvc._config;

import oleksii.epam.lab.spring2019.mvc.controllers.ModelController;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Interceptor implements HandlerInterceptor {
    private final ModelController modelController;

    public Interceptor(ModelController modelController) {
        this.modelController = modelController;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return false;
    }
}
