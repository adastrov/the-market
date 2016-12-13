package market.pavelpadalka.u.com.gitlab.controller.admin.user;

import market.pavelpadalka.u.com.gitlab.dto.UserDTO;
import market.pavelpadalka.u.com.gitlab.service.api.UserService;
import market.pavelpadalka.u.com.gitlab.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet({"/users-list"})
public class ListActionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserService userService = UserServiceImpl.getInstance();

        List<UserDTO> userDTOList = userService.findAll();

        req.getSession().setAttribute("users", userDTOList);

        req.getRequestDispatcher("pages/admin/users-list.jsp").include(req, resp);
    }
}
