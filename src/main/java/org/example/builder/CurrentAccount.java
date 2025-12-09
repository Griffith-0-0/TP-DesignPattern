package org.example.builder;

public class CurrentAccount extends BankAccount{
    private double overdraft;
    private String accountType;

    protected CurrentAccount(CurrentAccountBuilder builder) {
        super(builder);
        this.overdraft=builder.overdraft;
        this.accountType=builder.accountType;
    }

    public static class CurrentAccountBuilder extends BankAccount.Builder<CurrentAccountBuilder> {
        private double overdraft;
        private String accountType;
        @Override
        protected CurrentAccountBuilder self() {
            return this;
        }
        public CurrentAccountBuilder overdraft(double overdraft) {
            this.overdraft=overdraft;
            return this;
        }
        public CurrentAccountBuilder accountType(String accountType) {
            this.accountType=accountType;
            return this;
        }

        @Override
        public CurrentAccount build() {
            if (accountNumber == null || accountNumber.isEmpty()) {
                throw new IllegalStateException("Account number is required");
            }
            if (ownerName == null || ownerName.isEmpty()) {
                throw new IllegalStateException("Owner name is required");
            }
            if (overdraft < 0) {
                throw new IllegalArgumentException("Overdraft limit cannot be negative");
            }
            return new CurrentAccount(this);
        }

        public void setOverdraft(double overdraft) {
            this.overdraft = overdraft;
        }

        public void setAccountType(String accountType) {
            this.accountType = accountType;
        }

        @Override
        public String toString() {
            return super.toString() +
                    String.format(", Type: Current (%s), Overdraft: %.2f",
                            accountType, overdraft);
        }
    }
}
