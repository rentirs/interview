package ru.gb;

public class Product implements ThingForSale {
    public double price;
    public String name;
    public String category;

    public double fullCosts;
    public double profit;
    public double count;

    @Override
    public void setPrice(double price){
        this.price = price;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setCategory(String category){
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                '}';
    }

    public double getOptimalPriceForProduct() {
        return (fullCosts + profit) / count;
    }

    public double getPrice() {
        return price;
    }

    public double getDoublePrice() {
        return price * 2;
    }

}
