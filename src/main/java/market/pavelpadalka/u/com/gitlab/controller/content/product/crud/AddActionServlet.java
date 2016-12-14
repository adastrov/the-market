package market.pavelpadalka.u.com.gitlab.controller.content.product.crud;

import market.pavelpadalka.u.com.gitlab.dto.ProductDTO;
import market.pavelpadalka.u.com.gitlab.dto.ProductGroupDTO;
import market.pavelpadalka.u.com.gitlab.service.api.ProductGroupService;
import market.pavelpadalka.u.com.gitlab.service.api.ProductService;
import market.pavelpadalka.u.com.gitlab.service.impl.ProductGroupServiceImpl;
import market.pavelpadalka.u.com.gitlab.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet({"/product-add"})
public class AddActionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("pages/content/product-list-edit.jsp").include(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ProductService productService = ProductServiceImpl.getInstance();
        ProductGroupService productGroupService = ProductGroupServiceImpl.getInstance();
        HttpSession session = req.getSession();

        String  title        = req.getParameter("title");
        String  description  = req.getParameter("description");
        String  productGroup = req.getParameter("productGroup");
        String  price        = req.getParameter("price");
        String  count        = req.getParameter("count");
        String  error;

        ProductDTO productDTO = new ProductDTO();

        ProductGroupDTO productGroupDTO = productGroupService.findProductGroupById(Integer.valueOf(productGroup));

        productDTO.setTitle(title);
        productDTO.setDescription(description);
        productDTO.setProductGroups(productGroupDTO);
        productDTO.setPrice(Double.valueOf(price));
        productDTO.setCount(Integer.valueOf(count));

        ProductDTO createdProduct = productService.create(productDTO);

        if (createdProduct==null) {
            error = "Product hasn't been registered! Internal error";
            session.setAttribute("error", error);
        }

        resp.sendRedirect("/product-list-edit");

    }

}
