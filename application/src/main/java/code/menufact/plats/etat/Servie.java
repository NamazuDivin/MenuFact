package code.menufact.plats.etat;

import code.menufact.plats.PlatChoisi;

/**
 * Classe publique permettant de modifier l'état d'une commande à servie
 *
 * @author Kevin et leanne
 * @version 1.0
 */
public class Servie implements State {
    public Servie() {}

    /**
     * permet d'obtenir le nom de l'etat actuel
     * @return le string de l'etat
     */
    @Override
    public String getEtat() { return "Servie"; }

    /**
     * la fonction est vide puisque servie est le dernier etat possible
     * @param plat
     */
    @Override
    public void changeEtat(PlatChoisi plat) {}
}
