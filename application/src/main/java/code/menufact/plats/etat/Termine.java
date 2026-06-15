package code.menufact.plats.etat;

import code.menufact.plats.PlatChoisi;

public class Termine implements State {
    public Termine() {}
    @Override
    public String getEtat() { return "Termine"; }

    @Override
    public void changeEtat(PlatChoisi plat) {
        plat.setEtat(new Servie());
    }
}
