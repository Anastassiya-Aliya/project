package com.company;
import java.net.*;
import java.sql.*;

public class Server {
    public static Connection connection;
    public static void main(String[] args) {
        try{
            connectToDb();
            ServerSocket ss = new ServerSocket(5009);

            while(true){
                System.out.println("waiting for user");
                Socket socket = ss.accept();
                System.out.println("new user connected");

                ServerThread sth = new ServerThread(socket,connection);
                sth.start();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


    public static  void connectToDb(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/Registration?serverTimezone=UTC",
                            "root",
                            "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
