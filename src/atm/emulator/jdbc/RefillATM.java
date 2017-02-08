/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.emulator.jdbc;
import java.sql.*;
/**
 *
 * @author Deepank Dixit
 */
public class RefillATM {
    
    public static void main(String...agrs){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm", "root", "password");
            
            
            //SELECT 
            String selectQuery = "SELECT * from CashManager";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(selectQuery);

            
            //UPDATE
            String updateQuery = "update CashManager set Thousands = 500, "
                    + "Fivehundreds = 30, Hundreds = 50, Fifties = 30, Totalcash = Thousands*1000 + "
                    + "Fivehundreds*500 + Fifties*50 + Hundreds*100";  
            int status = stmt.executeUpdate(updateQuery);
            if (status > 0)
                System.out.println("updated!");
            else
                System.out.println("Not updated!");
        }
        catch(Exception e){
            System.out.println("Could not perform refill operation.");
        }
    }
}
