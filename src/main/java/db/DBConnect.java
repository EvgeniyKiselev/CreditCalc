package db;

import config.CalcConfiguration;

/**
 * Класс с настройками коннекта к бд
 * @version 1.0
 * @autor Евгений Киселев
 */

public class DBConnect {

    CalcConfiguration calcConfiguration = new CalcConfiguration();

    private void checkDBConnect(){
        boolean connect = false;
        //
        //
        //
        if(connect){
            calcConfiguration.setHasDBConnection(true);
        }
    }

    public void createTable(){
        if(calcConfiguration.hasDBConnection()){
            if(!checkTableExists()){
                //создаем таблицу
            }
        }
    }

    private boolean checkTableExists(){
        boolean isTableExists = false;
        //проверяем наличие таблицы
        return  isTableExists;
    }
}
