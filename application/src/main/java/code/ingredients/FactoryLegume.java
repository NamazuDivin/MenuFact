package code.ingredients;

public class FactoryLegume extends FactoryIngredient {

    public FactoryLegume() {
    }

    public Ingredient creerIngredient() {
        return new Legume();
    }
}