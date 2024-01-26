package com.group12.explorewild;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
    private static Connection conn=null;
    public static Connection getConnection(){

        try{
            Class.forName("org.sqlite.JDBC");
            //Class.forName("com.mysql.cj.jdbc.Driver");
            //String sqLiteDB="C:\\Users\\oshan\\Documents\\NetBeansProjects\\my\\mydb1.db";
            String dbname="explorewild";
            String SQLitedbname="explorewild.db";
            String username="root";
            String password="";
            String port="3306";
            //conn=DriverManager.getConnection("jdbc:mysql://localhost:"+port+"/"+dbname,username,password);
            conn=DriverManager.getConnection("jdbc:sqlite:"+SQLitedbname);

            System.out.print("connected DB");
        }

        catch (ClassNotFoundException | SQLException ex){
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE,null,ex);

        }
        return conn;
    }
}
