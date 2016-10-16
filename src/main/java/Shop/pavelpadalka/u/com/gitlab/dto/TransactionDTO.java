package Shop.pavelpadalka.u.com.gitlab.dto;

import Shop.pavelpadalka.u.com.gitlab.entity.Product;
import Shop.pavelpadalka.u.com.gitlab.entity.User;

import java.util.Date;

public class TransactionDTO {

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
}
