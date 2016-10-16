package Shop.pavelpadalka.u.com.gitlab.dto;

import java.util.List;

public class ProductGroupDTO {

    private Integer       id;
    private String        title;
    private String        description;
    private List<ProductDTO> product;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ProductDTO> getProduct() {
        return product;
    }

    public void setProduct(List<ProductDTO> product) {
        this.product = product;
    }



}
