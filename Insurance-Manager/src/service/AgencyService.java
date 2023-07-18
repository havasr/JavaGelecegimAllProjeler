package service;

import model.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AgencyService {

    BankAccountService bankAccountService = new BankAccountService();
    PaymentMovementService paymentMovementService = new PaymentMovementService();
    ProposalService proposalService = new ProposalService();
    InsuranceCompanyService insuranceCompanyService = new InsuranceCompanyService();

    public Agency createAgency(String name){
        Agency agency = new Agency();
        agency.setName(name);

        return agency;
    }


    public void addInsuranceCompanyToAgency(Agency agency, InsuranceCompany insuranceCompany){
        if(agency.getInsuranceCompanyList()!=null){
            agency.getInsuranceCompanyList().add(insuranceCompany);
        } else {
            ArrayList<InsuranceCompany> insuranceCompanyArrayList = new ArrayList<>();
            insuranceCompanyArrayList.add(insuranceCompany);
            agency.setInsuranceCompanyList(insuranceCompanyArrayList);
        }
    }

    public void addCustomerToAgency(Agency agency, Customer customer){
        if(agency.getCustomerList()!=null){
            agency.getCustomerList().add(customer);
        } else {
            ArrayList<Customer> customerArrayList = new ArrayList<>();
            customerArrayList.add(customer);
            agency.setCustomerList(customerArrayList);
        }
    }

    public void addPaymentMovementToAgency(Agency agency, PaymentMovement paymentMovement){
        if(agency.getPaymentMovementList()!=null){
            agency.getPaymentMovementList().add(paymentMovement);
        } else {
            ArrayList<PaymentMovement> paymentMovementArrayList = new ArrayList<>();
            paymentMovementArrayList.add(paymentMovement);
            agency.setPaymentMovementList(paymentMovementArrayList);
        }
    }

    public void addBankAccountToAgency(Agency agency, BankAccount bankAccount) {

        if (agency.getBankAccountList() != null) {
            if (doesExistBankAccount(agency, bankAccount)) {
                addAmountToExistingBankAccount(agency, bankAccount);
            } else {
                agency.getBankAccountList().add(bankAccount);
            }
        } else {
            ArrayList<BankAccount> bankAccountList = new ArrayList<>();
            bankAccountList.add(bankAccount);
            agency.setBankAccountList(bankAccountList);
        }
    }

    private boolean doesExistBankAccount(Agency agency, BankAccount bankAccount) {
        boolean doesExist = false;

        for (BankAccount bankAccount1 : agency.getBankAccountList()) {
            if (bankAccount1.getIban().equals(bankAccount.getIban())) {
                bankAccount1.setAmount(bankAccount1.getAmount().add(bankAccount.getAmount()));
                doesExist = true;
                break;
            }
        }
        return doesExist;
    }

    private void addAmountToExistingBankAccount(Agency agency, BankAccount bankAccount) {
        for (BankAccount bankAccount1 : agency.getBankAccountList()) {
            if (bankAccount1.getIban().equals(bankAccount.getIban())) {
                bankAccount1.setAmount(bankAccount1.getAmount().add(bankAccount.getAmount()));
                break;
            }
        }
    }

    public void transferPolicyPayment(Agency agency, Proposal proposal){

        BigDecimal policyAmount = proposalService.calculateDiscountedPrice(proposal);

        //Poliçe Ücreti alınıyor ve PaymentMovement olusturuluyor-ekleniyor.

        BankAccount bankAccount = bankAccountService.getRandomBankAccount(agency.getBankAccountList());

        PaymentMovement paymentMovement1 = paymentMovementService.createPaymentMovement(bankAccount,
                proposal.getVehicle() + " Policy Payment", MovementTypeEnum.INCOME, policyAmount);

        addPaymentMovementToAgency(agency, paymentMovement1);

        //Poliçe Ücreti şirkete gönderiliyor, PaymentMovement olusturuluyor-ekleniyor.

        PaymentMovement paymentMovement2 = paymentMovementService.createPaymentMovement(bankAccount,
                proposal.getVehicle() + " Policy Payment", MovementTypeEnum.OUTCOME, policyAmount);

        addPaymentMovementToAgency(agency, paymentMovement2);
    }

    public void addCommissionToAgency(Agency agency, Proposal proposal){

        BigDecimal commissionAmount =
                insuranceCompanyService.calculateCommissionAmount(proposal.getInsuranceCompany(), proposal);
        BankAccount bankAccount = bankAccountService.getRandomBankAccount(agency.getBankAccountList());
        bankAccount.setAmount(bankAccount.getAmount().add(commissionAmount));

        PaymentMovement paymentMovement = paymentMovementService.createPaymentMovement(bankAccount,
                proposal.getVehicle() + " Commission Payment", MovementTypeEnum.INCOME, commissionAmount);

        addPaymentMovementToAgency(agency, paymentMovement);
    }
}
