package market.pavelpadalka.u.com.gitlab.dao.api;

import market.pavelpadalka.u.com.gitlab.entity.Product;
import market.pavelpadalka.u.com.gitlab.entity.ProductGroup;

import java.util.List;

public interface ProductDAO {

    Product findProductById(Integer id);

    Product create(Product product);
    Product update(Product product);
    boolean delete(Integer id);
    List<ProductGroup> findProductGroups(Integer id);

}
