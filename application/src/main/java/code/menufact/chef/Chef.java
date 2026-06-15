package code.menufact.chef;

import code.menufact.plats.PlatChoisi;

public class Chef implements Observateur {

    public void update(){
        System.out.println("le chef a été notifié d'une nouvelle facture");
    }

    public void cuisiner(PlatChoisi plat) {
        plat.changeEtat();
    }
}