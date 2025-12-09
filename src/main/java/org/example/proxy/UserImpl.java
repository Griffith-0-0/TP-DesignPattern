package org.example.proxy;

public class UserImpl implements User {

    public UserImpl() {
    }

    @Override
    public int generatePIN(int userId) {
        int pin = (int) (1000 - Math.random() * 1000 + 100);
        System.out.println("    [UserImpl] Génération d'un nouveau PIN: " + pin);
        return pin;
    }
}
