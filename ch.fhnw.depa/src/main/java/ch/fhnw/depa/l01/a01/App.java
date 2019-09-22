package ch.fhnw.depa.l01.a01;

import java.util.Collection;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public abstract class App implements Application {

    @Override
    public int size() {
        var size = 0;
        for (var e : this) {
            size++;
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return !iterator().hasNext();
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            throw new IllegalArgumentException("No null value allowed");
        }
        for (var e : this) {
            if (o.equals(e)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] objArr = new Object[size()];
        return toArray(objArr);
    }

    @Override
    public <K> K[] toArray(K[] a) {
        int index = 0;
        for (var e : this) {
            a[index] = (K) e;
            index++;
        }
        return a;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            throw new IllegalArgumentException("No null value allowed");
        }
        var iterator = iterator();
        while (iterator.hasNext()) {
            if (o.equals(iterator.next())) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return c.stream().parallel().allMatch((elm) -> contains(elm));
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return c.stream().parallel().filter((elm) -> add(elm)).count() > 0;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return c.stream().parallel().filter((elm) -> remove(elm)).count() > 0;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        var changed = false;
        var iterator = iterator();
        while (iterator.hasNext()) {
            if (c.contains(iterator.next())) {
                iterator.remove();
                changed = true;
            }
        }
        return changed;
    }

    @Override
    public void clear() {
        removeAll(this);
    }

}