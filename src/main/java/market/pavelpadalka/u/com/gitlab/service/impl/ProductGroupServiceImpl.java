package market.pavelpadalka.u.com.gitlab.service.impl;

import market.pavelpadalka.u.com.gitlab.dao.api.ProductGroupDAO;
import market.pavelpadalka.u.com.gitlab.dao.impl.ProductGroupDAOImpl;
import market.pavelpadalka.u.com.gitlab.dto.ProductDTO;
import market.pavelpadalka.u.com.gitlab.dto.ProductGroupDTO;
import market.pavelpadalka.u.com.gitlab.entity.Product;
import market.pavelpadalka.u.com.gitlab.entity.ProductGroup;
import market.pavelpadalka.u.com.gitlab.helper.Transformer;
import market.pavelpadalka.u.com.gitlab.service.api.ProductGroupService;

import java.util.LinkedList;
import java.util.List;

public class ProductGroupServiceImpl implements ProductGroupService {

    private static volatile ProductGroupService instance;
    private ProductGroupDAO productGroupDAO = ProductGroupDAOImpl.getInstance();

    private ProductGroupServiceImpl() {
    }

    public static ProductGroupService getInstance() {
        if (instance == null) {
            synchronized (ProductGroupServiceImpl.class) {
                if (instance == null)
                    instance = new ProductGroupServiceImpl();
            }
        }
        return instance;
    }

    public List<ProductDTO> findProducts(Integer id) {

        List<ProductDTO> productDTOList = new LinkedList<ProductDTO>();
        List<Product> productList = productGroupDAO.findProducts(id);

        for(Product product : productList) {
            productDTOList.add(Transformer.transformProductToProductDTO(product));
        }

        return productDTOList;

    }

    public ProductGroupDTO findProductGroupById(Integer id) {

        ProductGroupDTO resProductGroupDTO = null;
        ProductGroup productGroup = productGroupDAO.findProductGroupById(id);

        if(productGroup!=null) {
            resProductGroupDTO = Transformer.transformProductGroupToProductGroupDTO(productGroup);
        }

        return resProductGroupDTO;

    }

    public boolean createProductGroup(ProductGroupDTO productGroupDTO) {

        ProductGroup createdProductGroup = productGroupDAO.create(Transformer.transformProductGroupDTOToProductGroup(productGroupDTO));

        return createdProductGroup != null;

    }

    public boolean updateProductGroup(ProductGroupDTO productGroupDTO) {

        ProductGroup updatedProductGroup = productGroupDAO.update(Transformer.transformProductGroupDTOToProductGroup(productGroupDTO));

        return updatedProductGroup != null;

    }

    public boolean deleteProductGroup(Integer id) {

        return productGroupDAO.delete(id);

    }
}
