package ru.gb;

public class CommandSetDoublePrice extends Command {
    public CommandSetDoublePrice(Product product) {
        this.p = product;
    }

    public boolean exec() {
        p.setPrice(p.getDoublePrice());
        return true;
    }
}
