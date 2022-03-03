package ru.gb;

public class Main {

    public static void main(String[] args) {
        Owner owner = new Owner("Renat", "MSK");

        Factory factory = getProductFactory(owner);

        if(factory != null){
            Product product = factory.create("Milk");
            System.out.println(product);
            product.setName("NewMilkName");
            System.out.println(product);
        }
    }

    private static Factory getProductFactory(Owner owner) {
        if(owner.getOwnerAddress().equals("MSK")){
            return new ProductFactory();
        } else{
            System.out.println("We do not have stores at this address");
            return null;
        }
    }
}
