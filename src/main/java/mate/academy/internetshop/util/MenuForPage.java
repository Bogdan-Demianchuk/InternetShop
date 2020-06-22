package mate.academy.internetshop.util;

import mate.academy.internetshop.model.Role;
import mate.academy.internetshop.service.UserService;
import javax.servlet.http.HttpServletRequest;

public class MenuForPage {
    public static void menuSelection(HttpServletRequest req, String userId2,
                                     UserService userService) {
        Long userId = (Long) req.getSession().getAttribute(userId2);
        String menu = "menunotlog.jsp";
        if (userId != null && userService.get(userId) != null) {
            if (userService.get(userId).getRoles().contains(Role.of("ADMIN"))) {
                menu = "menuadmin.jsp";
            } else {
                menu = "menu.jsp";
            }
            req.setAttribute("menus", menu);
        }
        req.setAttribute("menus", menu);
    }

}
