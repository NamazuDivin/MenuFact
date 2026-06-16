package code.menufact.plats;
import code.ingredients.Ingredient;

import java.util.HashMap;
import java.util.Map;

public class Recette {

    private Map<Ingredient, Quantite> ingredients;

    /**
     * permet de creer une recette avec une liste d'ingredient et leur quantite
     * @param ingredients une liste contenant les ingredients et leurs quantites
     */
    public Recette(Map<Ingredient, Quantite> ingredients) {
        this.ingredients = new HashMap<>(ingredients);
    }

    /**
     * permet d'obtenir la liste d'ingredients de la recette
     * @return la liste d'ingredients et leur quantite
     */
    public Map<Ingredient, Quantite> getIngredients() {
        return ingredients;
    }
}
