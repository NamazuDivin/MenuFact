package code.menufact.plats.etat;

import code.menufact.plats.PlatChoisi;

public class Impossible implements State {
    public Impossible() {}
    @Override
    public String getEtat() { return "Impossible"; }

    @Override
    public void changeEtat(PlatChoisi plat) {}
}
