package config;

/**
 * Класс для хранения и использования настроек
 * @version 1.0
 * @autor Евгений Киселев
 */

public class CalcConfiguration {

    private boolean hasDBConnection = false;

    public boolean hasDBConnection() {
        return hasDBConnection;
    }

    public void setHasDBConnection(boolean hasDBConnection) {
        this.hasDBConnection = hasDBConnection;
    }

}
