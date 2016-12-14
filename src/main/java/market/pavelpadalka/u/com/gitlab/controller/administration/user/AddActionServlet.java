package market.pavelpadalka.u.com.gitlab.controller.administration.user;

import market.pavelpadalka.u.com.gitlab.dto.UserDTO;
import market.pavelpadalka.u.com.gitlab.dto.UserRoleDTO;
import market.pavelpadalka.u.com.gitlab.entity.UserSex;
import market.pavelpadalka.u.com.gitlab.service.api.UserRoleService;
import market.pavelpadalka.u.com.gitlab.service.api.UserService;
import market.pavelpadalka.u.com.gitlab.service.impl.UserRoleServiceImpl;
import market.pavelpadalka.u.com.gitlab.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;

@WebServlet({"/user-add"})
public class AddActionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("pages/users-list.jsp").include(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserService userService = UserServiceImpl.getInstance();
        UserRoleService userRoleService = UserRoleServiceImpl.getInstance();

        HttpSession session = req.getSession();

        String  login           = req.getParameter("username");
        String  email           = req.getParameter("email");
        String  password        = req.getParameter("password");
        String  role            = req.getParameter("role");
        String  firstName       = req.getParameter("firstName");
        String  lastName        = req.getParameter("lastName");
        String  birthday        = req.getParameter("birthday");
        String  sex             = req.getParameter("sex");
        String  error;

        UserDTO user = userService.findByLoginAndEmail(login, email);

        if (user!=null) {
            error = "This user has already been registered!";

            session.setAttribute("user",  null);
            session.setAttribute("error", error);

            req.getRequestDispatcher("pages/users-list.jsp").include(req, resp);
            return;

        }

        UserRoleDTO userRole = userRoleService.findByName(role);

        UserDTO userDTO = new UserDTO();

        userDTO.setLogin(login);
        userDTO.setPassword(password);
        userDTO.setFirstName(firstName);
        userDTO.setLastName(lastName);
        userDTO.setBirthday(Date.valueOf(birthday));
        userDTO.setSex(sex.equals("male") ? UserSex.MALE : UserSex.FEMALE);
        userDTO.setEmail(email);
        userDTO.setRole(userRole);

        UserDTO createdUser = userService.create(userDTO);

        if (createdUser==null) {
            error = "User hasn't been registered! Internal error";

            session.setAttribute("user",  null);
            session.setAttribute("error", error);

        }

        resp.sendRedirect("/users-list");

    }

}
