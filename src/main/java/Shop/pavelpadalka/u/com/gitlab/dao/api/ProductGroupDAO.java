package Shop.pavelpadalka.u.com.gitlab.dao.api;

import Shop.pavelpadalka.u.com.gitlab.entity.Product;
import Shop.pavelpadalka.u.com.gitlab.entity.ProductGroup;

import java.util.List;

public interface ProductGroupDAO {

    List<Product> findProducts(Integer id);

    ProductGroup create(ProductGroup productGroup);
    ProductGroup update(ProductGroup productGroup);
    boolean      delete(Integer id);

}
