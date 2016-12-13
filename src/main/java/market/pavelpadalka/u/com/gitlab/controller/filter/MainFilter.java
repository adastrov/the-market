package market.pavelpadalka.u.com.gitlab.controller.filter;

import market.pavelpadalka.u.com.gitlab.dto.UserDTO;
import market.pavelpadalka.u.com.gitlab.dto.UserRoleDTO;
import market.pavelpadalka.u.com.gitlab.entity.User;
import market.pavelpadalka.u.com.gitlab.entity.UserRoleEnum;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@WebFilter("/*")
public class MainFilter implements Filter {


    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        List<String> forbiddenForUserUrlList = new LinkedList<String>();

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        HttpSession session = request.getSession(false);

        forbiddenForUserUrlList.add("/user-edit");
        forbiddenForUserUrlList.add("/users-list");

        String url = request.getServletPath();

        if(forbiddenForUserUrlList.contains(url)) {

            if (session == null) {
                HttpServletResponse response = (HttpServletResponse) servletResponse;
                response.sendRedirect("/access-denied");
            } else if (session.getAttribute("user") == null) {
                HttpServletResponse response = (HttpServletResponse) servletResponse;
                response.sendRedirect("/access-denied");
            } else {
                UserDTO userDTO = (UserDTO) session.getAttribute("user");

                UserRoleDTO userRoleDTO = userDTO.getRole();

                if(!userRoleDTO.getName().equals(UserRoleEnum.ADMIN.toString().toLowerCase())) {
                    HttpServletResponse response = (HttpServletResponse) servletResponse;
                    response.sendRedirect("/access-denied");
                }
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);

    }

    public void destroy() {

    }
}
