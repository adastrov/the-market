package market.pavelpadalka.u.com.gitlab.service.api;

import market.pavelpadalka.u.com.gitlab.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    ProductDTO findProductById(Integer id);

    List<ProductDTO> findAll();

    List<ProductDTO> findAllAvailable();

    boolean createProduct(ProductDTO product);

    boolean updateProduct(ProductDTO product);

    boolean deleteProduct(Integer id);

}
