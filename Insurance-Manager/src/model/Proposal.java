package model;

import java.math.BigDecimal;
import java.util.Date;

public class Proposal {
    private InsuranceCompany insuranceCompany;
    private Vehicle vehicle;
    private BigDecimal offerPrice;
    private Date startDate;
    private Date endDate;
    private Date expireDate;
    private boolean isApproved;
    private BigDecimal discountPrice;

    public InsuranceCompany getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(InsuranceCompany insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public BigDecimal getOfferPrice() {
        return offerPrice;
    }

    public void setOfferPrice(BigDecimal offerPrice) {
        this.offerPrice = offerPrice;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public boolean getIsApproved(){
        return isApproved;
    }

    public void setIsApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }

    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }

    @Override
    public String toString() {
        return "Proposal{" +
                "insuranceCompany=" + insuranceCompany +
                ", vehicle=" + vehicle +
                ", offerPrice=" + offerPrice +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", expireDate=" + expireDate +
                ", isApproved=" + isApproved +
                ", discountPrice=" + discountPrice +
                '}';
    }
}
