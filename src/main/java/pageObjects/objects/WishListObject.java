package pageObjects.objects;

public class WishListObject {
    String name;
    int quantity;
    int viewed;
    String created;
    String directLink;
    String delete;

    @Override
    public String toString() {
        return "WishListObject{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", viewed=" + viewed +
                ", created='" + created + '\'' +
                ", directLink='" + directLink + '\'' +
                ", delete='" + delete + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getViewed() {
        return viewed;
    }

    public String getCreated() {
        return created;
    }

    public String getDirectLink() {
        return directLink;
    }

    public String getDelete() {
        return delete;
    }

    //Constructor
    public WishListObject(String name, int quantity, int viewed, String created, String directLink, String delete) {
        this.name = name;
        this.quantity = quantity;
        this.viewed = viewed;
        this.created = created;
        this.directLink = directLink;
        this.delete = delete;
    }
    public WishListObject(String getName) {
    }
}
