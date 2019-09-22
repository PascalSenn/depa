package ch.fhnw.depa.l01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionImpl<T> extends AbstractCollection<T> {
    private List<T> list = new ArrayList<T>();

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    @Override
    public boolean add(T e) {
        return list.add(e);
    }

}