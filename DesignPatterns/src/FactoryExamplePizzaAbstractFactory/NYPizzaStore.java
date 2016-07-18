package FactoryExamplePizzaAbstractFactory;

public abstract class NYPizzaStore extends PizzaStore{


    protected abstract Pizza createPizza(String item);

    public Pizza orderPizza(String type){
        Pizza pizza = createPizza(type);
        System.out.println("--- Making a " + pizza.getName() + "---");
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

}
