package service;

import model.*;

import java.math.BigDecimal;
import java.util.ArrayList;

public class InsuranceCompanyService {
    BankAccountService bankAccountService = new BankAccountService();
    PaymentMovementService paymentMovementService = new PaymentMovementService();
    ProposalService proposalService = new ProposalService();

    public InsuranceCompany createInsuranceCompany(String name, String taxOffice, String taxNumber, String address,
                                                   BigDecimal commission) {
        InsuranceCompany insuranceCompany = new InsuranceCompany();
        insuranceCompany.setName(name);
        insuranceCompany.setTaxOffice(taxOffice);
        insuranceCompany.setTaxNumber(taxNumber);
        insuranceCompany.setAddress(address);
        insuranceCompany.setCommission(commission);

        return insuranceCompany;
    }

    public void addInsuranceToInsuranceCompany(InsuranceCompany insuranceCompany, Insurance insurance) {
        if (insuranceCompany.getInsuranceList() != null) {
            insuranceCompany.getInsuranceList().add(insurance);
        } else {
            ArrayList<Insurance> insuranceArrayList = new ArrayList<>();
            insuranceArrayList.add(insurance);
            insuranceCompany.setInsuranceList(insuranceArrayList);
        }
    }

    public void addBankAccountToInsuranceCompany(InsuranceCompany insuranceCompany, BankAccount bankAccount) {
        if (insuranceCompany.getBankAccountList() != null) {
            insuranceCompany.getBankAccountList().add(bankAccount);
        } else {
            ArrayList<BankAccount> bankAccountArrayList = new ArrayList<>();
            bankAccountArrayList.add(bankAccount);
            insuranceCompany.setBankAccountList(bankAccountArrayList);
        }
    }

    public void addPaymentMovementToInsuranceCompany(InsuranceCompany insuranceCompany, PaymentMovement paymentMovement) {
        if (insuranceCompany.getPaymentMovementList() != null) {
            insuranceCompany.getPaymentMovementList().add(paymentMovement);
        } else {
            ArrayList<PaymentMovement> paymentMovementArrayList = new ArrayList<>();
            paymentMovementArrayList.add(paymentMovement);
            insuranceCompany.setPaymentMovementList(paymentMovementArrayList);
        }
    }

    public void policyPaymentToInsuranceCompany(InsuranceCompany insuranceCompany, Proposal proposal) {

        //Poliçe Ücreti alınıyor ve PaymentMovement olusturuluyor-ekleniyor.

        BigDecimal policyAmount = proposalService.calculateDiscountedPrice(proposal);
        BankAccount bankAccount = bankAccountService.getRandomBankAccount(insuranceCompany.getBankAccountList());

        bankAccount.setAmount(bankAccount.getAmount().add(policyAmount));

        PaymentMovement paymentMovement1 = paymentMovementService.createPaymentMovement(bankAccount,
                proposal.getVehicle() + " Poliçe Ödemesi", MovementTypeEnum.INCOME, policyAmount);

        addPaymentMovementToInsuranceCompany(insuranceCompany, paymentMovement1);

        //Şirket komisyonu Acentaya gönderiyor, PaymentMovement oluştur-ekle

       bankAccount.setAmount(bankAccount.getAmount().subtract(calculateCommissionAmount(insuranceCompany, proposal)));

        PaymentMovement paymentMovement2 = paymentMovementService.createPaymentMovement(bankAccount,
                proposal.getVehicle() + " Komisyon Ödemesi", MovementTypeEnum.OUTCOME,
                calculateCommissionAmount(insuranceCompany, proposal));

        addPaymentMovementToInsuranceCompany(insuranceCompany, paymentMovement2);

    }

    // Komisyon ucreti hesaplaniyor
    public BigDecimal calculateCommissionAmount(InsuranceCompany insuranceCompany, Proposal proposal) {

        BigDecimal policyAmount = proposalService.calculateDiscountedPrice(proposal);
        BigDecimal commissionAmount =
                (policyAmount.multiply(insuranceCompany.getCommission())).divide(new BigDecimal(100));
        return commissionAmount;
    }

}

