package market.pavelpadalka.u.com.gitlab.controller.admin.user;

import market.pavelpadalka.u.com.gitlab.dto.UserDTO;
import market.pavelpadalka.u.com.gitlab.dto.UserRoleDTO;
import market.pavelpadalka.u.com.gitlab.entity.UserRoleEnum;
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

@WebServlet({"/register"})
public class RegisterActionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("pages/authentication/register.jsp").include(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserService userService = UserServiceImpl.getInstance();
        UserRoleService userRoleService = UserRoleServiceImpl.getInstance();

        HttpSession session = req.getSession();

        String  login           = req.getParameter("username");
        String  firstName       = req.getParameter("firstName");
        String  lastName        = req.getParameter("lastName");
        String  birthday        = req.getParameter("birthday");
        String  password        = req.getParameter("password");
        String  passwordConfirm = req.getParameter("passwordConfirm");
        String  sex             = req.getParameter("sex");
        String  email           = req.getParameter("email");
        String  error;

        session.setAttribute("firstName", firstName);
        session.setAttribute("lastName",  lastName);
        session.setAttribute("birthday",  birthday);
        session.setAttribute("username",  login);
        session.setAttribute("password",  password);
        session.setAttribute("passwordConfirm", passwordConfirm);
        session.setAttribute("sex",   sex);
        session.setAttribute("email", email);

        if (!password.equals(passwordConfirm)) {
            error = "Both of passwords must be equal!";

            session.setAttribute("user",  null);
            session.setAttribute("error", error);

            req.getRequestDispatcher("pages/authentication/register.jsp").include(req, resp);
            return;
        }

        UserDTO user = userService.findByLoginAndEmail(login, email);

        if (user!=null) {
            error = "This user has already been registered!";

            session.setAttribute("user",  null);
            session.setAttribute("error", error);

            req.getRequestDispatcher("pages/authentication/register.jsp").include(req, resp);
            return;

        }

        UserRoleDTO userRole = userRoleService.findByName(UserRoleEnum.USER.name());

        if(userRole == null) {
            error = "User hasn't been registered! Internal error";

            session.setAttribute("user",  null);
            session.setAttribute("error", error);

            req.getRequestDispatcher("pages/authentication/register.jsp").include(req, resp);

            System.out.println("Мой супер лог...");

            return;
        }

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

            req.getRequestDispatcher("pages/authentication/register.jsp").include(req, resp);
            return;
        }

        session.setAttribute("user",  createdUser);
        session.setAttribute("error", null);

        session.setAttribute("firstName", null);
        session.setAttribute("lastName",  null);
        session.setAttribute("birthday",  null);
        session.setAttribute("username",  null);
        session.setAttribute("password",  null);
        session.setAttribute("passwordConfirm", null);
        session.setAttribute("sex",   null);
        session.setAttribute("email", null);

        req.getRequestDispatcher("pages/index.jsp").include(req, resp);

    }

}
