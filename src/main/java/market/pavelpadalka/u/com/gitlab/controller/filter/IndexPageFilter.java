package market.pavelpadalka.u.com.gitlab.controller.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter("/index")
public class IndexPageFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        MainFilter.doFilter(null, servletRequest, servletResponse, filterChain);

    }

    public void destroy() {

    }
}
