package service;

import model.InsuranceRequest;
import model.Policy;
import model.Proposal;
import model.Vehicle;

import java.util.ArrayList;

public class InsuranceRequestService {

    public InsuranceRequest createInsuranceRequest(Policy policy, Vehicle vehicle){
        InsuranceRequest insuranceRequest = new InsuranceRequest();
        insuranceRequest.setPolicy(policy);
        insuranceRequest.setVehicle(vehicle);
        return  insuranceRequest;
    }

    public void addProposalToInsuranceRequest(InsuranceRequest insuranceRequest, Proposal proposal){
        if(insuranceRequest.getProposalList()!=null){
            insuranceRequest.getProposalList().add(proposal);
        } else {
            ArrayList<Proposal> proposalArrayList = new ArrayList<>();
            proposalArrayList.add(proposal);
            insuranceRequest.setProposalList(proposalArrayList);
        }
    }
}

