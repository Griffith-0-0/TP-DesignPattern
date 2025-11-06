package org.example.observer.obsPush;

public class ObserverPushImpl1 implements ObserverPush {
    @Override
    public void updatePush(int state) {
        System.out.println("ObserverImpl1 update");
    }
}
