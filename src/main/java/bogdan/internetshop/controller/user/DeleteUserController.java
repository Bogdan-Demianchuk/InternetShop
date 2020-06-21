package bogdan.internetshop.controller.user;

import bogdan.internetshop.lib.Injector;
import bogdan.internetshop.service.UserService;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteUserController extends HttpServlet {
    private static final Injector INJECTOR = Injector.getInstance("mate.academy.internetshop");
    private UserService userService = (UserService) INJECTOR.getInstance(UserService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        String useriId = req.getParameter("id");
        Long id = Long.valueOf(useriId);
        userService.delete(id);
        resp.sendRedirect(req.getContextPath() + "/users");
    }
}
