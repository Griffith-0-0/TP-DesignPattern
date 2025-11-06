package org.example.observer;

import org.example.observer.obsPull.ObservableImplPull;
import org.example.observer.obsPull.ObservablePull;
import org.example.observer.obsPull.ObserverPull;
import org.example.observer.obsPull.ObserverPullImpl1;
import org.example.observer.obsPush.*;

public class Main {
    public static void main(String[] args) throws Exception {
        ObservableImplPush observablePush = new ObservableImplPush();
        ObserverPush observerPush1 = new ObserverPushImpl1();
        ObserverPush observerPush2 = new ObserverPushImpl2();
        ObserverPush observerPush3 = new ObserverPushImpl3();

        observablePush.addObserver(observerPush1);
        observablePush.addObserver(observerPush2);
        observablePush.addObserver(observerPush3);

        System.out.println("patie push+++++++++++++++++++++++++++++");
        observablePush.setState(3);
        System.out.println("--------------------");

        observablePush.removeObserver(observerPush1);
        observablePush.setState(2);
        System.out.println("--------------------");

        observablePush.removeObserver(observerPush2);
        observablePush.setState(1);
        System.out.println("--------------------");

        observablePush.removeObserver(observerPush3);
        observablePush.setState(0);
        System.out.println("------anonymous part-------------");
        observablePush.addObserver(new ObserverPush() {
            @Override
            public void updatePush(int state) {
                System.out.println("anonymous update");
            }
        });
        observablePush.addObserver(state -> {
            System.out.println("anonymous update lambda");
        });
        observablePush.setState(10);
        System.out.println("patie pull+++++++++++++++++++++++++++++");
        ObservableImplPull observablePull = new ObservableImplPull();
        ObserverPull observerPull1 = new ObserverPullImpl1();

        observablePull.addObserver(observerPull1);
        observablePull.addObserver(o -> {
            if (o instanceof ObservableImplPull oIMP) {
                System.out.println("observer update lambda"+oIMP.getState());
            }

        });
        observablePull.setState(10);



    }
}