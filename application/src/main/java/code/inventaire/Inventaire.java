package code.inventaire;

import code.ingredients.Ingredient;

import java.util.ArrayList;

/**
 * Classe pour Inventaire des ingrédients
 *
 * @author Domingo
 * @version 1.0
 */
public class Inventaire {
    private ArrayList<Ingredient> lesIngredients = new ArrayList<Ingredient>();

    /**
     * Ajouter des ingrédients dans l'inventaire
     *
     * @param ingredient le type d'ingrédient à ajouter
     */
    public void ajouter (Ingredient ingredient)
    {
        lesIngredients.add(ingredient);
    }

}
