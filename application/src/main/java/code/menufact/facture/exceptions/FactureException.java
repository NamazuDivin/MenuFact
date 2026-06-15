package code.menufact.facture.exceptions;

/**
 * Lorsqu'un opération dans facture est invalide
 *
 * @author Domingo
 * @version 1.0
 */
public class FactureException extends Exception{

    /**
     * Crée un FactureException avec un message
     *
     * @param message description de l'erreur
     */
    public FactureException(String message){
        super("FactureException: " + message);
   }
}
