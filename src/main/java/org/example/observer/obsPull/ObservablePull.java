package org.example.observer.obsPull;

public interface ObservablePull {
    void addObserver(ObserverPull o);
    void removeObserver(ObserverPull o);
    void notifyObservers();
}
