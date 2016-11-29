package market.pavelpadalka.u.com.gitlab.service.impl;

import market.pavelpadalka.u.com.gitlab.dao.api.ProductDAO;
import market.pavelpadalka.u.com.gitlab.dao.impl.ProductDAOImpl;
import market.pavelpadalka.u.com.gitlab.dto.ProductDTO;
import market.pavelpadalka.u.com.gitlab.entity.Product;
import market.pavelpadalka.u.com.gitlab.helper.Transformer;
import market.pavelpadalka.u.com.gitlab.service.api.ProductService;

public class ProductServiceImpl implements ProductService {

    private static volatile ProductService instance;
    private ProductDAO productDAO = ProductDAOImpl.getInstance();

    private ProductServiceImpl() {
    }

    public static ProductService getInstance() {
        if (instance == null) {
            synchronized (ProductServiceImpl.class) {
                if (instance == null)
                    instance = new ProductServiceImpl();
            }
        }
        return instance;
    }

    public ProductDTO findProductById(Integer id) {

        ProductDTO resProductDTO = null;
        Product product = productDAO.findProductById(id);

        if(product!=null) {
            resProductDTO = Transformer.transformProductToProductDTO(product);
        }

        return resProductDTO;

    }

    public boolean createProduct(ProductDTO productDTO) {

        Product createdProduct = productDAO.create(Transformer.transformProductDTOToProduct(productDTO));

        return createdProduct != null;

    }

    public boolean updateProduct(ProductDTO productDTO) {

        Product updatedProduct = productDAO.update(Transformer.transformProductDTOToProduct(productDTO));

        return updatedProduct != null;

    }

    public boolean deleteProduct(Integer id) {

        return productDAO.delete(id);

    }
}
