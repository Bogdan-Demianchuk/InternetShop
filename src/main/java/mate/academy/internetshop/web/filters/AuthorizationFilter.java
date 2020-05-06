package mate.academy.internetshop.web.filters;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.academy.internetshop.controller.user.UsersController;
import mate.academy.internetshop.lib.Injector;
import mate.academy.internetshop.model.Role;
import mate.academy.internetshop.model.User;
import mate.academy.internetshop.service.UserService;
import org.apache.log4j.Logger;

public class AuthorizationFilter implements Filter {
    private static final Logger LOGGER = Logger.getLogger(UsersController.class);
    private static final String USER_ID = "user_id";
    private static final Injector INJECTOR = Injector.getInstance("mate.academy.internetshop");
    private UserService userService = (UserService) INJECTOR.getInstance(UserService.class);
    private Map<String, Set<Role.RoleName>> protectedUrls = new HashMap<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        protectedUrls.put("/products/add", Set.of(Role.RoleName.ADMIN));
        protectedUrls.put("/users/all", Set.of(Role.RoleName.ADMIN));
        protectedUrls.put("/deleteUser", Set.of(Role.RoleName.ADMIN));
        protectedUrls.put("/deleteProduct", Set.of(Role.RoleName.ADMIN));
        protectedUrls.put("allcards", Set.of(Role.RoleName.ADMIN));
        protectedUrls.put("/deleteorder", Set.of(Role.RoleName.ADMIN));
        protectedUrls.put("/shoppingcart", Set.of(Role.RoleName.USER));
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String requestedUrl = req.getServletPath();
        if (protectedUrls.get(requestedUrl) == null) {
            chain.doFilter(req, resp);
            return;
        }

        Long userId = (Long) req.getSession().getAttribute(USER_ID);
        if (userId == null || userService.get(userId) == null) {
            resp.sendRedirect("/login");
            return;
        }
        User user = userService.get(userId);
        if (isAuthorised(user, protectedUrls.get(requestedUrl))) {
            chain.doFilter(req, resp);
        } else {
            req.getRequestDispatcher("/WEB-INF/views/accessProhibited.jsp").forward(req, resp);
            LOGGER.warn(user.getName() + " with id " + user.getUserId()
                    + " chose the wrong path " + requestedUrl);

        }
    }

    @Override
    public void destroy() {
    }

    private boolean isAuthorised(User user, Set<Role.RoleName> authorizerRoles) {
        for (Role.RoleName authorizerRole : authorizerRoles) {
            for (Role userRole : user.getRoles()) {
                if (authorizerRole.equals(userRole.getRoleName())) {
                    return true;
                }
            }
        }
        return false;
    }
}
