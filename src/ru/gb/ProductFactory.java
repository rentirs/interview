package ru.gb;

public class ProductFactory extends Factory{
    @Override
    Product orderProduct(String requestedGrade) {
        switch (requestedGrade) {
            case "Milk":
                return new Milk();
            case "Bread":
                return new Bread();
            default:
                System.out.println("Not Found");
                return null;
        }
    }
}
