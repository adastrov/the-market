package market.pavelpadalka.u.com.gitlab.controller;

import market.pavelpadalka.u.com.gitlab.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/index"})
public class IndexActionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = new User();
        user.setLogin("pauladastrov");

        req.setAttribute("user", null);

        req.getRequestDispatcher("pages/index.jsp").include(req, resp);
    }
}
