package org.example.proxy;

public class Client {
    private User user;
    public void recupererPIN(int userId){
        System.out.println("recuperer PIN ..."+user.generatePIN(userId));
        System.out.println(".".repeat(80));

    }

    public void setUser(User user) {
        this.user = user;
    }
}
