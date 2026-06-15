package code.ingredients;

/**
 * Classe pour le design pattern Factory des légumes
 *
 * @author Kevin et Léanne
 * @version 1.0
 */
public class FactoryLegume extends FactoryIngredient {

    /**
     * Créer une instance de la factory
     */
    public FactoryLegume() {
    }

    /**
     * Créer un objet ingrédient de type Legume
     *
     * @return Objet Legume
     */
    public Ingredient creerIngredient() {
        return new Legume();
    }
}