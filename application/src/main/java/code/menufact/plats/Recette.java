package code.menufact.plats;
import code.ingredients.Ingredient;

import java.util.HashMap;
import java.util.Map;

public class Recette {

    private Map<Ingredient, Quantite> ingredients;

    Recette(Map<Ingredient, Quantite> ingredients) {
        this.ingredients = new HashMap<>(ingredients);
    }

    public Map<Ingredient, Quantite> getIngredients() {
        return ingredients;
    }
}
