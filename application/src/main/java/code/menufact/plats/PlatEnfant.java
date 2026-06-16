package code.menufact.plats;

/**
 * Classe publique représentant un plat pour enfant
 * Hérite de PlatAuMenu et ajoute une portion réduite
 *
 * @author Kevin et leanne
 * @version 2.0
 */
public class PlatEnfant extends PlatAuMenu{
    private double proportion;

    public PlatEnfant() {
    }

    public PlatEnfant(int code, String description, double prix, double proportion) {
        super(code, description, prix);
        this.proportion = proportion;
    }

    public double getProportion() {
        return proportion;
    }

    @Override
    public String toString() {
        return "PlatEnfant{" +
                "proportion=" + proportion +
                "} " + super.toString();
    }
}
