package market.pavelpadalka.u.com.gitlab.controller.administration.user;

import market.pavelpadalka.u.com.gitlab.service.api.UserService;
import market.pavelpadalka.u.com.gitlab.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/admin/user-delete"})
public class DeleteActionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String error = null;

        UserService userService = UserServiceImpl.getInstance();

        String  id = req.getParameter("id");

        Boolean result = userService.delete(Integer.valueOf(id));

        if (!result) {
            error = "User hasn't been deleted! Internal error";
        }

        req.setAttribute("error", error);
        resp.sendRedirect("/admin/users-list");

    }

}
