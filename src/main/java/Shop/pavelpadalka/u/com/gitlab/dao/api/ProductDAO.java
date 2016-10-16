package Shop.pavelpadalka.u.com.gitlab.dao.api;

import Shop.pavelpadalka.u.com.gitlab.entity.Product;
import Shop.pavelpadalka.u.com.gitlab.entity.ProductGroup;

import java.util.List;

public interface ProductDAO {

    Product create(Product product);
    Product update(Product product);
    boolean delete(Integer id);
    List<ProductGroup> findAllByGroup(Integer id);

}
