package service;

import model.BankAccount;
import model.Customer;
import model.CustomerTypeEnum;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    public Customer createCustomer(String name, CustomerTypeEnum customerTypeEnum){
        Customer customer = new Customer();
        customer.setName(name);
        customer.setCustomerTypeEnum(customerTypeEnum);
        return customer;
    }

    public void addBankAccountToCustomer(BankAccount bankAccount, Customer customer){
        if(customer.getBankAccountList()!=null){
            customer.getBankAccountList().add(bankAccount);
        } else {
            ArrayList<BankAccount> bankAccountArrayList = new ArrayList<>();
            bankAccountArrayList.add(bankAccount);
            customer.setBankAccountList(bankAccountArrayList);
            //customer.setBankAccountList(List.of(bankAccount));
        }
    }
}
