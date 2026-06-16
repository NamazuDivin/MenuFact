package code.inventaire;

import code.ingredients.Ingredient;
import code.ingredients.IngredientInventaire;
import code.ingredients.exceptions.IngredientException;
import code.menufact.Menu;

import java.util.ArrayList;

/**
 * Classe pour Inventaire des ingrédients
 *
 * @author Domingo
 * @version 1.0
 */
public class Inventaire {
    private ArrayList<IngredientInventaire> lesIngredients = new ArrayList<>();

    /**
     * Ajouter des ingrédients dans l'inventaire
     *
     * @param ingredient le type d'ingrédient à ajouter
     */
    public void ajouter (Ingredient ingredient, Integer quantite) throws IngredientException {
        if (quantite>=0) {
            for(IngredientInventaire i: lesIngredients) {
                if (i.getIngredient()==ingredient) {
                    i.setQuantite(i.getQuantite()+quantite);
                    return;
                }
            }
            lesIngredients.add(new IngredientInventaire(ingredient, quantite));
        } else {
            throw new IngredientException("Il ne peut pas y avoir une quantite negative d'ingredient");
        }
    }

    /**
     * permet d'obtenir la quantite d'un ingredient dans l'inventaire
     * s'il n'y ait pas, return 0
     * @param ingredient
     * @return quantite d'ingredient
     */
    public int getQuantite(Ingredient ingredient) {
        for(IngredientInventaire i:lesIngredients){
            if(i.getIngredient()==ingredient){
                return i.getQuantite();
            }
        }
        return 0;
    }

    /**
     * permet de set une quantite d'ingredient, la quantite indiquee
     * sera la nouvelle quantite en inventaire
     * @param ingredient
     * @param qte
     * @throws IngredientException si la quantite qu'on essaie de set est negative
     */
    public void setQuantite(Ingredient ingredient, Integer qte) throws IngredientException {
        for(IngredientInventaire i:lesIngredients){
            if(i.getIngredient()==ingredient){
                i.setQuantite(qte);
            }
        }
    }


    private static Inventaire instance;
    private Inventaire() {}

    /**
     * singleton, assure qu'un seul inventaire existe en tout temps
     * @return l'instance de l'inventaire
     */
    public static Inventaire getInstance(){
        if (instance == null){
            instance = new Inventaire();
        }
        return instance;
    }
}
