package code.menufact.facture;

import code.menufact.plats.PlatChoisi;

/**
 * Interface du design pattern Iterator
 *
 * @author Kevin et Léanne
 * @version 1.0
 */
public interface Iterator {

    /**
     * Vérifie si il reste des plats à parcourir dans la liste
     *
     * @return true si il reste des plats à parcourir dans la liste
     */
    public boolean hasNext();

    /**
     * Retourne le prochain plat en augmentant l'index
     *
     * @return le prochain plat dans la liste
     */
    public PlatChoisi next();
}