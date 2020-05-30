package org.techtown.doit14;

public class Product {
    String Photourl;
    String Name;
    String price;

    public Product(String photourl, String name, String price) {
        this.Photourl = photourl;
        this.Name = name;
        this.price = price;
    }

    public String getPhotourl() {
        return Photourl;
    }

    public void setPhotourl(String photourl) {
        Photourl = photourl;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
