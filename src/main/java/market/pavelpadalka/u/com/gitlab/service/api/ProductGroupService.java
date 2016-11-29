package market.pavelpadalka.u.com.gitlab.service.api;

import market.pavelpadalka.u.com.gitlab.dto.ProductDTO;
import market.pavelpadalka.u.com.gitlab.dto.ProductGroupDTO;

import java.util.List;

public interface ProductGroupService {

    List<ProductDTO> findProducts(Integer id);

    ProductGroupDTO findProductGroupById(Integer id);

    boolean createProductGroup(ProductGroupDTO productGroupDTO);

    boolean updateProductGroup(ProductGroupDTO productGroupDTO);

    boolean deleteProductGroup(Integer id);

}
