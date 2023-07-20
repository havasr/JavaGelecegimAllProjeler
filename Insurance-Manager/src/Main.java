import model.*;
import service.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
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
        AccidentService accidentService = new AccidentService();

        Agency manAgency = agencyService.createAgency("Man Agency");

        BankAccount manBankAccount = bankAccountService.createBankAccount("Is Bankasi", "TR531212312414",
                BigDecimal.ZERO);

        agencyService.addBankAccountToAgency(manAgency, manBankAccount);

        InsuranceCompany allianzInsuranceCompany = insuranceCompanyService.createInsuranceCompany("Allianz",
                "Cankaya", "12345765814", "Istanbul/Kadikoy", new BigDecimal(8));

        agencyService.addInsuranceCompanyToAgency(manAgency, allianzInsuranceCompany);

        Insurance insurance1 = insuranceService.createInsurance("Compulsory Traffic Insurance",
                InsuranceTypeEnum.COMPULSORY_TRAFFIC_INSURANCE);

        insuranceCompanyService.addInsuranceToInsuranceCompany(allianzInsuranceCompany, insurance1);

        BankAccount AllianzBankAccount = bankAccountService.createBankAccount("Ziraat Bankasi",
                "TR12383193819", new BigDecimal(15000000));

        insuranceCompanyService.addBankAccountToInsuranceCompany(allianzInsuranceCompany, AllianzBankAccount);

        Customer customer1 = customerService.createCustomer("Hava", CustomerTypeEnum.INDIVIDUAL);

        BankAccount customer1BankAccount = bankAccountService.createBankAccount("Is Bankasi",
                "TR1238504850", new BigDecimal(23000));

        customerService.addBankAccountToCustomer(customer1, customer1BankAccount);

        agencyService.addCustomerToAgency(manAgency, customer1);

        Vehicle vehicle1 = vehicleService.createVehicle("Ford", "Focus", "234DSFS42",
                "112314", 2010, ColorTypeEnum.BLACK);
        Vehicle vehicle2 = vehicleService.createVehicle("Ford", "Focus", "23ASDFS42",
                "124234", 2013, ColorTypeEnum.BLUE);

        customerService.addVehicleToCustomer(customer1, vehicle1);

        InsuranceRequest insuranceRequest1 = insuranceRequestService.createInsuranceRequest(vehicle1);
        InsuranceRequest insuranceRequest2 = insuranceRequestService.createInsuranceRequest(vehicle2);
        customerService.addInsuranceRequestToCustomer(customer1, insuranceRequest1);

        LocalDate startDate = LocalDate.of(2022, Month.APRIL, 15);
        LocalDate endDate = LocalDate.of(2023, Month.APRIL, 15);
        LocalDate expireDate = endDate.plusDays(3);

        Proposal proposal1 = proposalService.createProposal(allianzInsuranceCompany, vehicle1,new BigDecimal(12000),
                startDate, endDate, expireDate, new BigDecimal(1000));
        Proposal proposal2 = proposalService.createProposal(allianzInsuranceCompany, vehicle2,new BigDecimal(15000),
                startDate, endDate, expireDate, new BigDecimal(2000));

        insuranceRequestService.addProposalToInsuranceRequest(insuranceRequest1, proposal1);

        System.out.println(insuranceRequest1.getPolicy());
        System.out.println(AllianzBankAccount.getAmount());
        System.out.println(manBankAccount.getAmount());
        System.out.println(customer1BankAccount.getAmount());
        System.out.println("------------------------------------------------------------------------------------");

        customerService.acceptProposal(manAgency, customer1, proposal1, insuranceRequest1);
        customerService.addPolicyToCustomer(customer1, insuranceRequest1.getPolicy());

        System.out.println(insuranceRequest1.getPolicy());
        System.out.println(AllianzBankAccount.getAmount());
        System.out.println(manBankAccount.getAmount());
        System.out.println(customer1BankAccount.getAmount());

        System.out.println(manAgency.getPaymentMovementList());

        System.out.println("------------------------------------------------------------------------------------");

        LocalDate accidentDate = LocalDate.now();
        Accident accident1 = accidentService.createAccident( accidentDate, vehicle2 + " Accident", new BigDecimal(5000), 6 );
        vehicleService.addAccidentToVehicle(vehicle2, accident1);

        Proposal proposal3 =
                proposalService.createProposal(allianzInsuranceCompany, vehicle2, BigDecimal.valueOf(10000), startDate,
                        endDate, expireDate, new BigDecimal(1000));
        System.out.println(proposal3);


    }
}