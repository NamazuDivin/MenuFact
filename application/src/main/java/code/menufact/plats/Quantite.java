package code.menufact.plats;

public class Quantite {
    private int qte;

    private String type;

    public Quantite (int qte, String type) {
        this.qte = qte;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public int getQte() {
        return qte;
    }
}
