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


    BigDecimal getCreditAmount(){
        BigDecimal creditAmount;
        if(calculationResult.getRealEstatePrice().compareTo(calculationResult.getInitialFee()) > 0 ) {
            creditAmount = calculationResult.getRealEstatePrice().subtract(calculationResult.getInitialFee());
        }
        else {
            log.info("Первоначальный взнос больше/равен стоимости недвижимости");
            throw new IllegalStateException();
        }
        return creditAmount;
    }

    abstract BigDecimal getMonthlyPayment();

    BigDecimal getRate(){
        return calculationResult.getRate();
    }

    abstract int getCreditTerm();
}
