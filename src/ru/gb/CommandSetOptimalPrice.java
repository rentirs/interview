package ru.gb;

public class CommandSetOptimalPrice extends Command {
    public CommandSetOptimalPrice(Product product) {
        this.p = product;
    }

    public boolean exec(){
        p.setPrice(p.getOptimalPriceForProduct());
        return true;
    }
}

