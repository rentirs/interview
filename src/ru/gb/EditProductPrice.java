package ru.gb;

public class EditProductPrice {
    private CommandSetDoublePrice commandSetDoublePrice;
    private CommandSetOptimalPrice commandSetOptimalPrice;

    public EditProductPrice(Product product){
        this.commandSetDoublePrice = new CommandSetDoublePrice(product);
        this.commandSetOptimalPrice = new CommandSetOptimalPrice(product);
    }

    public void findBest (){
        commandSetOptimalPrice.backup();
        if(!commandSetOptimalPrice.exec()){
            commandSetOptimalPrice.rollback();
        };

    }

    public void doublePrice (){
        commandSetDoublePrice.backup();
        if(!commandSetDoublePrice.exec()){
            commandSetDoublePrice.rollback();
        };
    }
}
