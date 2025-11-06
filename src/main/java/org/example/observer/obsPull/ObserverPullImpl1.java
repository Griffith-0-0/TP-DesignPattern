package org.example.observer.obsPull;

public class ObserverPullImpl1 implements ObserverPull {
    @Override
    public void updatePull(ObservablePull observable) {

        if (observable instanceof ObservableImplPull obs) {
            System.out.println("ObserverImpl1 update"+obs.getState());
            System.out.println(obs.getState());
        }

    }
}
