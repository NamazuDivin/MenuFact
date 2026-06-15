package code.menufact;

import code.menufact.exceptions.MenuException;
import code.menufact.plats.PlatAuMenu;

import java.util.ArrayList;

/**
 * Classe représentant le menu
 *
 * @author Kevin et Léanne
 * @version 1.0
 */
public class Menu {
    private String description;
    private int courant;
    private ArrayList<PlatAuMenu> plat = new ArrayList<PlatAuMenu>();

    private static Menu instance;

    /**
     * Constructeur privé du menu
     *
     * @param description du menu
     */
    private Menu(String description) {
        this.description = description;
    }

    /**
     * Retourne l'instance unique du menu si en crée un
     *
     * @param description du menu
     * @return l'instance du menu
     */
    public static Menu getInstance(String description){
        if (instance == null){
            instance = new Menu(description);
        }
        return instance;
    }

    /**
     * Ajoute un plat au menu
     *
     * @param p le plat à ajouter
     */
    void ajoute (PlatAuMenu p)
    {
        plat.add(p);
    }

    /**
     * Déplace l'index à la position donnée
     *
     * @param i position donnée
     */
    public void position(int i)
    {
        courant = i;
    }

    /**
     * Retourne le plat à la position courante
     *
     * @return le plat à la position courante
     */
    public PlatAuMenu platCourant()
    {
        return plat.get(courant);
    }

    /**
     * Augmente la position au plat suivant
     *
     * @throws MenuException si la limite maximale de plats est dépassé
     */
    public void positionSuivante() throws MenuException
    {
        if (courant+1 >= plat.size())
            throw new MenuException("On depasse le nombre maximale de plats.");
        else
            courant++;
    }

    /**
     * Réduit la position au plat précédent
     *
     * @throws MenuException si la limite minimale de plats est dépassé
     */
    public void positionPrecedente() throws MenuException
    {
        if (courant-1 < 0)
            throw new MenuException("On depasse le nombre minimale de plats");
        else
            courant--;
    }


    /**
     * Retourne les informations du menu en texte
     *
     * @return les informations du menu en texte
     */
    @Override
    public String toString() {
        return "menufact.Menu{" +
                "description='" + description + '\'' +
                ", courant=" + courant +
                ", plat=" + "\n" + plat +
                '}';
    }
}
