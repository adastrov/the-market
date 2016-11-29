package market.pavelpadalka.u.com.gitlab.dao.impl;

import market.pavelpadalka.u.com.gitlab.dao.api.HistoryDAO;
import market.pavelpadalka.u.com.gitlab.datasource.DataSource;
import market.pavelpadalka.u.com.gitlab.dto.ProductDTO;
import market.pavelpadalka.u.com.gitlab.entity.History;
import market.pavelpadalka.u.com.gitlab.entity.Product;
import market.pavelpadalka.u.com.gitlab.helper.Transformer;
import market.pavelpadalka.u.com.gitlab.service.api.ProductService;
import market.pavelpadalka.u.com.gitlab.service.impl.ProductServiceImpl;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class HistoryDAOImpl implements HistoryDAO {

    private static volatile HistoryDAO instance;
    private static volatile DataSource dataSource;
    private static ProductService productService = ProductServiceImpl.getInstance();

    private HistoryDAOImpl() {
    }

    public static HistoryDAO getInstance() {
        if (instance == null) {
            synchronized (HistoryDAOImpl.class) {
                if (instance == null)
                    instance = new HistoryDAOImpl();
                    dataSource = DataSource.getInstance();
            }
        }
        return instance;
    }

    public History create(History history) {

        Connection connection = dataSource.createConnection();

        String createHistoryQuery = "INSERT INTO tbl_history (history_user, history_product, history_productCount, history_productPrice, history_date) VALUES (?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(createHistoryQuery);
            preparedStatement.setInt(1, history.getUser().getId());
            preparedStatement.setInt(2, history.getProduct().getId());
            preparedStatement.setInt(3, history.getProductCount());
            preparedStatement.setDouble(4, history.getProductPrice());
            preparedStatement.setDate(5, history.getDate());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return history;

    }

    public List<History> findAllByUserId(Integer id) {

        List<History> historyList = new LinkedList<History>();
        Connection connection = dataSource.createConnection();

        String findHistoryByUserIdQuery = "SELECT * FROM tbl_history WHERE history_id = ?";

        try {

            PreparedStatement preparedStatement = connection.prepareStatement(findHistoryByUserIdQuery);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                ProductDTO productDTO = productService.findProductById(resultSet.getInt("history_product"));
                Product product = Transformer.transformProductDTOToProduct(productDTO);

                History history = new History();
                history.setId(resultSet.getInt("history_id"));
                history.setProduct(product);

                history.setProductCount(product.getCount());
                history.setProductPrice(product.getPrice());

                history.setDate(resultSet.getDate("history_date"));

                historyList.add(history);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return historyList;

    }
}
