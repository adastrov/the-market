package market.pavelpadalka.u.com.gitlab.controller.autentif;

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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

        UserService     userService     = UserServiceImpl.getInstance();
        UserRoleService userRoleService = UserRoleServiceImpl.getInstance();

        String  login           = req.getParameter("username");
        String  firstName       = req.getParameter("firstName");
        String  lastName        = req.getParameter("lastName");
        String  birthday        = req.getParameter("birthday");
        String  password        = req.getParameter("password");
        String  passwordConfirm = req.getParameter("passwordConfirm");
        String  sex             = req.getParameter("sex");
        String  email           = req.getParameter("email");

        if (!password.equals(passwordConfirm)) {

            req.setAttribute("user",  null);
            req.setAttribute("error", "Both of passwords must be equal!");

            req.getRequestDispatcher("pages/authentication/register.jsp").include(req, resp);
            return;
        }

        UserDTO user = userService.findByLoginAndEmail(login, email);

        if (user!=null) {

            req.setAttribute("user",  null);
            req.setAttribute("error", "This user has already been registered!");

            req.getRequestDispatcher("pages/authentication/register.jsp").include(req, resp);
            return;
        }

        UserRoleDTO userRoleDTO = userRoleService.findByName(UserRoleEnum.USER.name());
        UserDTO userDTO         = new UserDTO();

        userDTO.setLogin(login);
        userDTO.setPassword(password);
        userDTO.setFirstName(firstName);
        userDTO.setLastName(lastName);
        userDTO.setBirthday(Date.valueOf(birthday));
        userDTO.setSex(sex.equals("male") ? UserSex.MALE : UserSex.FEMALE);
        userDTO.setEmail(email);
        userDTO.setRole(userRoleDTO);

        UserDTO createdUser = userService.create(userDTO);

        if (createdUser==null || userRoleDTO == null) {

            req.setAttribute("user",  null);
            req.setAttribute("error", "User hasn't been registered! Internal error");

            req.getRequestDispatcher("pages/authentication/register.jsp").include(req, resp);
            return;
        }

        req.setAttribute("error", null);
        req.setAttribute("user",  createdUser);

        Cookie loginCookie = new Cookie("username", login);
        Cookie pwdCookie   = new Cookie("password", password);

        resp.addCookie(loginCookie);
        resp.addCookie(pwdCookie);

        req.getRequestDispatcher("/pages/index.jsp").include(req, resp);

    }

}
