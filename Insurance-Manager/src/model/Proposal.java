package model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class Proposal {
    private InsuranceCompany insuranceCompany;
    private Vehicle vehicle;
    private BigDecimal offerPrice;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate expireDate;
    private boolean isApproved= Boolean.FALSE;
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
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
