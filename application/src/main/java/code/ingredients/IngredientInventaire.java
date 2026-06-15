package code.ingredients;

import code.ingredients.exceptions.IngredientException;

/**
 * Classe pour l'inventaire des ingrédients
 *
 * @author Kevin et Léanne
 * @version 1.0
 */
public class IngredientInventaire {
    private Ingredient ingredient;
    private int quantite;

    public IngredientInventaire(Ingredient ingredient, int quantite) {
        this.ingredient = ingredient;
        this.quantite = quantite;
    }

    /**
     * Retourne la quantité d'un type d'ingrédient
     *
     * @return la quantité
     */
    public int getQuantite() {
        return quantite;
    }

    public Ingredient getIngredient() { return ingredient; }

    /**
     * Modifie la quantité d'un type d'ingrédient
     *
     * @param quantite
     * @throws IngredientException si la quantité est négative
     */
    public void setQuantite(int quantite) throws IngredientException{

        if (quantite < 0)
            throw new IngredientException("Il n'est pas possible d'avoir une quantité negative");
        else
            this.quantite = quantite;
    }
}
