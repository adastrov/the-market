package market.pavelpadalka.u.com.gitlab.entity;

import java.sql.Date;

public class History {

    private Integer id;
    private User    user;
    private Product product;
    private Integer productCount;
    private Double  productPrice;
    private Date    date;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        History history = (History) o;

        if (!id.equals(history.id)) return false;
        if (!user.equals(history.user)) return false;
        if (!product.equals(history.product)) return false;
        if (!productCount.equals(history.productCount)) return false;
        if (!productPrice.equals(history.productPrice)) return false;
        return date.equals(history.date);

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
