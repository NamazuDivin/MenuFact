package code.ingredients;

/**
 * Classe pour le design pattern Factory des épices
 *
 * @author Kevin et Léanne
 * @version 1.0
 */
public class FactoryEpice extends FactoryIngredient {

    /**
     * Créer une instance de la factory
     */
    public FactoryEpice() {
    }

    /**
     * Créer un objet ingrédient de type Épice
     *
     * @return Objet Epice
     */
    public Ingredient creerIngredient() { return new Epice(); }
}