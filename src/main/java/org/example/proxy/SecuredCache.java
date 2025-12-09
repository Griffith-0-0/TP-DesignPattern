package org.example.proxy;

public class SecuredCache implements User {
    private User target = new ProxyCache();
    private int password;

    @Override
    public int generatePIN(int userId) {
        System.out.println("[SecuredCache] Vérification du mot de passe...");
        if (password == 1234) {
            System.out.println("[SecuredCache] ✅ Mot de passe correct, accès autorisé");
            return target.generatePIN(userId);
        } else {
            System.out.println("[SecuredCache] ❌ Mot de passe incorrect!");
            throw new RuntimeException("password invalid");
        }
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public void setTarget(User target) {
        this.target = target;
    }
}
