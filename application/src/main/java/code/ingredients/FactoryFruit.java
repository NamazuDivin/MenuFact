package code.ingredients;

/**
 * Classe pour le design pattern Factory des fruits
 *
 * @author Kevin et Léanne
 * @version 1.0
 */
public class FactoryFruit extends FactoryIngredient {

    /**
     * Créer une instance de la factory
     */
    public FactoryFruit() {
    }

    /**
     * Créer un objet ingrédient de type Fruit
     *
     * @return Objet Fruit
     */
    public Ingredient creerIngredient() {
        return new Fruit();
    }
}