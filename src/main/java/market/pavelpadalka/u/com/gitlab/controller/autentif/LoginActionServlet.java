package market.pavelpadalka.u.com.gitlab.controller.autentif;

import market.pavelpadalka.u.com.gitlab.dto.UserDTO;
import market.pavelpadalka.u.com.gitlab.entity.UserRoleEnum;
import market.pavelpadalka.u.com.gitlab.service.api.UserService;
import market.pavelpadalka.u.com.gitlab.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

import static market.pavelpadalka.u.com.gitlab.entity.UserRoleEnum.ADMIN;

@WebServlet({"/login"})
public class LoginActionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("doNotShowRegisterAndIncomeButtons", true);
        req.getRequestDispatcher("/pages/authentication/login.jsp").include(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserService userService = UserServiceImpl.getInstance();

        UserDTO userDTO;

        String login    = req.getParameter("username");
        String password = req.getParameter("password");

        userDTO = userService.findByLoginAndPassword(login, password);

        if (userDTO==null) {
            req.setAttribute("error", "Wrong username or password!");
            req.setAttribute("doNotShowRegisterAndIncomeButtons", true);
            req.getRequestDispatcher("/pages/authentication/login.jsp").include(req, resp);
            return;
        }

        HttpSession session = req.getSession();

        req.setAttribute("doNotShowRegisterAndIncomeButtons", null);

        req.setAttribute("error", null);
        session.setAttribute("user",  userDTO);
        session.setAttribute("currentUserAdmin", userDTO.getRole().getName().toLowerCase().equals(ADMIN.toString().toLowerCase()));

        Cookie loginCookie = new Cookie("username", login);
        Cookie pwdCookie   = new Cookie("password", password);

        resp.addCookie(loginCookie);
        resp.addCookie(pwdCookie);

        req.getRequestDispatcher("/pages/index.jsp").include(req, resp);

    }
}
