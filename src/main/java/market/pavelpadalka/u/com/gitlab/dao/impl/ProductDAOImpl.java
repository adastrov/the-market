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

        String findProductByIdQuery = "SELECT * FROM tbl_products WHERE product_id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(findProductByIdQuery);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                product = new Product();
                product.setId(resultSet.getInt("product_id"));
                product.setTitle(resultSet.getString("product_Title"));
                product.setDescription(resultSet.getString("product_Description"));
                product.setPrice(resultSet.getDouble("product_Price"));
                product.setCount(resultSet.getInt("product_Count"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }

    public Product create(Product product) {

        Connection connection = dataSource.createConnection();

        String createProductQuery = "INSERT INTO tbl_products (product_title, product_description, product_price, product_count) VALUES (?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(createProductQuery);
            preparedStatement.setString(1, product.getTitle());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setInt(4, product.getCount());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;

    }

    public Product update(Product product) {

        Connection connection = dataSource.createConnection();

        String updateProductQuery = "UPDATE tbl_products SET product_title = ?, product_description = ?, product_price = ?, product_count = ? WHERE product_id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateProductQuery);
            preparedStatement.setString(1, product.getTitle());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setInt(4, product.getCount());
            preparedStatement.setInt(5, product.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }

    public boolean delete(Integer id) {

        int resultCount = 0;

        Connection connection = dataSource.createConnection();

        String deleteProductQuery = "DELETE FROM tbl_products WHERE product_id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteProductQuery);
            preparedStatement.setInt(1, id);
            resultCount = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultCount > 0;

    }

    public List<ProductGroup> findProductGroups(Integer id) {
        List<ProductGroup> groups = new LinkedList<ProductGroup>();
        ProductGroup productGroup = new ProductGroup();
        productGroup.setTitle("Group mock");
        groups.add(productGroup);

        return groups;
    }
}
