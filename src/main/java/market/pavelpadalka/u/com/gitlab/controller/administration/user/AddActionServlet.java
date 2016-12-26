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
import java.io.IOException;
import java.sql.Date;

@WebServlet({"/admin/user-add"})
public class AddActionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/pages/admin/content/users-list.jsp").include(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserService     userService     = UserServiceImpl.getInstance();
        UserRoleService userRoleService = UserRoleServiceImpl.getInstance();

        String  login           = req.getParameter("username");
        String  email           = req.getParameter("email");
        String  password        = req.getParameter("password");
        String  role            = req.getParameter("role");
        String  firstName       = req.getParameter("firstName");
        String  lastName        = req.getParameter("lastName");
        String  birthday        = req.getParameter("birthday");
        String  sex             = req.getParameter("sex");

        UserDTO user = userService.findByLoginAndEmail(login, email);

        if (user!=null) {

            req.setAttribute("user",  null);
            req.setAttribute("error", "This user has already been registered!");

            req.getRequestDispatcher("/pages/admin/users-list.jsp").include(req, resp);
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

            req.setAttribute("user",  null);
            req.setAttribute("error", "User hasn't been registered! Internal error");

        }

        req.setAttribute("error", null);

        req.getRequestDispatcher("/admin/users-list").include(req, resp);

    }

}
