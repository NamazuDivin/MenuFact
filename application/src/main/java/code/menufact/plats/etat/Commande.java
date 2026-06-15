package code.menufact.plats.etat;

import code.menufact.plats.PlatChoisi;

public class Commande implements State {
    public Commande() {}

    @Override
    public String getEtat() { return "Commande"; }

    @Override
    public void changeEtat(PlatChoisi plat) {
        plat.setEtat(new Preparation());
    }
}
