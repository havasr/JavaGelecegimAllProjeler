package service;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    public Customer createCustomer(String name, CustomerTypeEnum customerTypeEnum){
        Customer customer = new Customer();
        customer.setName(name);
        customer.setCustomerTypeEnum(customerTypeEnum);
        return customer;
    }

    public void addBankAccountToCustomer(Customer customer, BankAccount bankAccount){
        if(customer.getBankAccountList()!=null){
            customer.getBankAccountList().add(bankAccount);
        } else {
            ArrayList<BankAccount> bankAccountArrayList = new ArrayList<>();
            bankAccountArrayList.add(bankAccount);
            customer.setBankAccountList(bankAccountArrayList);
            //customer.setBankAccountList(List.of(bankAccount));
        }
    }

    public void addInsuranceRequestToCustomer(Customer customer, InsuranceRequest insuranceRequest){
        if(customer.getInsuranceRequestList()!=null){
            customer.getInsuranceRequestList().add(insuranceRequest);
        } else {
            ArrayList<InsuranceRequest> insuranceRequestArrayList = new ArrayList<>();
            insuranceRequestArrayList.add(insuranceRequest);
            customer.setInsuranceRequestList(insuranceRequestArrayList);
        }
    }

    public void addPolicyToCustomer(Customer customer, Policy policy){
        if(customer.getPolicyList()!=null){
            customer.getPolicyList().add(policy);
        } else {
            ArrayList<Policy> policyArrayList = new ArrayList<>();
            policyArrayList.add(policy);
            customer.setPolicyList(policyArrayList);
        }
    }

    public void addVehicleToCustomer(Customer customer, Vehicle vehicle){
        if(customer.getVehicleList()!=null){
            customer.getVehicleList().add(vehicle);
        } else {
            ArrayList<Vehicle> vehicleArrayList = new ArrayList<>();
            vehicleArrayList.add(vehicle);
            customer.setVehicleList(vehicleArrayList);
        }
    }

    public void addPaymentMovementToCustomer(Customer customer, PaymentMovement paymentMovement){
        if(customer.getPaymentMovementList()!=null){
            customer.getPaymentMovementList().add(paymentMovement);
        } else {
            ArrayList<PaymentMovement> paymentMovementArrayList = new ArrayList<>();
            paymentMovementArrayList.add(paymentMovement);
            customer.setPaymentMovementList(paymentMovementArrayList);
        }
    }

}