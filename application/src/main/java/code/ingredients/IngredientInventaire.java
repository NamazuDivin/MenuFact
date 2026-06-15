package code.ingredients;

import code.ingredients.exceptions.IngredientException;

public class IngredientInventaire {
    private Ingredient ingredient;
    private int quantite;

    public IngredientInventaire(Ingredient ingredient, int quantite) {
        this.ingredient = ingredient;
        this.quantite = quantite;
    }

    public int getQuantite() {
        return quantite;
    }

    public Ingredient getIngredient() { return ingredient; }

    public void setQuantite(int quantite) throws IngredientException{

        if (quantite < 0)
            throw new IngredientException("Il n'est pas possible d'avoir une quantité negative");
        else
            this.quantite = quantite;
    }
}
