package org.example.observer.obsPush;

import java.util.ArrayList;
import java.util.List;

public class ObservableImplPush implements ObservablePush {
    List<ObserverPush> observerPushes = new ArrayList<>();
    int state;
    @Override
    public void addObserver(ObserverPush o) {
        observerPushes.add(o);
    }

    @Override
    public void removeObserver(ObserverPush o) {
        observerPushes.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (ObserverPush o : observerPushes) {
            o.updatePush(state);
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
