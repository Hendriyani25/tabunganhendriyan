/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabunganhendrian.controller;

import java.sql.ResultSet;
import java.sql.Statement;
import tabunganhendrian.helper.SQLiteHelper;
import tabunganhendrian.model.Uang;

/**
 *
 * @author Asus
 */
public class ControllerTabungan {
    private static Uang uang;
    
    public static void initialize() {
        String queryCreateTable = "create table if not exists tabungan (id integer, saldo integer);";
        
        double savedSaldo = 0d;
        
        try {
            Statement statement = SQLiteHelper.getInstance()
                    .getConnection()
                    .createStatement();
            
            statement.execute(queryCreateTable);
            
            ResultSet resultSet = statement.executeQuery("select * from tabungan where id='1' limit 1;");
            
            if (!resultSet.next()) {
                statement.execute("insert into tabungan (id, saldo) values (1, 0);");
            } else {
                savedSaldo = resultSet.getDouble("saldo");
            }
            
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        uang = new Uang(savedSaldo);
    }
    
    public void nabung(double saldo){
        uang.setValue(saldo + uang.getValue());
        
        String queryUpdateSaldo = "update tabungan set saldo = '" + uang.getValue() + "' where id='1'";

        try {
            Statement statement = SQLiteHelper.getInstance()
                    .getConnection()
                    .createStatement();
            
            statement.execute(queryUpdateSaldo);
            
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public double tampilkanSaldo(){
        return uang.getValue();
    }
    
    public void ngambil(double saldo){
        uang.setValue(uang.getValue() - saldo);
        
        String queryUpdateSaldo = "update tabungan set saldo = '" + uang.getValue() + "' where id='1'";

        try {
            Statement statement = SQLiteHelper.getInstance()
                    .getConnection()
                    .createStatement();
            
            statement.execute(queryUpdateSaldo);
            
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
