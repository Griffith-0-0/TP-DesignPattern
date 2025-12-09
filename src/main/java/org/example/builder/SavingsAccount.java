package org.example.builder;

public class SavingsAccount extends BankAccount{
    private double interestRate;

    public SavingsAccount(SavingsAccountBuilder builder) {
        super(builder);
        this.interestRate=builder.interestRate;

    }
    public static class SavingsAccountBuilder extends BankAccount.Builder<SavingsAccountBuilder> {
        private double interestRate;

        @Override
        protected SavingsAccountBuilder self() {
            return this;
        }
        public SavingsAccountBuilder interestRate(double interestRate) {
            this.interestRate=interestRate;
            return this;
        }

        @Override
        public SavingsAccount build() {
            if (accountNumber == null || accountNumber.isEmpty()) {
                throw new IllegalStateException("Account number is required");
            }
            if (ownerName == null || ownerName.isEmpty()) {
                throw new IllegalStateException("Owner name is required");
            }
            if (interestRate < 0) {
                throw new IllegalArgumentException("Interest rate cannot be negative");
            }
            return new SavingsAccount(this);
        }
    }
    @Override
    public String toString() {
        return super.toString() +
                String.format(", Type: Savings, Interest Rate: %.2f%%",
                        interestRate);
    }

    public double getInterestRate() {
        return interestRate;
    }
}
