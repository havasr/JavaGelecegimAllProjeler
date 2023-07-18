package service;

import model.InsuranceCompany;
import model.Proposal;
import model.Vehicle;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProposalService {

    public Proposal createProposal(InsuranceCompany insuranceCompany, Vehicle vehicle, BigDecimal offerPrice,
                                   LocalDate startDate, LocalDate endDate, LocalDate expireDate, BigDecimal discountPrice){
        Proposal proposal = new Proposal();
        proposal.setInsuranceCompany(insuranceCompany);
        proposal.setVehicle(vehicle);
        proposal.setOfferPrice(offerPrice);
        proposal.setEndDate(endDate);
        proposal.setStartDate(startDate);
        proposal.setExpireDate(expireDate);
        proposal.setDiscountPrice(discountPrice);

        return proposal;
    }

    public BigDecimal calculateDiscountedPrice(Proposal proposal){
        if(proposal.getDiscountPrice()!=null){
            return proposal.getOfferPrice().subtract(proposal.getDiscountPrice());
        }
        else{
            return proposal.getOfferPrice();
        }
    }

}
