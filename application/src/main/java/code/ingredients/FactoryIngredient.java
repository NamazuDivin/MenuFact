package code.ingredients;

/**
 * Classe abstraite pour le design pattern Factory des ingrédients
 * Les sous classe sont responsable de leur propre ingrédient
 *
 * @author Kevin et Léanne
 * @version 1.0
 */
public abstract class FactoryIngredient{

    /**
     * Crée une instance de FactoryIngredient
     */
    public FactoryIngredient(){
    }

    /**
     * Crée et retourne un nouvel ingrédient
     * Doit être implémené par chaque sous-classe
     *
     * @return un nouvel ingrédient du même type que la factory
     */
    public abstract Ingredient creerIngredient();
}