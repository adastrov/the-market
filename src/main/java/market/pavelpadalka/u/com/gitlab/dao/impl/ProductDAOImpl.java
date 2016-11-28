package market.pavelpadalka.u.com.gitlab.dao.impl;

import market.pavelpadalka.u.com.gitlab.dao.api.ProductDAO;
import market.pavelpadalka.u.com.gitlab.datasource.DataSource;
import market.pavelpadalka.u.com.gitlab.entity.ProductGroup;
import market.pavelpadalka.u.com.gitlab.entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {

    private static volatile ProductDAO instance;
    private static volatile DataSource dataSource;

    private ProductDAOImpl() {
    }

    public static ProductDAO getInstance() {
        if (instance == null) {
            synchronized (ProductDAOImpl.class) {
                if (instance == null)
                    instance = new ProductDAOImpl();
                    dataSource = DataSource.getInstance();
            }
        }
        return instance;
    }

    public Product findProductById(Integer id) {

        Product product = null;
        Connection connection = dataSource.createConnection();

        String findUserByIdQuery = "Select * from user where id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(findUserByIdQuery);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                product = new Product();
                product.setId(resultSet.getInt("id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }

    public Product create(Product product) {
        return product;
    }

    public Product update(Product product) {
        return product;
    }

    public boolean delete(Integer id) {
        return true;
    }

    public List<ProductGroup> findProductGroups(Integer id) {
        List<ProductGroup> groups = new LinkedList<ProductGroup>();
        ProductGroup productGroup = new ProductGroup();
        productGroup.setTitle("Group mock");
        groups.add(productGroup);

        return groups;
    }
}
