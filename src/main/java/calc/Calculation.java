package calc;

import data.CalculationResult;

import java.math.BigDecimal;

/**
 * Класс с общими методами рассчета кредита
 * @version 1.0
 * @autor Евгений Киселев
 */
public abstract class Calculation {

    CalculationResult calculationResult = new CalculationResult();


    public void getCreditAmount(){
        if(calculationResult.getRealEstatePrice().compareTo(calculationResult.getInitialFee()) > 0 ) {
            calculationResult.setCreditAmount(calculationResult.getRealEstatePrice()
                    .subtract(calculationResult.getInitialFee()));
        }
        else {
            throw new IllegalStateException("Первоначальный взнос больше/равен стоимости недвижимости");
        }
    }

    public abstract BigDecimal getMonthlyPayment();

    public BigDecimal getRate(){
        return calculationResult.getRate();
    }

    public BigDecimal getMonthRate(){
        return getRate().divide(BigDecimal.valueOf(100)).divide(BigDecimal.valueOf(12));
    }

    public abstract int getMonthsCreditTerm();
}
