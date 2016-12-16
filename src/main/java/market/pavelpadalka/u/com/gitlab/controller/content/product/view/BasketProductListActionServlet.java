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

@WebServlet({"/order/basket-product-list"})
public class BasketProductListActionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        LinkedList<ProductDTO> resUserBasket = new LinkedList<ProductDTO>();

        Object userBasket = session.getAttribute("userBasket");

        if (userBasket == null) {
            req.getSession().setAttribute("products", resUserBasket);
        } else {
            req.getSession().setAttribute("products", userBasket);
        }

        req.setAttribute("doNotShowRegisterAndIncomeButtons", true);
        req.getRequestDispatcher("pages/basket/basket-product-list.jsp").include(req, resp);

    }

}
