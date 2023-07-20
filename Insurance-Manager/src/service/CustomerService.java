package service;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    ProposalService proposalService = new ProposalService();
    PaymentMovementService paymentMovementService = new PaymentMovementService();
    InsuranceRequestService insuranceRequestService = new InsuranceRequestService();
    AgencyService agencyService = new AgencyService();
    BankAccountService bankAccountService = new BankAccountService();
    InsuranceCompanyService insuranceCompanyService = new InsuranceCompanyService();

    public Customer createCustomer(String name, CustomerTypeEnum customerTypeEnum) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setCustomerTypeEnum(customerTypeEnum);
        return customer;
    }

    public void addBankAccountToCustomer(Customer customer, BankAccount bankAccount) {
        if (customer.getBankAccountList() != null) {
            customer.getBankAccountList().add(bankAccount);
        } else {
            ArrayList<BankAccount> bankAccountArrayList = new ArrayList<>();
            bankAccountArrayList.add(bankAccount);
            customer.setBankAccountList(bankAccountArrayList);
        }
    }

    public void addInsuranceRequestToCustomer(Customer customer, InsuranceRequest insuranceRequest) {
        if (customer.getInsuranceRequestList() != null) {
            customer.getInsuranceRequestList().add(insuranceRequest);
        } else {
            ArrayList<InsuranceRequest> insuranceRequestArrayList = new ArrayList<>();
            insuranceRequestArrayList.add(insuranceRequest);
            customer.setInsuranceRequestList(insuranceRequestArrayList);
        }
    }

    public void addPolicyToCustomer(Customer customer, Policy policy) {
        if (customer.getPolicyList() != null) {
            customer.getPolicyList().add(policy);
        } else {
            ArrayList<Policy> policyArrayList = new ArrayList<>();
            policyArrayList.add(policy);
            customer.setPolicyList(policyArrayList);
        }
    }

    public void addVehicleToCustomer(Customer customer, Vehicle vehicle) {
        if (customer.getVehicleList() != null) {
            customer.getVehicleList().add(vehicle);
        } else {
            ArrayList<Vehicle> vehicleArrayList = new ArrayList<>();
            vehicleArrayList.add(vehicle);
            customer.setVehicleList(vehicleArrayList);
        }
    }

    public void addPaymentMovementToCustomer(Customer customer, PaymentMovement paymentMovement) {
        if (customer.getPaymentMovementList() != null) {
            customer.getPaymentMovementList().add(paymentMovement);
        } else {
            ArrayList<PaymentMovement> paymentMovementArrayList = new ArrayList<>();
            paymentMovementArrayList.add(paymentMovement);
            customer.setPaymentMovementList(paymentMovementArrayList);
        }
    }


    public void acceptProposal(Agency agency, Customer customer, Proposal proposal, InsuranceRequest insuranceRequest) {
        List<InsuranceRequest> insuranceRequestList = customer.getInsuranceRequestList();
        for (InsuranceRequest request : insuranceRequestList) {
            if (request.equals(insuranceRequest)) {
                for (Proposal proposal1 : request.getProposalList()) {
                    if (proposal1.equals(proposal)) {
                        BankAccount bankAccount = bankAccountService.checkBankAccount(customer.getBankAccountList(),
                                proposalService.calculateDiscountedPrice(proposal));
                        if (bankAccount != null) {

                            //Müşteri hesabindan ödemeyi yapıyor, PaymentMovement oluşuyor, PaymentMovement müşteriye ekleniyor.
                            bankAccount.setAmount(
                                    bankAccount.getAmount().subtract(proposalService.calculateDiscountedPrice(proposal)));

                            PaymentMovement paymentMovement = paymentMovementService.createPaymentMovement(bankAccount,
                                    proposal.getVehicle() + " Policy Payment", MovementTypeEnum.OUTCOME,
                                    proposalService.calculateDiscountedPrice(proposal));

                            addPaymentMovementToCustomer(customer, paymentMovement);

                            //Agency parametre olarak eklendi, Acenta ödemeyi alıyor, Acenta Şirkete ödeme yapıyor

                            agencyService.transferPolicyPayment(agency, proposal);

                            //Şirket ödemeyi alıyor, Şirket komisyonu Acentaya gönderiyor

                            insuranceCompanyService.policyPaymentToInsuranceCompany(proposal.getInsuranceCompany(), proposal);

                            //Acenta komisyonu alıyor, PaymentMovement oluştur-ekle

                            agencyService.addCommissionToAgency(agency, proposal);

                            //Proposal approved, Poliçe InsuranceRequeste ekleniyor.

                            proposal.setIsApproved(true);
                            insuranceRequestService.addProposalAsPolicyToInsuranceRequest(insuranceRequest, proposal);

                            System.out.println("Congratulations you're policy has been approved.");

                        } else {
                            System.out.println("Insufficient balance for policy.");
                        }

                    } else {
                        System.out.println("Proposal does not belong to this insurance request.");
                    }
                }
            } else {
                System.out.println("Insurance request does not belong to this customer.");
            }
        }
    }


}
