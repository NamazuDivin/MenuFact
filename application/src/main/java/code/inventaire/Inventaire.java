package code.inventaire;

import code.ingredients.Ingredient;
import code.ingredients.IngredientInventaire;
import code.ingredients.exceptions.IngredientException;
import code.menufact.Menu;

import java.util.ArrayList;

public class Inventaire {
    private ArrayList<IngredientInventaire> lesIngredients = new ArrayList<>();

    public void ajouter (Ingredient ingredient, Integer quantite) throws IngredientException {
        for(IngredientInventaire i: lesIngredients) {
            if (i.getIngredient()==ingredient) {
                i.setQuantite(i.getQuantite()+quantite);
                return;
            }
        }
        lesIngredients.add(new IngredientInventaire(ingredient,quantite));
    }

    public int getQuantite(Ingredient ingredient) {
        for(IngredientInventaire i:lesIngredients){
            if(i.getIngredient()==ingredient){
                return i.getQuantite();
            }
        }
        return 0;
    }

    public void setQuantite(Ingredient ingredient, Integer qte) throws IngredientException {
        for(IngredientInventaire i:lesIngredients){
            if(i.getIngredient()==ingredient){
                i.setQuantite(qte);
            }
        }
    }

    // ***** Implementation du singleton *****
    private static Inventaire instance;

    // constructeur prive
    private Inventaire() {}

    // getInstance
    public static Inventaire getInstance(){
        if (instance == null){
            instance = new Inventaire();
        }
        return instance;
    }
    // ***** Fin implementation du singletion *****

}
