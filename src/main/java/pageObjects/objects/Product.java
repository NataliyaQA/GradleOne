package pageObjects.objects;

public class Product {
    String nameOfProduct;
    float price;

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    //Constructor (Alt + ins)
    public Product(String nameOfProduct, float price) {
        this.nameOfProduct = nameOfProduct;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "nameOfProduct='" + nameOfProduct + '\'' +
                ", price=" + price +
                '}';
    }
}
