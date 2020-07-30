package com.sudhir.web;
import java.sql.Connection;
import java.sql.DriverManager;
public class ConnectionManager {
	static Connection con;
    static String url;
    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/app";
            con = DriverManager.getConnection(url,"root","Sudheer@1998");
            System.out.println("success");
        }
        catch(Exception e){
            System.out.println("sql error");
        }
        return con;
    }
}
