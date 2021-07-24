package HOMEWORK;

public class Product {
    private String name;
    private String price;
    private String variant;
    private int quantity;
    public Product()
    {}
    public Product(String name, String price, String variant, int quantity){
        this.name = name;
        this.price = price;
        this.variant = variant;
        this.quantity =quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getVariant() {
        return variant;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String toString(){
        return "Item {"+
                "Product Name: "+name+"  "+
                "Price: "+price+"  "+
                "Variant: "+variant+"  "+
                "Quantity:"+quantity+"  "+
                "}";
    }
}
