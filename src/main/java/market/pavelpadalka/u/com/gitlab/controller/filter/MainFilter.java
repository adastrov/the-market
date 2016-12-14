package market.pavelpadalka.u.com.gitlab.controller.filter;

import market.pavelpadalka.u.com.gitlab.dto.UserDTO;
import market.pavelpadalka.u.com.gitlab.dto.UserRoleDTO;
import market.pavelpadalka.u.com.gitlab.entity.UserRoleEnum;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@WebFilter("/*")
public class MainFilter implements Filter {

    private final static String USER            = UserRoleEnum.USER.toString().toLowerCase();
    private final static String GUEST           = UserRoleEnum.GUEST.toString().toLowerCase();
    private final static String CONTENT_MANAGER = UserRoleEnum.CONTENT_MANAGER.toString().toLowerCase();

    private static List<String> accessForbiddenUrlForUser    = new LinkedList<String>();
    private static List<String> accessForbiddenUrlForGuest   = new LinkedList<String>();
    private static List<String> accessForbiddenUrlForContMan = new LinkedList<String>();

    private static Map<String, List<String>> roleAccessHashMap = new HashMap<String, List<String>>();

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public void init(FilterConfig filterConfig) throws ServletException {

        accessForbiddenUrlForUser.add("/users-list");
        accessForbiddenUrlForUser.add("/user-add");
        accessForbiddenUrlForUser.add("/user-edit");
        accessForbiddenUrlForUser.add("/user-delete");

        accessForbiddenUrlForUser.add("/product-add");
        accessForbiddenUrlForUser.add("/product-edit");
        accessForbiddenUrlForUser.add("/product-delete");
        accessForbiddenUrlForUser.add("/product-list-edit");

        accessForbiddenUrlForGuest.addAll(accessForbiddenUrlForUser);

        accessForbiddenUrlForContMan.add("/users-list");
        accessForbiddenUrlForContMan.add("/user-add");
        accessForbiddenUrlForContMan.add("/user-edit");
        accessForbiddenUrlForContMan.add("/user-delete");

        roleAccessHashMap.put(USER,            accessForbiddenUrlForUser);
        roleAccessHashMap.put(GUEST,           accessForbiddenUrlForGuest);
        roleAccessHashMap.put(CONTENT_MANAGER, accessForbiddenUrlForContMan);

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        HttpSession session = request.getSession(false);

        String url = request.getServletPath();

        if(accessForbiddenUrlForUser.contains(url)
                || accessForbiddenUrlForGuest.contains(url)
                    || accessForbiddenUrlForContMan.contains(url)) {

            if (session == null) {

                HttpServletResponse response = (HttpServletResponse) servletResponse;
                response.sendRedirect("/access-denied");

            } else if (session.getAttribute("user") == null) {

                HttpServletResponse response = (HttpServletResponse) servletResponse;
                response.sendRedirect("/access-denied");

            } else {

                UserDTO     userDTO     = (UserDTO) session.getAttribute("user");
                UserRoleDTO userRoleDTO = userDTO.getRole();

                if(roleAccessHashMap.containsKey(userRoleDTO.getName())
                        && roleAccessHashMap.get(userRoleDTO.getName()).contains(url)) {

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
