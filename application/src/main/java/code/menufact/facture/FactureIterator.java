package code.menufact.facture;

import code.menufact.plats.PlatChoisi;
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Classe itérateur sur les plats choisis d'une facture
 * implémente le design pattern Iterator
 *
 * @author Kevin et Léanne
 * @version 1.0
 */
public class FactureIterator implements Iterator{

    private ArrayList<PlatChoisi> plats;
    private int index;

    /**
     * Crée un itérateur sur les plats à parcourir
     *
     * @param plats à parcourir
     */
    public FactureIterator(ArrayList<PlatChoisi> plats){
        this.plats = plats;
        this.index = 0;
    }

    @Override
    /**
     * Vérifie si il reste des plats à parcourir dans la liste
     *
     * @return true si il reste des plats à parcourir dans la liste
     */
    public boolean hasNext(){
        return index<plats.size();
    }

    @Override
    /**
     * Retourne le prochain plat en augmentant l'index
     *
     * @return le prochain plat dans la liste
     */
    public PlatChoisi next(){
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        return plats.get(index++);
    }
}