package market.pavelpadalka.u.com.gitlab.dao.impl;

import market.pavelpadalka.u.com.gitlab.dao.api.ProductDAO;
import market.pavelpadalka.u.com.gitlab.datasource.DataSource;
import market.pavelpadalka.u.com.gitlab.entity.Product;
import market.pavelpadalka.u.com.gitlab.entity.ProductGroup;
import market.pavelpadalka.u.com.gitlab.helper.Transformer;
import market.pavelpadalka.u.com.gitlab.service.api.ProductGroupService;
import market.pavelpadalka.u.com.gitlab.service.impl.ProductGroupServiceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {

    private static volatile ProductDAO instance;
    private static volatile DataSource dataSource;
    private static volatile ProductGroupService productGroupService;

    private ProductDAOImpl() {
    }

    public static ProductDAO getInstance() {
        if (instance == null) {
            synchronized (ProductDAOImpl.class) {
                if (instance == null)
                    instance = new ProductDAOImpl();
                    dataSource = DataSource.getInstance();
                    productGroupService = ProductGroupServiceImpl.getInstance();
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

                setDefaultProductFields(product, resultSet);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;

    }

    public List<Product> findAllAvailable() {

        Connection connection = dataSource.createConnection();

        List<Product> productList = new LinkedList<Product>();

        String findAllQuery = "SELECT * FROM tbl_products WHERE product_count > 0";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(findAllQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Product product = new Product();

                setDefaultProductFields(product, resultSet);

                productList.add(product);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productList;

    }

    public List<Product> findAll() {

        Connection connection = dataSource.createConnection();

        List<Product> productList = new LinkedList<Product>();

        String findAllQuery = "SELECT * FROM tbl_products";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(findAllQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Product product = new Product();

                setDefaultProductFields(product, resultSet);

                productList.add(product);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productList;

    }

    public Product create(Product product) {

        Connection connection = dataSource.createConnection();

        String createProductQuery = "INSERT INTO tbl_products (product_title, product_description, product_price, product_count, product_group_id) VALUES (?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(createProductQuery);
            preparedStatement.setString(1, product.getTitle());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setInt(4,    product.getCount());
            preparedStatement.setInt(5,    product.getProductGroup().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;

    }

    public Product update(Product product) {

        Connection connection = dataSource.createConnection();

        String updateProductQuery = "UPDATE tbl_products SET product_title = ?, product_description = ?, product_price = ?, product_count = ?, product_group_id = ? WHERE product_id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateProductQuery);
            preparedStatement.setString(1, product.getTitle());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setInt(4, product.getCount());
            preparedStatement.setInt(5, product.getProductGroup().getId());
            preparedStatement.setInt(6, product.getId());
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

    private void setDefaultProductFields(Product product, ResultSet resultSet) throws SQLException {

        product.setId(resultSet.getInt("product_id"));
        product.setTitle(resultSet.getString("product_title"));
        product.setDescription(resultSet.getString("product_description"));
        product.setPrice(resultSet.getDouble("product_price"));
        product.setCount(resultSet.getInt("product_count"));

        ProductGroup productGroup = Transformer.transformProductGroupDTOToProductGroup(
                productGroupService.findProductGroupById(resultSet.getInt("product_group_id")));

        product.setProductGroup(productGroup);

    }

}
