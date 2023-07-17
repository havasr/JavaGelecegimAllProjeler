package service;

import model.InsuranceCompany;
import model.Proposal;
import model.Vehicle;

import java.math.BigDecimal;
import java.util.Date;

public class ProposalService {

    public Proposal createProposal(InsuranceCompany insuranceCompany, Vehicle vehicle, BigDecimal offerPrice,
                                   Date startDate, Date endDate, Date expireDate, boolean isApproved, BigDecimal discountPrice){
        Proposal proposal = new Proposal();
        proposal.setInsuranceCompany(insuranceCompany);
        proposal.setVehicle(vehicle);
        proposal.setOfferPrice(offerPrice);
        proposal.setEndDate(endDate);
        proposal.setStartDate(startDate);
        proposal.setExpireDate(expireDate);
        proposal.setIsApproved(isApproved);
        proposal.setDiscountPrice(discountPrice);

        return proposal;
    }
}
