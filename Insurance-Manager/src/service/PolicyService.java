package service;

import model.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class PolicyService {
    public Policy createPolicy(InsuranceCompany insuranceCompany, Vehicle vehicle, BigDecimal price, LocalDate startDate,
                               LocalDate endDate) {
        Policy policy = new Policy();
        policy.setInsuranceCompany(insuranceCompany);
        policy.setVehicle(vehicle);
        policy.setPrice(price);
        policy.setStartDate(startDate);
        policy.setEndDate(endDate);

        return policy;
    }


}

