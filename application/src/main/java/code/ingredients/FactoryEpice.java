package code.ingredients;

public class FactoryEpice extends FactoryIngredient {

    public FactoryEpice() {
    }

    public Ingredient creerIngredient() {
        return new Epice();
    }
}