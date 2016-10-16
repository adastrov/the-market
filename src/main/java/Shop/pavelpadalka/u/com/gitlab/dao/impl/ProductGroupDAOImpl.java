package Shop.pavelpadalka.u.com.gitlab.dao.impl;

import Shop.pavelpadalka.u.com.gitlab.dao.api.ProductGroupDAO;
import Shop.pavelpadalka.u.com.gitlab.entity.Product;
import Shop.pavelpadalka.u.com.gitlab.entity.ProductGroup;

import java.util.LinkedList;
import java.util.List;

public class ProductGroupDAOImpl implements ProductGroupDAO {

    public List<Product> findProducts(Integer id) {

        List<Product> products = new LinkedList<Product>();
        Product product = new Product();
        product.setTitle("Group mock");
        products.add(product);

        return products;

    }

    public ProductGroup create(ProductGroup productGroup) {
        return productGroup;
    }

    public ProductGroup update(ProductGroup productGroup) {
        return productGroup;
    }

    public boolean delete(Integer id) {
        return true;
    }
}
