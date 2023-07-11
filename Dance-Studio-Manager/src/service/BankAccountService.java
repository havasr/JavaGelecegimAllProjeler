package service;

import model.BankAccount;
import model.DanceCourse;

import java.math.BigDecimal;

public class BankAccountService {
    public BankAccount createBankAccount(String bankName, String ibanNo, String companyName, BigDecimal amount){
        BankAccount bankAccount = new BankAccount();
        bankAccount.setBankName(bankName);
        bankAccount.setIbanNo(ibanNo);
        bankAccount.setCompanyName(companyName);
        bankAccount.setAmount(amount);

        return bankAccount;
    }



}
