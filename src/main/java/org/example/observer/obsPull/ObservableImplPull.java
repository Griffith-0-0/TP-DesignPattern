package org.example.observer.obsPull;

import java.util.ArrayList;
import java.util.List;

public class ObservableImplPull implements ObservablePull {
    List<ObserverPull> observers = new ArrayList<>();
    int state;
    @Override
    public void addObserver(ObserverPull o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(ObserverPull o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (ObserverPull o : observers) {
            o.updatePull(this);
        }
    }

    public void setState(int state) {
        this.state = state;
        notifyObservers();
    }
    public int getState() {
        return state;
    }

}
