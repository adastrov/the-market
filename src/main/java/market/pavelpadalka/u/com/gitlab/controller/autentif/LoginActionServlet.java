package market.pavelpadalka.u.com.gitlab.controller.autentif;

import market.pavelpadalka.u.com.gitlab.dto.UserDTO;
import market.pavelpadalka.u.com.gitlab.entity.User;
import market.pavelpadalka.u.com.gitlab.service.api.UserService;
import market.pavelpadalka.u.com.gitlab.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet({"/login"})
public class LoginActionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("pages/authentication/login.jsp").include(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserService userService = UserServiceImpl.getInstance();

        String login    = req.getParameter("username");
        String password = req.getParameter("password");

        UserDTO user = userService.findByLoginAndPassword(login, password);

        HttpSession session = req.getSession();
        session.setAttribute("user", user);
        session.setAttribute("error", user==null ? null : "Wrong username or password!");

        if (user!=null) {
            req.getRequestDispatcher("pages/index.jsp").include(req, resp);
        } else {
            req.getRequestDispatcher("pages/authentication/login.jsp").include(req, resp);
        }

    }
}
