package code.menufact.facture;

import code.menufact.plats.PlatChoisi;

import java.util.ArrayList;

public class FactureIterator implements Iterator{

    private ArrayList<PlatChoisi> plats;
    private int index;

    public FactureIterator(ArrayList<PlatChoisi> plats){
        this.plats = plats;
        this.index = 0;
    }

    public boolean hasNext(){
        return index<plats.size();
    }

    public PlatChoisi next(){
        return plats.get(index++)
    }
}