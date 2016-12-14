package market.pavelpadalka.u.com.gitlab.controller.content.product.crud;

import market.pavelpadalka.u.com.gitlab.service.api.ProductService;
import market.pavelpadalka.u.com.gitlab.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet({"/product-delete"})
public class DeleteActionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String error;

        ProductService productService = ProductServiceImpl.getInstance();
        HttpSession session = req.getSession();

        String  id = req.getParameter("id");

        Boolean result = productService.deleteProduct(Integer.valueOf(id));

        if (!result) {
            error = "Product hasn't been deleted! Internal error";
            session.setAttribute("error", error);
        }

        resp.sendRedirect("/product-list-edit");

    }

}
