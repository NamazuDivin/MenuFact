package code.menufact.plats.etat;

import code.menufact.plats.PlatChoisi;

public interface State {
    String getEtat();
    void changeEtat(PlatChoisi plat);
}
