package code.menufact.plats;
import code.menufact.plats.etat.Commande;
import code.menufact.plats.etat.State;

/**
 * Classe publique permettant d'accéder aux informations d'un PlatChoisi
 *
 * @author Kevin et leanne
 * @version 2.0
 */
public class PlatChoisi {
    private PlatAuMenu plat;
    private int quantite;
    private State etat;

    /**
     * permet de creer le plat choisi et enregistrer son etat, plat et qte
     * @param plat
     * @param quantite
     */
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

    /**
     * permet d'obtenir le nom de l'etat actuel
     * @return
     */
    public String getEtat() {
        return etat.getEtat();
    }

    /**
     * permet de changer l'etat pour un etat choisi
     * @param etat etat que va devenir le plat
     */
    public void setEtat(State etat) {
        this.etat = etat;
    }

    /**
     * permet de changer l'etat du plat en fonction de l'etat precedent
     */
    public void changeEtat() {
        etat.changeEtat(this);
    }
}
