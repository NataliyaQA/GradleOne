package pageObjects.objects;

public class ProductObject {
    String nameOfProduct;
    float price;

    @Override
    public String toString() {
        return nameOfProduct + price;
    }

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

    public ProductObject(String nameOfProduct, float price) {
        this.nameOfProduct = nameOfProduct;
        this.price = price;
    }

}
