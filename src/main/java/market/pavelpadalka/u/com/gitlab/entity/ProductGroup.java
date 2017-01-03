package market.pavelpadalka.u.com.gitlab.entity;

import java.util.List;

public class ProductGroup {

    private Integer       id;
    private String        title;
    private String        description;
    private List<Product> product;

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

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductGroup that = (ProductGroup) o;

        if (!id.equals(that.id)) return false;
        if (!title.equals(that.title)) return false;
        return description.equals(that.description);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }

}
