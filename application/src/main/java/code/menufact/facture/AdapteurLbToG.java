package code.menufact.facture;

import code.menufact.plats.Quantite;

/**
 * Classe publique permettant de transformer un poids en gramme à partir d'un poids en livre
 * design pattern Adapteur
 *
 * @author Kevin et leanne
 * @version 1.0
 */
public class AdapteurLbToG {
    private Quantite quantite;

    /**
     * permet de creer un adapteur pour une quantite
     * @param quantite
     */
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
