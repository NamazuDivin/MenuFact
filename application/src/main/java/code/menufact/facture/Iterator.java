package code.menufact.facture;

import code.menufact.plats.PlatChoisi;

public interface Iterator {
    public boolean hasNext();
    public PlatChoisi next();
}