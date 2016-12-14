package market.pavelpadalka.u.com.gitlab.controller.administration.user;

import market.pavelpadalka.u.com.gitlab.service.api.UserService;
import market.pavelpadalka.u.com.gitlab.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet({"/user-delete"})
public class DeleteActionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String error;

        UserService userService = UserServiceImpl.getInstance();
        HttpSession session = req.getSession();

        String  id = req.getParameter("id");

        Boolean result = userService.delete(Integer.valueOf(id));

        if (!result) {
            error = "User hasn't been deleted! Internal error";
            session.setAttribute("error", error);
        }

        resp.sendRedirect("/users-list");

    }

}
