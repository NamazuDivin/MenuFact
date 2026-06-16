package code.menufact.plats;
import code.ingredients.Ingredient;
import code.ingredients.exceptions.IngredientException;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe permettant de construire une recette
 * Design Pattern Builder
 *
 * @author Kevin et Léanne
 * @version 2.0
 */
public class RecetteBuilder {
    public RecetteBuilder() {
        ingredients = new HashMap<>();
    }

    private Map<Ingredient, Quantite> ingredients;

    /**
     * permet d'ajouter un ingredient dans la liste d'ingredient
     * @param ingredient
     * @param qte
     * @param unite
     * @return l'object pour pouvoir enchainer les commandes
     */
    public RecetteBuilder ajouterIngredient(Ingredient ingredient, int qte, String unite) {
        Quantite quantite = new Quantite(qte,unite);
        ingredients.put(ingredient,quantite);
        return this;
    }

    /**
     * permet de construire la recette avec la liste d'ingredients
     * @return l'object recette créé
     */
    public Recette build() {
        Recette recette = new Recette(ingredients);
        ingredients = new HashMap<>();
        return recette;
    }
}
