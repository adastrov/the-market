package market.pavelpadalka.u.com.gitlab.dao.api;

import market.pavelpadalka.u.com.gitlab.entity.Product;
import market.pavelpadalka.u.com.gitlab.entity.ProductGroup;

import java.util.List;

public interface ProductDAO {

    Product findProductById(Integer id);
    List<Product> findAll();
    List<Product> findAllAvailable();

    Product create(Product product);
    Product update(Product product);
    boolean delete(Integer id);

}
