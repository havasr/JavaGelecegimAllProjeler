package service;

import model.Agency;
import model.BankAccount;
import model.Customer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BankAccountService {

    public BankAccount createBankAccount(String name, String iban, BigDecimal amount) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setName(name);
        bankAccount.setIban(iban);
        bankAccount.setAmount(amount);

        return bankAccount;
    }

    //Icinde yeterli bakiyenin bulundugu banka hesabini buluyor.
    public BankAccount checkBankAccount(ArrayList<BankAccount> bankAccountArrayList, BigDecimal amount) {
        for (BankAccount bankAccount : bankAccountArrayList) {
            if (bankAccount.getAmount().compareTo(amount) >= 0) {
                return bankAccount;
            }
        }
        return null;
    }

    //Banka listesinden rastgele banka hesabi seciyor
    public BankAccount getRandomBankAccount(ArrayList<BankAccount> bankAccountArrayList) {
        Random random = new Random();
        BankAccount randomBankAccount = bankAccountArrayList.get(random.nextInt(bankAccountArrayList.size()));
        return randomBankAccount;
    }

}

