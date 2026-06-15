package code.menufact.plats.etat;

import code.menufact.plats.PlatChoisi;

public class Servie implements State {
    public Servie() {}
    @Override
    public String getEtat() { return "Servie"; }

    @Override
    public void changeEtat(PlatChoisi plat) {}
}
