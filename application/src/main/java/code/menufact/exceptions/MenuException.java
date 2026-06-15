package code.menufact.exceptions;

/**
 * Lorsqu'un opération dans menu est invalide
 *
 * @author Domingo
 * @version 1.0
 */
public class MenuException extends Exception{

    /**
     * Crée un MenuException avec un message
     *
     * @param message description de l'erreur
     */
    public MenuException(String message){
        super("MenuException: " + message);
    }
}

