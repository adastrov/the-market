package market.pavelpadalka.u.com.gitlab.controller.content.product.view;

import market.pavelpadalka.u.com.gitlab.dto.ProductDTO;
import market.pavelpadalka.u.com.gitlab.service.api.ProductService;
import market.pavelpadalka.u.com.gitlab.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@WebServlet({"/product-list"})
public class ProductListActionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ProductService productService = ProductServiceImpl.getInstance();

        List<ProductDTO> productDTOList = productService.findAllAvailable();

        req.getSession().setAttribute("products", productDTOList);

        req.getRequestDispatcher("/pages/product/product-list.jsp").include(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ProductService productService = ProductServiceImpl.getInstance();

        String  id = req.getParameter("id");

        ProductDTO productDTO = productService.findProductById(Integer.valueOf(id));

        if (productDTO==null) {
            req.setAttribute("error", "Internal server error");
            resp.sendRedirect("/pages/product/product-list");
            return;
        }

        HttpSession session = req.getSession(false);

        LinkedList<ProductDTO> resUserBasket = new LinkedList<ProductDTO>();

        Object userBasket = session.getAttribute("userBasket");

        if (userBasket == null) {
            resUserBasket.add(productDTO);
        } else {
            resUserBasket = (LinkedList<ProductDTO>) userBasket;
            resUserBasket.add(productDTO);
        }

        session.setAttribute("userBasket", resUserBasket);
        session.setAttribute("countOfProductsInBasket", resUserBasket.size());

        req.getRequestDispatcher("/pages/product/product-list.jsp").include(req, resp);

    }

}
