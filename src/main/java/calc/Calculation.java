package calc;

import data.CalculationResult;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * Класс с общими методами рассчета кредита
 * @version 1.0
 * @autor Евгений Киселев
 */
public class Calculation {
    private final int PERCENT_MONTHS = 1200;

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
        return getRate().divide(BigDecimal.valueOf(PERCENT_MONTHS), MathContext.DECIMAL32);
    }

}
