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

@WebServlet({"/user-edit"})
public class EditActionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserService userService = UserServiceImpl.getInstance();
        HttpSession session     = req.getSession();

        String  id = req.getParameter("id");

        UserDTO userDTO = userService.findById(Integer.valueOf(id));

        session.setAttribute("userForEditing", userDTO);
        session.setAttribute("userSexName", userDTO.getSex().equals(UserSex.MALE) ? "MALE" : "FEMALE");
        session.setAttribute("userRoleId",  userDTO.getRole().getId());

        req.getRequestDispatcher("pages/admin/user-edit.jsp").include(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserService userService = UserServiceImpl.getInstance();
        UserRoleService userRoleService = UserRoleServiceImpl.getInstance();

        HttpSession session = req.getSession();

        String  id        = req.getParameter("id");
        String  login     = req.getParameter("username");
        String  password  = req.getParameter("password");
        String  email     = req.getParameter("email");
        String  role      = req.getParameter("role");
        String  firstName = req.getParameter("firstName");
        String  lastName  = req.getParameter("lastName");
        String  birthday  = req.getParameter("birthday");
        String  sex       = req.getParameter("sex");
        String  error;

        UserDTO userDTO = userService.findById(Integer.valueOf(id));

        if (userDTO==null) {
            error = "Internal server error!";

            System.out.println("и тут крутой лог...");

            session.setAttribute("error", error);
            req.getRequestDispatcher("pages/users-list.jsp").include(req, resp);
            return;
        }

        UserRoleDTO userRole = userRoleService.findByName(role);

        userDTO.setLogin(login);
        userDTO.setPassword(password);
        userDTO.setFirstName(firstName);
        userDTO.setLastName(lastName);
        userDTO.setBirthday(Date.valueOf(birthday));
        userDTO.setSex(sex.equals("male") ? UserSex.MALE : UserSex.FEMALE);
        userDTO.setEmail(email);
        userDTO.setRole(userRole);

        UserDTO updatedUser = userService.update(userDTO);

        if (updatedUser==null) {
            error = "User hasn't been updated! Internal error";
            session.setAttribute("error", error);
        }

        resp.sendRedirect("/users-list");

    }
}
