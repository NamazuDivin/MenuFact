package code.menufact.chef;

public class Chef implements Observateur {
    public void update(){
        System.out.println("le chef a été notifié d'une nouvelle facture");
    }
}