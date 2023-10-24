public class Product {
    String productId;
    String productName;
    int productPrice;
    String productCompany;

    public Product() {
    }

    public Product(String productId, String productName, int productPrice, String productCompany) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCompany = productCompany;
    }


    @Override
    public String toString() {
        return String.format("%5s %10s %5s %s%n", this.productId, this.productName, this.productPrice, this.productCompany);
    }

}
