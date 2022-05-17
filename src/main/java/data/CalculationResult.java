package data;

import java.math.BigDecimal;

/**
 * Класс для хранения параметров рассчитаного кредита
 * @version 1.0
 * @autor Евгений Киселев
 */
public class CalculationResult {

    private static CalculationResult instance;
    private long calculationId;
    private BigDecimal creditAmount;
    private BigDecimal monthlyPayment;
    private BigDecimal rate;
    private BigDecimal realEstatePrice;
    private BigDecimal initialFee;
    private int creditTerm;


    private CalculationResult() {}

    public static CalculationResult getInstance(){
        if(instance == null){
            instance = new CalculationResult();
        }
        return instance;
    }

    public long getCalculationId() {
        return calculationId;
    }

    public void setCalculationId(long calculationId) {
        this.calculationId = calculationId;
    }

    public BigDecimal getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(BigDecimal creditAmount) {
        this.creditAmount = creditAmount;
    }

    public BigDecimal getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(BigDecimal monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getRealEstatePrice() {
        return realEstatePrice;
    }

    public void setRealEstatePrice(BigDecimal realEstatePrice) {
        this.realEstatePrice = realEstatePrice;
    }

    public BigDecimal getInitialFee() {
        return initialFee;
    }

    public void setInitialFee(BigDecimal initialFee) {
        this.initialFee = initialFee;
    }

    public int getCreditTerm() {
        return creditTerm;
    }

    public void setCreditTerm(int creditTerm) {
        this.creditTerm = creditTerm;
    }

}
