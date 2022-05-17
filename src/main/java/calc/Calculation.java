package calc;

import data.CalculationResult;

import java.math.BigDecimal;

/**
 * Класс с общими методами рассчета кредита
 * @version 1.0
 * @autor Евгений Киселев
 */
public class Calculation {

    CalculationResult calculationResult = CalculationResult.getInstance();

    public void getCreditAmount(){
        if(calculationResult.getRealEstatePrice().compareTo(calculationResult.getInitialFee()) > 0 ) {
            calculationResult.setCreditAmount(calculationResult.getRealEstatePrice()
                    .subtract(calculationResult.getInitialFee()));
        }
        else {
            throw new IllegalStateException("Первоначальный взнос больше/равен стоимости недвижимости");
        }
    }

    public BigDecimal getRate(){
        return calculationResult.getRate();
    }

    public BigDecimal getMonthRate(){
        BigDecimal ratePercent = getRate().divide(BigDecimal.valueOf(100));

        return ratePercent.divide(BigDecimal.valueOf(12));
    }

}
