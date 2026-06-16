package code.menufact.plats.etat;

import code.menufact.plats.PlatChoisi;

/**
 * Classe publique permettant de modifier l'état d'une commande à impossible
 *
 * @author Kevin et leanne
 * @version 1.0
 */
public class Impossible implements State {
    public Impossible() {}

    /**
     * permet d'obtenir le nom de l'etat actuel
     * @return le string de l'etat
     */
    @Override
    public String getEtat() { return "Impossible"; }

    /**
     * la fonction est vide puisque il n'y a pas d'etat apres impossible
     * @param plat
     */
    @Override
    public void changeEtat(PlatChoisi plat) {}
}
