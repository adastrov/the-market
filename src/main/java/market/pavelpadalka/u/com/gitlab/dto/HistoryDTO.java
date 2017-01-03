package market.pavelpadalka.u.com.gitlab.dto;

import market.pavelpadalka.u.com.gitlab.entity.Product;
import market.pavelpadalka.u.com.gitlab.entity.User;

import java.util.Date;

public class HistoryDTO {

    private Integer id;
    private User user;
    private Product product;
    private Integer productCount;
    private Double  productPrice;
    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HistoryDTO that = (HistoryDTO) o;

        if (!id.equals(that.id)) return false;
        if (!user.equals(that.user)) return false;
        if (!product.equals(that.product)) return false;
        if (!productCount.equals(that.productCount)) return false;
        if (!productPrice.equals(that.productPrice)) return false;
        return date.equals(that.date);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + user.hashCode();
        result = 31 * result + product.hashCode();
        result = 31 * result + productCount.hashCode();
        result = 31 * result + productPrice.hashCode();
        result = 31 * result + date.hashCode();
        return result;
    }
}
