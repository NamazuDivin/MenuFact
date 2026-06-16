package code.menufact.plats.etat;

import code.menufact.plats.PlatChoisi;

public class Preparation implements State {
    public Preparation() {}

    /**
     * permet d'obtenir le nom de l'etat actuel
     * @return le string de l'etat
     */
    @Override
    public String getEtat() { return "Preparation"; }

    /**
     * permet de changer l'etat actuel du plat vers le prochain etat
     * @param plat
     */
    @Override
    public void changeEtat(PlatChoisi plat) {
        plat.setEtat(new Termine());
    }
}
