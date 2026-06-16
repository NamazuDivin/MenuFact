package code.menufact.plats.etat;

import code.menufact.plats.PlatChoisi;

/**
 * Classe publique permettant de gerer les états d'une commande
 *
 * @author Kevin et leanne
 * @version 1.0
 */
public interface State {

    /**
     * permet d'obtenir le nom de l'etat actuel
     * @return
     */
    String getEtat();

    /**
     * permet de changer l'etat actuel du plat vers le prochain etat
     * @param plat
     */
    void changeEtat(PlatChoisi plat);
}
