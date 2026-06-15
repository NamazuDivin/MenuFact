package code.menufact.plats;
import code.menufact.plats.etat.Commande;
import code.menufact.plats.etat.State;


public class PlatChoisi {
    private PlatAuMenu plat;
    private int quantite;
    private State etat;

    public PlatChoisi(PlatAuMenu plat, int quantite) {
        this.plat = plat;
        this.quantite = quantite;
        this.etat = new Commande();
    }

    @Override
    public String toString() {
        return "menufact.plats.PlatChoisi{" +
                "quantite=" + quantite +
                ", plat=" + plat +
                '}';
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public PlatAuMenu getPlat() {
        return plat;
    }

    public String getEtat() {
        return etat.getEtat();
    }

    public void setEtat(State etat) {
        this.etat = etat;
    }

    public void changeEtat() {
        etat.changeEtat(this);
    }
}
