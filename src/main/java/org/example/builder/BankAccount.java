package org.example.builder;


public abstract class BankAccount {
    protected String accountNumber;
    protected String ownerName;
    protected double balance;
    protected String currency;
    protected BankAccount(Builder<?> builder) {
        this.accountNumber=builder.accountNumber;
        this.ownerName=builder.ownerName;
        this.balance=builder.balance;
        this.currency=builder.currency;

    }
    // Builder generic pour apres remplacer le T par une classe qui herite de BankAccount et redfinir self en utilisant this
    public static abstract class Builder<T extends Builder<T>> {
        protected String accountNumber;
        protected String ownerName;
        protected double balance;
        protected String currency= "EUR";

        protected abstract T self();

        protected T accountNumber(String accountNumber) {
            this.accountNumber=accountNumber;
            return self();
        }
        protected T ownerName(String ownerName) {
            this.ownerName=ownerName;
            return self();
        }
        protected T balance(double balance) {
            this.balance=balance;
            return self();
        }
        protected T currency(String currency) {
            this.currency=currency;
            return self();
        }
        public abstract BankAccount build();

    }
    @Override
    public String toString() {
        return String.format("Account: %s, Owner: %s, Balance: %.2f %s",
                accountNumber, ownerName, balance, currency);
    }
}
