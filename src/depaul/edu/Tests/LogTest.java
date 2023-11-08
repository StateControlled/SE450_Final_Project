package depaul.edu.Tests;

import depaul.edu.Logger.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class LogTest {

    public static void main(String[] args) {
        EventLogger.getLoggerInstance("test");
        try {
            throw new ClassNotFoundException("Error");
        } catch (Exception e) {
            System.out.println("Task 1 failed successfully!");
            EventLogger.log(Level.INFO, "Test message 1", e); 
        }

        try {
            testFunction1(0);
        } catch (Exception e) {
            System.out.println("Task 2 failed successfully!");
            EventLogger.log(Level.WARNING, "Test message 2", e); 
        }

        try {
            testFunction2("Red");
        } catch (Exception e) {
            System.out.println("Task 3 failed successfully!");
            EventLogger.log(Level.SEVERE, "Test message 3", e); 
        }

        try {
            Connection con = DriverManager.getConnection("jdbc:myDriver:myDatabase", "username", "password");
            con.createStatement();
        } catch (Exception e) {
            System.out.println("Task 4 failed successfully!");
            EventLogger.log(Level.TRANSACTION, "Test message 4", e); 
        }
        
    }

    public static double testFunction1(int x) {
        return 1/x;
    }

    public static String testFunction2(String s) {
        return s.substring(6, 10);
    }
}
