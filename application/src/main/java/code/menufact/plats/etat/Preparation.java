package code.menufact.plats.etat;

import code.menufact.plats.PlatChoisi;

public class Preparation implements State {
    public Preparation() {}
    @Override
    public String getEtat() { return "Preparation"; }

    @Override
    public void changeEtat(PlatChoisi plat) {
        plat.setEtat(new Termine());
    }
}
