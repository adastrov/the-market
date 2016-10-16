package Shop.pavelpadalka.u.com.gitlab.dao.impl;

import Shop.pavelpadalka.u.com.gitlab.dao.api.ProductDAO;
import Shop.pavelpadalka.u.com.gitlab.entity.ProductGroup;
import Shop.pavelpadalka.u.com.gitlab.entity.Product;

import java.util.LinkedList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {
    public Product create(Product product) {
        return product;
    }

    public Product update(Product product) {
        return product;
    }

    public boolean delete(Integer id) {
        return true;
    }

    public List<ProductGroup> findAllByGroup(Integer id) {
        List<ProductGroup> groups = new LinkedList<ProductGroup>();
        ProductGroup productGroup = new ProductGroup();
        productGroup.setTitle("Group mock");
        groups.add(productGroup);

        return groups;
    }
}
