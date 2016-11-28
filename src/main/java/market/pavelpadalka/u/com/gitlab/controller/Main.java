package market.pavelpadalka.u.com.gitlab.controller;

import market.pavelpadalka.u.com.gitlab.dto.ProductDTO;
import market.pavelpadalka.u.com.gitlab.service.api.ProductService;
import market.pavelpadalka.u.com.gitlab.service.api.UserService;
import market.pavelpadalka.u.com.gitlab.service.impl.ProductServiceImpl;
import market.pavelpadalka.u.com.gitlab.service.impl.UserServiceImpl;

public class Main {

    private static UserService userService = UserServiceImpl.getInstance();

    public static void main(String[] args) {

//        for (int i = 0; i < 10; i++) {
//            UserDTO user = new UserDTO();
//            user.setLogin("login_" + i);
//            user.setPassword("password_" + i);
//            user.setFirstName("name_" + i);
//            userService.create(user);
//        }
//
//        UserDTO byLoginAndPassword = userService.findByLoginAndPassword("login_5", "password_5");
//        UserDTO wrongUser = userService.findByLoginAndPassword("login_1", "password_2");
//        System.out.println(byLoginAndPassword);
//        System.out.println(wrongUser);

        ProductService productDAO = ProductServiceImpl.getInstance();
        ProductDTO product = productDAO.findProductById(1);

        System.out.println(product.toString());

    }


}
