package code.menufact.plats;

import code.ingredients.exceptions.IngredientException;

/**
 * Classe publique représentant la quantité d'ingrédient avec sa mesure
 *
 * @author Kevin et leanne
 * @version 1.0
 */
public class Quantite {
    private int qte;

    private String type;

    /**
     * permet de spécifier une quantite d'ingredient et son unite de mesure
     * @param qte d'ingredient
     * @param type unite de mesure
     */
    public Quantite (int qte, String type) {
        if (qte>=0) {
            this.qte = qte;
            this.type = type;
        } else {
            throw new IllegalArgumentException("la quantité doit être positive");
        }
    }

    /**
     * permet d'obtenir le nom de l'unite de mesure
     * @return l'unite
     */
    public String getType() {
        return type;
    }

    /**
     * permet d'obtenir la quantite d'ingredient
     * @return la quantite
     */
    public int getQte() {
        return qte;
    }
}
