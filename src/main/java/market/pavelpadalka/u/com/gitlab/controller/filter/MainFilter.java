package market.pavelpadalka.u.com.gitlab.controller.filter;

import market.pavelpadalka.u.com.gitlab.dto.UserDTO;
import market.pavelpadalka.u.com.gitlab.dto.UserRoleDTO;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedList;

public class MainFilter {

    private MainFilter() {
    }

    public static void doFilter(LinkedList<String> userRoleName, ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request   = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession(false);

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

}
