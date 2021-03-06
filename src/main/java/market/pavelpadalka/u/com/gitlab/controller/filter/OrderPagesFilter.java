package market.pavelpadalka.u.com.gitlab.controller.filter;

import market.pavelpadalka.u.com.gitlab.entity.UserRoleEnum;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;

import java.io.IOException;
import java.util.LinkedList;

@WebFilter("/order/*")
public class OrderPagesFilter implements Filter {

    private LinkedList<String> userRoleList = new LinkedList<String>();

    public void init(FilterConfig filterConfig) throws ServletException {

        userRoleList.add(UserRoleEnum.USER.toString().toLowerCase());
        userRoleList.add(UserRoleEnum.ADMIN.toString().toLowerCase());
        userRoleList.add(UserRoleEnum.CONTENT_MANAGER.toString().toLowerCase());

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        MainFilter.doFilter(userRoleList, servletRequest, servletResponse, filterChain);

    }

    public void destroy() {

    }

}
