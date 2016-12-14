package market.pavelpadalka.u.com.gitlab.controller.content.product.crud;


import market.pavelpadalka.u.com.gitlab.dto.ProductDTO;
import market.pavelpadalka.u.com.gitlab.dto.ProductGroupDTO;
import market.pavelpadalka.u.com.gitlab.dto.UserDTO;
import market.pavelpadalka.u.com.gitlab.dto.UserRoleDTO;
import market.pavelpadalka.u.com.gitlab.entity.UserSex;
import market.pavelpadalka.u.com.gitlab.service.api.ProductGroupService;
import market.pavelpadalka.u.com.gitlab.service.api.ProductService;
import market.pavelpadalka.u.com.gitlab.service.api.UserRoleService;
import market.pavelpadalka.u.com.gitlab.service.api.UserService;
import market.pavelpadalka.u.com.gitlab.service.impl.ProductGroupServiceImpl;
import market.pavelpadalka.u.com.gitlab.service.impl.ProductServiceImpl;
import market.pavelpadalka.u.com.gitlab.service.impl.UserRoleServiceImpl;
import market.pavelpadalka.u.com.gitlab.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;

@WebServlet({"/product-edit"})
public class EditActionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ProductService productService = ProductServiceImpl.getInstance();
        HttpSession session     = req.getSession();

        String  id = req.getParameter("id");

        ProductDTO productDTO = productService.findProductById(Integer.valueOf(id));

        session.setAttribute("productForEditing", productDTO);
        session.setAttribute("productGroupId",    productDTO.getProductGroup().getId());

        req.getRequestDispatcher("pages/content/product-list-edit.jsp").include(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ProductService      productService      = ProductServiceImpl.getInstance();
        ProductGroupService productGroupService = ProductGroupServiceImpl.getInstance();

        HttpSession session = req.getSession();

        String  id             = req.getParameter("id");
        String  title          = req.getParameter("title");
        String  description    = req.getParameter("description");
        String  price          = req.getParameter("price");
        String  count          = req.getParameter("count");
        String  productGroupId = req.getParameter("productGroup");

        String  error;

        ProductDTO productDTO = productService.findProductById(Integer.valueOf(id));

        if (productDTO==null) {
            error = "Internal server error!";

            System.out.println("и тут крутой лог...");

            session.setAttribute("error", error);
            resp.sendRedirect("/product-list");
            return;
        }

        ProductGroupDTO productGroupDTO = productGroupService.findProductGroupById(Integer.valueOf(productGroupId));

        productDTO.setTitle(title);
        productDTO.setDescription(description);
        productDTO.setPrice(Double.valueOf(price));
        productDTO.setCount(Integer.valueOf(count));

        productDTO.setProductGroup(productGroupDTO);

        Boolean updated = productService.updateProduct(productDTO);

        if (!updated) {
            error = "Product group hasn't been updated! Internal error";
            session.setAttribute("error", error);
        }

        resp.sendRedirect("/product-list-edit");

    }
}
