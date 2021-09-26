package org.launchcode.Liftoff.Project.Restaurant.App;

import org.launchcode.Liftoff.Project.Restaurant.App.controllers.AuthenticationController;
import org.launchcode.Liftoff.Project.Restaurant.App.data.UserRepository;
import org.launchcode.Liftoff.Project.Restaurant.App.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AuthenticationFilter implements HandlerInterceptor {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationController authenticationController;

    private static final List<String> blacklist = Arrays.asList("/restaurant", "/review");

    private static boolean isBlacklisted(String path) {
        for (String pathRoot : blacklist) {
            if (path.startsWith(pathRoot)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws IOException {

        if (isBlacklisted(request.getRequestURI())) {
            return true;
        }

        HttpSession session = request.getSession();
        User user = authenticationController.getUserFromSession(session);

        if (user != null) {
            return true;
        }

        response.sendRedirect("/login");
        return false;
    }
}
