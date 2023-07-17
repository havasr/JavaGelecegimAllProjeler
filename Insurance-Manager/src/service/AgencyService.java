package service;

import model.Agency;
import model.BankAccount;
import model.Insurance;
import model.InsuranceCompany;

import java.util.ArrayList;
import java.util.List;

public class AgencyService {
    public Agency createAgency(String name){
        Agency agency = new Agency();
        agency.setName(name);

        return agency;
    }

    public  void addBankAccountToAgency(Agency agency, BankAccount bankAccount){
        if(agency.getBankAccountList()!=null){
            agency.getBankAccountList().add(bankAccount);
        } else {
            ArrayList<BankAccount> bankAccountArrayList = new ArrayList<>();
            bankAccountArrayList.add(bankAccount);
            agency.setBankAccountList(bankAccountArrayList);
            //agency.setBankAccountList(List.of(bankAccount));
        }
            }

    public void addInsuranceCompanyToAgency(Agency agency, InsuranceCompany insuranceCompany){
        if(agency.getInsuranceCompanyList()!=null){
            agency.getInsuranceCompanyList().add(insuranceCompany);
        } else {
            ArrayList<InsuranceCompany> insuranceCompanyArrayList = new ArrayList<>();
            insuranceCompanyArrayList.add(insuranceCompany);
            agency.setInsuranceCompanyList(insuranceCompanyArrayList);
            //agency.setInsuranceCompanyList(List.of(insuranceCompany));
        }
    }
}
