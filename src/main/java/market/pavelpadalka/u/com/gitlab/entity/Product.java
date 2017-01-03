package market.pavelpadalka.u.com.gitlab.entity;

import market.pavelpadalka.u.com.gitlab.dto.ProductGroupDTO;

public class Product {

    private Integer id;
    private String  title;
    private String  description;
    private Double  price;
    private Integer count;
    private ProductGroupDTO productGroupDTO;

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public ProductGroupDTO getProductGroup() {
        return productGroupDTO;
    }

    public void setProductGroup(ProductGroupDTO productGroupDTO) {
        this.productGroupDTO = productGroupDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (!id.equals(product.id)) return false;
        if (!title.equals(product.title)) return false;
        if (!description.equals(product.description)) return false;
        return productGroupDTO.equals(product.productGroupDTO);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + productGroupDTO.hashCode();
        return result;
    }
}
