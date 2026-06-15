package code.ingredients;

/**
 * Classe pour le design pattern Factory des Laitiers
 *
 * @author Kevin et Léanne
 * @version 1.0
 */
public class FactoryLaitier extends FactoryIngredient {

    /**
     * Créer une instance de la factory
     */
    public FactoryLaitier() {
    }

    /**
     * Créer un objet ingrédient de type Laitier
     *
     * @return Objet Laitier
     */
    public Ingredient creerIngredient() {
        return new Laitier();
    }
}