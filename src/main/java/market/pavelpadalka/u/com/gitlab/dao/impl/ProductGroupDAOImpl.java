package market.pavelpadalka.u.com.gitlab.dao.impl;

import market.pavelpadalka.u.com.gitlab.dao.api.ProductGroupDAO;
import market.pavelpadalka.u.com.gitlab.datasource.DataSource;
import market.pavelpadalka.u.com.gitlab.entity.Product;
import market.pavelpadalka.u.com.gitlab.entity.ProductGroup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ProductGroupDAOImpl implements ProductGroupDAO {

    private static volatile ProductGroupDAO instance;
    private static volatile DataSource dataSource;

    private ProductGroupDAOImpl() {
    }

    public static ProductGroupDAO getInstance() {
        if (instance == null) {
            synchronized (ProductGroupDAOImpl.class) {
                if (instance == null)
                    instance = new ProductGroupDAOImpl();
                    dataSource = DataSource.getInstance();
            }
        }
        return instance;
    }

    public ProductGroup findProductGroupById(Integer id) {

        ProductGroup productGroup = null;
        Connection connection = dataSource.createConnection();

        String findProductGroupByIdQuery = "SELECT * FROM tbl_product_groups WHERE product_group_id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(findProductGroupByIdQuery);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                productGroup = new ProductGroup();
                productGroup.setId(resultSet.getInt("product_id"));
                productGroup.setTitle(resultSet.getString("product_title"));
                productGroup.setDescription(resultSet.getString("product_description"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productGroup;

    }

    public List<Product> findProducts(Integer productGroupId) {

        List<Product> productList = new LinkedList<Product>();
        Connection connection = dataSource.createConnection();

        String findProductByIdQuery = "SELECT * FROM tbl_products WHERE product_group_id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(findProductByIdQuery);
            preparedStatement.setInt(1, productGroupId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("product_id"));
                product.setTitle(resultSet.getString("product_title"));
                product.setDescription(resultSet.getString("product_description"));
                product.setPrice(resultSet.getDouble("product_price"));
                product.setCount(resultSet.getInt("product_count"));

                productList.add(product);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productList;

    }

    public ProductGroup create(ProductGroup productGroup) {

        Connection connection = dataSource.createConnection();

        String createProductGroupQuery = "INSERT INTO tbl_product_groups (product_title, product_description) VALUES (?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(createProductGroupQuery);
            preparedStatement.setString(1, productGroup.getTitle());
            preparedStatement.setString(2, productGroup.getDescription());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productGroup;

    }

    public ProductGroup update(ProductGroup productGroup) {

        Connection connection = dataSource.createConnection();

        String updateProductGroupQuery = "UPDATE tbl_product_groups SET product_group_title = ?, product_group_description= ? WHERE product_group_id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateProductGroupQuery);
            preparedStatement.setString(1, productGroup.getTitle());
            preparedStatement.setString(2, productGroup.getDescription());
            preparedStatement.setInt(3, productGroup.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productGroup;

    }

    public boolean delete(Integer id) {

        int resultCount = 0;

        Connection connection = dataSource.createConnection();

        String deleteProductGroupQuery = "DELETE FROM tbl_product_groups WHERE product_group_id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteProductGroupQuery);
            preparedStatement.setInt(1, id);
            resultCount = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultCount > 0;

    }
}
