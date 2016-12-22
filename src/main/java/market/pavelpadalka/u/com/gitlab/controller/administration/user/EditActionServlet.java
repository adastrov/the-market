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

@WebServlet({"/admin/user-edit"})
public class EditActionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserService userService = UserServiceImpl.getInstance();

        String  userId = req.getParameter("id");

        UserDTO userDTO = userService.findById(Integer.valueOf(userId));

        if (userDTO==null) {
            req.setAttribute("error", "User hasn't been deleted! Internal error");
            resp.sendRedirect("/admin/users-list");
            return;
        }

        req.setAttribute("error", null);
        req.setAttribute("userForEditing", userDTO);
        req.setAttribute("userSexName",    userDTO.getSex().equals(UserSex.MALE) ? "MALE" : "FEMALE");
        req.setAttribute("userRoleId",     userDTO.getRole().getId());

        req.getRequestDispatcher("/pages/admin/user-edit.jsp").include(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserService     userService     = UserServiceImpl.getInstance();
        UserRoleService userRoleService = UserRoleServiceImpl.getInstance();

        String  id        = req.getParameter("id");
        String  login     = req.getParameter("username");
        String  password  = req.getParameter("password");
        String  email     = req.getParameter("email");
        String  role      = req.getParameter("role");
        String  firstName = req.getParameter("firstName");
        String  lastName  = req.getParameter("lastName");
        String  birthday  = req.getParameter("birthday");
        String  sex       = req.getParameter("sex");

        UserDTO userDTO         = userService.findById(Integer.valueOf(id));
        UserRoleDTO userRoleDTO = userRoleService.findByName(role);

        if (userDTO==null || userRoleDTO==null) {

            System.out.println("и тут крутой лог...");

            req.setAttribute("error", "Internal server error!");
            req.getRequestDispatcher("/pages/admin/users-list.jsp").include(req, resp);
            return;
        }

        userDTO.setLogin(login);
        userDTO.setPassword(password);
        userDTO.setFirstName(firstName);
        userDTO.setLastName(lastName);
        userDTO.setBirthday(Date.valueOf(birthday));
        userDTO.setSex(sex.equals("male") ? UserSex.MALE : UserSex.FEMALE);
        userDTO.setEmail(email);
        userDTO.setRole(userRoleDTO);

        UserDTO updatedUserDTO = userService.update(userDTO);

        if (updatedUserDTO==null) {
            req.setAttribute("error", "User hasn't been updated! Internal error");
            req.getRequestDispatcher("/pages/admin/users-list.jsp").include(req, resp);
            return;
        }

        resp.sendRedirect("/admin/users-list");

    }
}
