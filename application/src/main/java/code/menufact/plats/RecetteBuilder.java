package code.menufact.plats;
import code.ingredients.Ingredient;

import java.util.HashMap;
import java.util.Map;

public class RecetteBuilder {
    public RecetteBuilder() {
        ingredients = new HashMap<>();
    }

    private Map<Ingredient, Quantite> ingredients;

    public RecetteBuilder ajouterIngredient(Ingredient ingredient, int qte, String unite) {
        Quantite quantite = new Quantite(qte,unite);
        ingredients.put(ingredient,quantite);
        return this;
    }

    public Recette build() {
        return new Recette(ingredients);
    }
}
