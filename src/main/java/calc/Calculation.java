package calc;

import data.CalculationResult;
import lombok.extern.java.Log;

import java.math.BigDecimal;

/**
 * Класс с общими методами рассчета кредита
 * @version 1.0
 * @autor Евгений Киселев
 */
@Log
public abstract class Calculation {

    CalculationResult calculationResult = new CalculationResult();


    void getCreditAmount(){
        if(calculationResult.getRealEstatePrice().compareTo(calculationResult.getInitialFee()) > 0 ) {
            calculationResult.setCreditAmount(calculationResult.getRealEstatePrice()
                    .subtract(calculationResult.getInitialFee()));
        }
        else {
            log.info("Первоначальный взнос больше/равен стоимости недвижимости");
            throw new IllegalStateException();
        }
    }

    abstract BigDecimal getMonthlyPayment();

    BigDecimal getRate(){
        return calculationResult.getRate();
    }

    BigDecimal getMonthRate(){
        return getRate().divide(BigDecimal.valueOf(100)).divide(BigDecimal.valueOf(12));
    }

    abstract int getMonthsCreditTerm();
}
