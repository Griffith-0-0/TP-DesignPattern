package org.example.observer.obsPush;

public class ObserverPushImpl2 implements ObserverPush {
    @Override
    public void updatePush(int state) {
        System.out.println("ObserverImpl2 update");
    }
}
