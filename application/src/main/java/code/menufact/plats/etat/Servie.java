package code.menufact.plats.etat;

import code.menufact.plats.PlatChoisi;

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
