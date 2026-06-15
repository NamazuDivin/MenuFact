package code.ingredients;

public class FactoryLaitier extends FactoryIngredient {

    public FactoryLaitier() {
    }

    public Ingredient creerIngredient() {
        return new Laitier();
    }
}