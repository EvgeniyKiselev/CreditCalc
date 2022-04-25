package data;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Класс для хранения параметров рассчитаного кредита
 * @version 1.0
 * @autor Евгений Киселев
 */
@Data
public class CalculationResult {

    private long calculationId;
    private BigDecimal creditAmount;
    private BigDecimal monthlyPayment;
    private BigDecimal rate;
    private BigDecimal realEstatePrice;
    private BigDecimal initialFee;
    private int creditTerm;

}
