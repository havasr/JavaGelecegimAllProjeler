import model.*;
import service.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        AgencyService agencyService = new AgencyService();
        BankAccountService bankAccountService = new BankAccountService();
        InsuranceCompanyService insuranceCompanyService = new InsuranceCompanyService();
        InsuranceService insuranceService = new InsuranceService();
        CustomerService customerService = new CustomerService();
        VehicleService vehicleService = new VehicleService();
        InsuranceRequestService insuranceRequestService = new InsuranceRequestService();
        ProposalService proposalService = new ProposalService();

        Agency agency = agencyService.createAgency("Man Agency");

        BankAccount bankAccount1 = bankAccountService.createBankAccount("Is Bankasi", "TR531212312414",
                BigDecimal.ZERO);

        agencyService.addBankAccountToAgency(agency, bankAccount1);

        InsuranceCompany AllianzInsuranceCompany = insuranceCompanyService.createInsuranceCompany("Allianz",
                "Cankaya", "12345765814", "Istanbul/Kadikoy", new BigDecimal(8));

        agencyService.addInsuranceCompanyToAgency(agency, AllianzInsuranceCompany);

        Insurance insurance1 = insuranceService.createInsurance("Compulsory Traffic Insurance",
                InsuranceTypeEnum.COMPULSORY_TRAFFIC_INSURANCE);

        insuranceCompanyService.addInsuranceToInsuranceCompany(AllianzInsuranceCompany, insurance1);

        BankAccount AllianzBankAccount = bankAccountService.createBankAccount("Ziraat Bankasi",
                "TR12383193819", new BigDecimal(1500000));

        insuranceCompanyService.addBankAccountToInsuranceCompany(AllianzInsuranceCompany, AllianzBankAccount);

        Customer customer1 = customerService.createCustomer("Hava", CustomerTypeEnum.INDIVIDUAL);

        BankAccount customer1BankAccount = bankAccountService.createBankAccount("Is Bankasi",
                "TR1238504850", new BigDecimal(23000));

        customerService.addBankAccountToCustomer(customer1, customer1BankAccount);

        agencyService.addCustomerToAgency(agency, customer1);

        Vehicle vehicle1 = vehicleService.createVehicle("Ford", "Focus", "234DSFS42",
                "112314", 2010, ColorTypeEnum.BLACK);

        customerService.addVehicleToCustomer(customer1, vehicle1);

        InsuranceRequest insuranceRequest1 = insuranceRequestService.createInsuranceRequest(vehicle1);
        customerService.addInsuranceRequestToCustomer(customer1, insuranceRequest1);

        LocalDate startDate = LocalDate.of(2022, Month.APRIL, 15);
        LocalDate endDate = LocalDate.of(2023, Month.APRIL, 15);
        LocalDate expireDate = endDate.plusDays(3);


        Proposal proposal1 = proposalService.createProposal(AllianzInsuranceCompany, vehicle1,new BigDecimal(12000),
                startDate, endDate, expireDate, new BigDecimal(100));

        insuranceRequestService.addProposalToInsuranceRequest(insuranceRequest1, proposal1);







    }
}