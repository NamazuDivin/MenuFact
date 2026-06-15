package code.menufact.facture;

import code.menufact.plats.PlatChoisi;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class FactureIterator implements Iterator{

    private ArrayList<PlatChoisi> plats;
    private int index;

    public FactureIterator(ArrayList<PlatChoisi> plats){
        this.plats = plats;
        this.index = 0;
    }

    @Override
    public boolean hasNext(){
        return index<plats.size();
    }

    @Override
    public PlatChoisi next(){
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        return plats.get(index++);
    }
}