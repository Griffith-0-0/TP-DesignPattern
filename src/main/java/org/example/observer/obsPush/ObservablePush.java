package org.example.observer.obsPush;

public interface ObservablePush {
    void addObserver(ObserverPush o);
    void removeObserver(ObserverPush o);
    void notifyObservers();
}
