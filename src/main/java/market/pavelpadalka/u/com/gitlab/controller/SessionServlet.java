package market.pavelpadalka.u.com.gitlab.controller;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet
public class SessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        session.setAttribute("hello", "world");
        session.setMaxInactiveInterval(30);

        if (session.isNew()) {
            session.setAttribute("newSession", 30);
            System.out.println("newSession");
        }else {
            session.setAttribute("oldSession", 30);
            System.out.println("oldSession");
        }


    }
}
