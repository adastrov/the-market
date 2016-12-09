package market.pavelpadalka.u.com.gitlab.controller;

import market.pavelpadalka.u.com.gitlab.helper.ApplicationContext;
import market.pavelpadalka.u.com.gitlab.service.api.ProductService;
import market.pavelpadalka.u.com.gitlab.service.api.UserService;
import market.pavelpadalka.u.com.gitlab.service.impl.ProductServiceImpl;
import market.pavelpadalka.u.com.gitlab.service.impl.UserServiceImpl;

public class Main {

    private static UserService userService = UserServiceImpl.getInstance();
    private static ProductService productService = ProductServiceImpl.getInstance();

    public static void main(String[] args) {

        ApplicationContext.init();


//        ProductDTO product = productService.findProductById(3);
//        Boolean isUpdated  = productService.updateProduct(product);
//        Boolean isCreated  = productService.createProduct(product);
//        //Boolean isDeleted  = productService.deleteProduct(4);
//
//        System.out.println("Product id: " + product.getId());
//        System.out.println("Was created? " + isCreated);
//        System.out.println("Was updated? " + isUpdated);
//        //System.out.println("Was Deleted? " + isDeleted);
//
//        UserDTO user = userService.findByLoginAndEmail("dssd", "dfdf");
//        System.out.println("User id: " + user.getId());
//        int[] mice = {4, 8, 10, 12, 16};
//        int[] cats = new int[6];
    }


}
