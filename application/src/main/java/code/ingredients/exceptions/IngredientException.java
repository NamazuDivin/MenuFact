package code.ingredients.exceptions;

/**
 * Fait les exceptions pour les ingrédients
 *
 * @author Domingo
 * @version 1.0
 */
public class IngredientException extends Exception{
    public IngredientException(String message){
        super("IngredientException: " + message);
    }
}
