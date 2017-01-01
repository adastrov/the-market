package market.pavelpadalka.u.com.gitlab.controller.autentif;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet({"/logout"})
public class LogOutActionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        session.setAttribute("user", null);
        session.setAttribute("currentUserAdmin", false);

        Cookie loginCookie = new Cookie("username", null);
        Cookie pwdCookie   = new Cookie("password", null);

        resp.addCookie(loginCookie);
        resp.addCookie(pwdCookie);

        req.getRequestDispatcher("/pages/index.jsp").include(req, resp);

    }
}
