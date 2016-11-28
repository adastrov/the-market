package market.pavelpadalka.u.com.gitlab.service.api;

import market.pavelpadalka.u.com.gitlab.dto.ProductDTO;

public interface ProductService {

    ProductDTO findProductById(Integer id);

    boolean createProduct(ProductDTO product);

    boolean updateProduct(ProductDTO product);

    boolean deleteProduct(Integer id);

}
