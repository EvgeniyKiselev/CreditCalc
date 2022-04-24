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

    private long calculationId = 0;
    private BigDecimal creditAmount = new BigDecimal(0);
    private BigDecimal monthlyPayment = new BigDecimal(50000);
    private BigDecimal rate = new BigDecimal(8.3);
    private BigDecimal realEstatePrice = new BigDecimal(7000000);
    private BigDecimal initialFee = new BigDecimal(1500000);
    private int creditTerm = 20;

}
