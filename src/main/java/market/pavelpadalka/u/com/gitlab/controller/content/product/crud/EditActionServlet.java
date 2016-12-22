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

@WebServlet({"/content/product-edit"})
public class EditActionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ProductService      productService      = ProductServiceImpl.getInstance();
        ProductGroupService productGroupService = ProductGroupServiceImpl.getInstance();

        String  id = req.getParameter("id");

        ProductDTO productDTO = productService.findProductById(Integer.valueOf(id));

        if (productDTO==null) {
            req.setAttribute("error", "Product hasn't been found! Internal error");
            resp.sendRedirect("/content/product-edit");
            return;
        }

        List<ProductGroupDTO> productGroupDTOList = productGroupService.findAll();

        req.setAttribute("error",             null);
        req.setAttribute("productForEditing", productDTO);
        req.setAttribute("productGroups",     productGroupDTOList);
        req.setAttribute("productGroupId",    productDTO.getProductGroup().getId());

        req.getRequestDispatcher("/pages/content/product-list-edit.jsp").include(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ProductService      productService      = ProductServiceImpl.getInstance();
        ProductGroupService productGroupService = ProductGroupServiceImpl.getInstance();

        String  id             = req.getParameter("id");
        String  title          = req.getParameter("title");
        String  description    = req.getParameter("description");
        String  price          = req.getParameter("price");
        String  count          = req.getParameter("count");
        String  productGroupId = req.getParameter("productGroup");

        ProductDTO productDTO           = productService.findProductById(Integer.valueOf(id));
        ProductGroupDTO productGroupDTO = productGroupService.findProductGroupById(Integer.valueOf(productGroupId));

        if (productDTO==null || productGroupDTO==null) {
            req.setAttribute("error", "Internal server error!");
            resp.sendRedirect("/content/product-list");
            return;
        }

        productDTO.setTitle(title);
        productDTO.setDescription(description);
        productDTO.setPrice(Double.valueOf(price));
        productDTO.setCount(Integer.valueOf(count));

        productDTO.setProductGroup(productGroupDTO);

        Boolean updated = productService.updateProduct(productDTO);

        if (!updated) {
            req.setAttribute("error", "Product group hasn't been updated! Internal error");
        }

        req.setAttribute("error", null);
        resp.sendRedirect("/content/product-list-edit");

    }
}
