package market.pavelpadalka.u.com.gitlab.controller.filter;

import market.pavelpadalka.u.com.gitlab.dto.UserDTO;
import market.pavelpadalka.u.com.gitlab.dto.UserRoleDTO;
import market.pavelpadalka.u.com.gitlab.service.api.UserService;
import market.pavelpadalka.u.com.gitlab.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedList;

import static market.pavelpadalka.u.com.gitlab.entity.UserRoleEnum.ADMIN;

public class MainFilter {

    private MainFilter() {
    }

    public static void doFilter(LinkedList<String> userRoleName, ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request   = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession(false);

        getDataFromCookies(session, request);

        if (userRoleName==null) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("/access-denied");
            return;
        }

        UserDTO     userDTO     = (UserDTO) session.getAttribute("user");
        UserRoleDTO userRoleDTO = userDTO.getRole();

        if (!userRoleName.contains(userRoleDTO.getName())) {
            response.sendRedirect("/access-denied");
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);

    }

    private static void getDataFromCookies(HttpSession session, HttpServletRequest request) {

        if (session == null || session.getAttribute("user") == null) {

            Cookie[] cookies   = request.getCookies();
            String loginCookie = null;
            String pwdCookie   = null;

            if(cookies != null) {
                for (Cookie cookie : cookies) {
                    String name = cookie.getName();
                    String value = cookie.getValue();

                    if (name.equals("username")) {
                        loginCookie = value;
                    }
                    if (name.equals("password")) {
                        pwdCookie = value;
                    }
                }
            }

            if (loginCookie!=null && pwdCookie!=null) {

                UserService userService = UserServiceImpl.getInstance();

                UserDTO userDTO = userService.findByLoginAndPassword(loginCookie, pwdCookie);

                if (userDTO!=null) {
                    session = request.getSession();

                    request.setAttribute("doNotShowRegisterAndIncomeButtons", null);

                    request.setAttribute("error", null);
                    session.setAttribute("user",  userDTO);
                    session.setAttribute("currentUserAdmin", userDTO.getRole().getName().toLowerCase().equals(ADMIN.toString().toLowerCase()));

                    session.setAttribute("user", userDTO);

                }

            }

        }

    }

}
