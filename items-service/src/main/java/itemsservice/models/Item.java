package itemsservice.models;

public class Item {

    private Product product;
    private Integer amount;
    private Double totalPrice;

    public Item() {}

    public Item (Product product, Integer amount) {
        this.product = product;
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public double getTotalPrice() {
        return product.getPrice() * amount;
    }

    public void setTotalPrice(double totalprice) {
        this.totalPrice = totalprice;
    }
}
