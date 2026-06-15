package code.menufact.facture;

import code.menufact.plats.Quantite;

public class AdapteurLbToG {
    private Quantite quantite;

    public AdapteurLbToG(Quantite quantite) {
        this.quantite = quantite;
    }

    /**
     * permet de transformer des lb en grammes
     * @return des grammes
     */
    public int adapteQte() {
        return quantite.getQte()*454;
    }
}
