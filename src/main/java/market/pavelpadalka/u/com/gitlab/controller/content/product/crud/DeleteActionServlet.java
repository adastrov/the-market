package market.pavelpadalka.u.com.gitlab.controller.content.product.crud;

import market.pavelpadalka.u.com.gitlab.service.api.ProductService;
import market.pavelpadalka.u.com.gitlab.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/content/product-delete"})
public class DeleteActionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String error = null;

        ProductService productService = ProductServiceImpl.getInstance();

        String  id = req.getParameter("id");

        Boolean result = productService.deleteProduct(Integer.valueOf(id));

        if (!result) {
            error = "Product hasn't been deleted! Internal error";
        }

        req.setAttribute("error", error);
        resp.sendRedirect("/content/product-list-edit");

    }

}
