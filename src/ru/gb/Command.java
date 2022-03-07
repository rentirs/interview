package ru.gb;

public abstract class Command {
    public Product p;
    private double backup;

    void backup() {
        backup = p.getPrice();
    }

    public void rollback(){
        p.setPrice(backup);
    }

    public abstract boolean exec();
}
