package market.pavelpadalka.u.com.gitlab.controller.autentif;

import market.pavelpadalka.u.com.gitlab.dto.UserDTO;
import market.pavelpadalka.u.com.gitlab.entity.UserRoleEnum;
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

    private final static String ADMIN = UserRoleEnum.ADMIN.toString().toLowerCase();

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
        session.setAttribute("currentUserAdmin", userDTO.getRole().getName().toLowerCase().equals(ADMIN));

        req.getRequestDispatcher("/pages/index.jsp").include(req, resp);

    }
}
