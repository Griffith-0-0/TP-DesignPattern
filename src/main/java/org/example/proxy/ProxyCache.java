package org.example.proxy;

import java.util.HashMap;
import java.util.Map;

public class ProxyCache implements User {
    public User user = new UserImpl();
    public Map<Integer, Integer> cache = new HashMap<>();

    @Override
    public int generatePIN(int userId) {
        if (!cache.containsKey(userId)) {
            System.out.println("[ProxyCache] PIN non trouvé dans le cache, génération...");
            int pin = user.generatePIN(userId);
            cache.put(userId, pin);
            return pin;
        } else {
            System.out.println("  [ProxyCache] PIN trouvé dans le cache!");
            return cache.get(userId);
        }
    }
}
