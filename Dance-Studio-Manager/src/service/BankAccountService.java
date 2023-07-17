package service;

import model.BankAccount;
import model.DanceCourse;

import java.math.BigDecimal;
import java.util.Random;

public class BankAccountService {
    public BankAccount createBankAccount(String bankName, String ibanNo, String companyName, BigDecimal amount) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setBankName(bankName);
        bankAccount.setIbanNo(ibanNo);
        bankAccount.setCompanyName(companyName);
        bankAccount.setAmount(amount);

        return bankAccount;
    }

    public BankAccount getBankAccountWithEnoughMoney(DanceCourse danceCourse, BigDecimal amount) {
        for (BankAccount bankAccount : danceCourse.getBankAccountList()) {
            if (bankAccount.getAmount().compareTo(amount) >= 0) {
                return bankAccount;
            }
        }
        return null;
    }

    public BankAccount getRandomBankAccount(DanceCourse danceCourse){
        Random random = new Random();
        BankAccount randomBankAccount = danceCourse.getBankAccountList().
                get(random.nextInt(danceCourse.getBankAccountList().size()));
        return randomBankAccount;
    }


}
