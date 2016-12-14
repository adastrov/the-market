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
import java.io.IOException;
import java.util.List;

@WebServlet({"/product-list-edit"})
public class ListActionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ProductGroupService productGroupService = ProductGroupServiceImpl.getInstance();
        ProductService productService           = ProductServiceImpl.getInstance();

        List<ProductGroupDTO> productGroupList = productGroupService.findAll();
        List<ProductDTO> productDTOList        = productService.findAll();

        req.getSession().setAttribute("productGroups", productGroupList);
        req.getSession().setAttribute("products",      productDTOList);

        req.getRequestDispatcher("pages/content/product-list-crud.jsp").include(req, resp);
    }
}
