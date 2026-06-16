package code.menufact.chef;

import code.menufact.plats.PlatChoisi;

/**
 * Classe pour un chef cuisinier
 * design pattern Observateur
 *
 * @author Kevin et Léanne
 * @version 1.0
 */
public class Chef implements Observateur {
    /**
     * Notifier le chef automatiquement lorsqu'un nouveau plat est ajouté
     */
    public void update(){
        System.out.println("le chef a été notifié d'une nouvelle facture");
    }

    /**
     * Permet au chef de changer l'état d'un plat
     * @param plat
     */
    public void cuisiner(PlatChoisi plat) {
        plat.changeEtat();
    }
}