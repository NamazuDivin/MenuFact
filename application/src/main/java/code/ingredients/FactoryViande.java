package code.ingredients;

/**
 * Classe pour le design pattern Factory des viandes
 *
 * @author Kevin et Léanne
 * @version 1.0
 */
public class FactoryViande extends FactoryIngredient {

    /**
     * Créer une instance de la factory
     */
    public FactoryViande() {
    }

    /**
     * Créer un objet ingrédient de type Viande
     *
     * @return Objet Viande
     */
    public Ingredient creerIngredient() {
        return new Viande();
    }
}