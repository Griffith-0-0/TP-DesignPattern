package org.example.builder;

public class BankAccountDirector {
    private int accountNumber;

    private String generateAccountNumber(String prefix) {
        return prefix +"-"+ (accountNumber++);
    }

    // current account types------------------------------------------------------------
    public CurrentAccount createStandardAccount(String ownerName, double initialDeposit) {
        return new CurrentAccount.CurrentAccountBuilder()
                .accountNumber(generateAccountNumber("STD"))
                .ownerName(ownerName)
                .balance(initialDeposit)
                .overdraft(500.0)
                .accountType("STANDARD")
                .build();
    }
    public CurrentAccount createPremiumAccount(String ownerName, double initialDeposit) {
        if (initialDeposit < 5000.0) {
            throw new IllegalArgumentException("Premium account requires minimum 5000 EUR deposit");
        }
        return new CurrentAccount.CurrentAccountBuilder()
                .accountNumber(generateAccountNumber("STD"))
                .ownerName(ownerName)
                .balance(initialDeposit)
                .overdraft(10000.0)
                .accountType("PREMIUM")
                .build();
    }

    // savings account types ------------------------------------------------------------
    public SavingsAccount createStandardSavingsAccount(String ownerName, double initialDeposit) {
        return new SavingsAccount.SavingsAccountBuilder()
                .accountNumber(generateAccountNumber("SAV"))
                .ownerName(ownerName)
                .balance(initialDeposit)
                .interestRate(2.0)
                .build();
    }

    public SavingsAccount createRetirementAccount(String ownerName, int age, double initialDeposit) {
        double interestRate;
        if (age < 30) {
            interestRate = 3.0;
        } else if (age < 50) {
            interestRate = 4.0;
        } else {
            interestRate = 4.5;
        }

        return new SavingsAccount.SavingsAccountBuilder()
                .accountNumber(generateAccountNumber("RET"))
                .ownerName(ownerName)
                .balance(initialDeposit)
                .interestRate(interestRate)
                .build();
    }
}
