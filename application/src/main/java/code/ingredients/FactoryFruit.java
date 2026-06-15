package code.ingredients;

public class FactoryFruit extends FactoryIngredient {

    public FactoryFruit() {
    }

    public Ingredient creerIngredient() {
        return new Fruit();
    }
}