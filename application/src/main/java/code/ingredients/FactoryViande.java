package code.ingredients;

public class FactoryViande extends FactoryIngredient {

    public FactoryViande() {
    }

    public Ingredient creerIngredient() {
        return new Viande();
    }
}