package com.company;

import javax.print.attribute.standard.PDLOverrideSupported;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class UserConnect {
    public static ObjectOutputStream outputStream;
    public static ObjectInputStream inputStream;
    public static Socket socket;
    public static MainFrame frame;
    public static String login_;
    public static Users newUser;

    public static void connectToServer(){
        try {
            socket=new Socket("127.0.0.1",5009);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());
        }catch (Exception e){e.printStackTrace();}
    }
    public static void addUsers(Users users){
        PackageData pd=new PackageData();
        pd.setOperationType("Register");
        pd.setUser(users);
        try {
            outputStream.writeObject(pd);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public  static void addParticipants(CoursePartisipants participants){
        PackageData pd=new PackageData();
        pd.setOperationType("Add");
        pd.setPartisipant(participants);
        try {
            outputStream.writeObject(pd);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static boolean login(String login, String password){
        PackageData pd=new PackageData();
        pd.setOperationType("Enter");
        pd.setUser(new Users(login, password));
        try{
           outputStream.writeObject(pd);
           Thread.sleep(20);
           pd=(PackageData) inputStream.readObject();
           if(pd.getOperationType().equals("y"))
               return true;
           else return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public  static ArrayList<Object> getMovies(){
        try{
            PackageData pd=new PackageData();
            pd.setOperationType("Movies");
            outputStream.writeObject(pd);
            pd=(PackageData)inputStream.readObject();
            if(pd.getOperationType().equals("Movies")){
                return  pd.getBox();
            }
            else return null;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public  static ArrayList<Object> getCartoons(){
        try{
            PackageData pd=new PackageData();
            pd.setOperationType("Cartoons");
            outputStream.writeObject(pd);
            pd=(PackageData)inputStream.readObject();
            if(pd.getOperationType().equals("Cartoons")){
                return  pd.getBox();
            }
            else return null;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public  static ArrayList<Object> getSerials(){
        try{
            PackageData pd=new PackageData();
            pd.setOperationType("Serials");
            outputStream.writeObject(pd);
            pd=(PackageData)inputStream.readObject();
            if(pd.getOperationType().equals("Serials")){
                return  pd.getBox();
            }
            else return null;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public  static ArrayList<Object> getSongs(){
        try{
            PackageData pd=new PackageData();
            pd.setOperationType("Songs");
            outputStream.writeObject(pd);
            pd=(PackageData)inputStream.readObject();
            if(pd.getOperationType().equals("Songs")){
                return  pd.getBox();
            }
            else return null;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static void deleteWithLogin(String login){
        PackageData pd=new PackageData();
        pd.setOperationType("Delete_Account");
        pd.setLogin(login);
        Users user=pd.getUser();
        try {
            outputStream.writeObject(pd);
        }catch(Exception e){e.printStackTrace();}
    }

    public static void UpdateUser(Users user){
        PackageData pd=new PackageData();
        pd.setOperationType("Change");
        pd.setUser(user);
        pd.setLogin(login_);
        try {
            outputStream.writeObject(pd);
        }catch(Exception e){e.printStackTrace();}
    }

    public static Users getByLogin(String login){
        PackageData pd=new PackageData();
        pd.setOperationType("Get_by_login");
        pd.setLogin(login);
        try {
            outputStream.writeObject(pd);
            if((pd=(PackageData)inputStream.readObject()).getOperationType().equals("Get_by_login")){
                return pd.getUser();
            }
            else return null;
        }catch(Exception e){e.printStackTrace();
        return null;}
    }

    public static void main(String[] args){
        connectToServer();

        frame = new MainFrame();
        frame.setVisible(true);
    }
}
