package ru.gb;

public abstract class Factory {
    public Product create(String orderedProduct) {
        Product product = orderProduct(orderedProduct);
        product = setProduct(product);
        return product;
    }

    private Product setProduct(Product product){
        product.setName(product.name);
        product.setCategory(product.category);
        product.setPrice(product.price);
        return product;
    }

    abstract Product orderProduct(String orderedProduct);
}