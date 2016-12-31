package market.pavelpadalka.u.com.gitlab.controller.content.product.view;

import market.pavelpadalka.u.com.gitlab.dto.ProductDTO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet({"/order/shopping-cart"})
public class ShoppingCartActionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        LinkedList<ProductDTO> resUserShoppingCart = new LinkedList<ProductDTO>();

        Object userShoppingCart = session.getAttribute("userShoppingCart");

        if (userShoppingCart == null) {
            req.getSession().setAttribute("products", resUserShoppingCart);
        } else {
            req.getSession().setAttribute("products", userShoppingCart);
        }

        req.setAttribute("doNotShowRegisterAndIncomeButtons", true);
        req.getRequestDispatcher("/pages/order/shopping-cart.jsp").include(req, resp);

    }

}
