package ru.gb;

import java.util.ArrayList;
import java.util.List;

// Composite
public class SpecialOffer extends Product {
    private List<Product> groupProducts = new ArrayList<>();
    private double discount = 0.1;

    public SpecialOffer(){
    }

    public SpecialOffer(List<Product> groupProducts, int discount) {
        this.groupProducts = groupProducts;
        this.discount = discount;
    }

    public void addProduct(Product product){
        groupProducts.add(product);
        findOverallPrice();
    }

    public void removeProduct(Product product){
        groupProducts.remove(product);
        findOverallPrice();
    }

    public void findOverallPrice(){
        for (Product product : groupProducts) {
            this.price += product.getPrice();
        }
        this.price = price - price * discount;
    }
}
