package pageObjects.objects;

public class ProductObject {
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
    public ProductObject(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }
    public ProductObject(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return nameOfProduct;
    }

//    @Override
//    public String toString() {
//        return String.valueOf(price);
//    }
}
