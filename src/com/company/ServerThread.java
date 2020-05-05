package com.company;
import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.ArrayList;

public class ServerThread extends Thread {
    private Connection connection;
    private Socket socket;
    ObjectInputStream inputStream;
    ObjectOutputStream outputStream;

    public ServerThread(Socket socket, Connection connection) {
        this.socket = socket;
        this.connection = connection;
        try {
            inputStream = new ObjectInputStream(this.socket.getInputStream());
            outputStream = new ObjectOutputStream(this.socket.getOutputStream());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void run() {
        try {
            PackageData pd = null;
            while ((pd = (PackageData) inputStream.readObject()) != null) {

                if (pd.getOperationType().equals("Register")) {
                    try {
                        Users users = pd.getUser();//s
                        addUsersToDb(users);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (pd.getOperationType().equals("Add")) {
                    try {
                        CoursePartisipants partisipants = pd.getPartisipant();
                        addParticipantsToDb(partisipants);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (pd.getOperationType().equals("Enter")){
                    try{
                        Users temp=pd.getUsers();
                        boolean check=checkUser(temp.getLogin(), temp.getPassword());
                        if(check)
                            pd.setOperationType("y");
                        outputStream.writeObject(pd);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
              if(pd.getOperationType().equals("Movies")){
                  try{
                          BufferedReader read= new BufferedReader(new FileReader("movie.txt"));
                          String temp="";
                          ArrayList<String> strings=new ArrayList<>();
                          ArrayList<String> title=new ArrayList<>();
                          int counter=-1;
                          while((temp=read.readLine())!=null){
                              if(temp.indexOf(')')!=-1)
                              {
                                  title.add(temp);
                                  counter++;
                                  strings.add("");
                              }
                              else if(counter!=-1) {
                                  strings.set(counter, (strings.get(counter)+temp));
                              }
                              }
                        ArrayList<Object> sent=new ArrayList<>();
                          sent.add(title);
                          sent.add(strings);
                          pd =new PackageData();
                          pd.setBox(sent);
                          pd.setOperationType("Movies");
                          outputStream.writeObject(pd);
                      }catch (Exception e){
                      e.printStackTrace();
                  }
              }
                if(pd.getOperationType().equals("Cartoons")) {
                    try {
                        BufferedReader read = new BufferedReader(new FileReader("cartoons.txt"));
                        String temp = "";
                        ArrayList<String> strings = new ArrayList<>();
                        ArrayList<String> title = new ArrayList<>();
                        int counter = -1;
                        while ((temp = read.readLine()) != null) {
                            if (temp.indexOf(')') != -1) {
                                title.add(temp);
                                counter++;
                                strings.add("");
                            } else if (counter != -1) {
                                strings.set(counter, (strings.get(counter) + temp));
                            }
                        }
                        ArrayList<Object> sent = new ArrayList<>();
                        sent.add(title);
                        sent.add(strings);
                        pd = new PackageData();
                        pd.setBox(sent);
                        pd.setOperationType("Cartoons");
                        outputStream.writeObject(pd);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } if(pd.getOperationType().equals("Serials")) {
                    try {
                        BufferedReader read = new BufferedReader(new FileReader("serials.txt"));
                        String temp = "";
                        ArrayList<String> strings = new ArrayList<>();
                        ArrayList<String> title = new ArrayList<>();
                        int counter = -1;
                        while ((temp = read.readLine()) != null) {
                            if (temp.indexOf(')') != -1) {
                                title.add(temp);
                                counter++;
                                strings.add("");
                            } else if (counter != -1) {
                                strings.set(counter, (strings.get(counter) + temp));
                            }
                        }
                        ArrayList<Object> sent = new ArrayList<>();
                        sent.add(title);
                        sent.add(strings);
                        pd = new PackageData();
                        pd.setBox(sent);
                        pd.setOperationType("Serials");
                        outputStream.writeObject(pd);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if(pd.getOperationType().equals("Songs")) {
                    try {
                        BufferedReader read = new BufferedReader(new FileReader("songs.txt"));
                        String temp = "";
                        ArrayList<String> strings = new ArrayList<>();
                        ArrayList<String> title = new ArrayList<>();
                        int counter = -1;
                        while ((temp = read.readLine()) != null) {
                            if (temp.indexOf(')') != -1) {
                                title.add(temp);
                                counter++;
                                strings.add("");
                            } else if (counter != -1) {
                                strings.set(counter, (strings.get(counter) + temp));
                            }
                        }
                        ArrayList<Object> sent = new ArrayList<>();
                        sent.add(title);
                        sent.add(strings);
                        pd = new PackageData();
                        pd.setBox(sent);
                        pd.setOperationType("Songs");
                        outputStream.writeObject(pd);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if(pd.getOperationType().equals("Delete_Account")){
                    String login=pd.getLogin();
                    deleteUsersToDB(login);
                }
                if(pd.getOperationType().equals("Change")){
                 ChangeUser(pd.getUser(), pd.getLogin());
                }
                if(pd.getOperationType().equals("Get_by_login")){
                    Users temp=GetByLog(pd.getLogin());
                    pd.setUser(temp);
                    try{
                        outputStream.writeObject(pd);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addUsersToDb(Users user) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into user(name, surname, login, password) values(?,?,?,?)");

            ps.setString(1, user.getName());
            ps.setString(2, user.getSurname());
            ps.setString(3, user.getLogin());
            ps.setString(4, user.getPassword());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addParticipantsToDb(CoursePartisipants partisipant) {
        try {
           PreparedStatement ps= connection.prepareStatement("insert into courses_registration(name, surname, number, groups)"+ "values(?, ?, ?, ?)");

           ps.setString(1, partisipant.getName());
           ps.setString(2, partisipant.getSurname());
           ps.setString(3, partisipant.getNumber());
           ps.setString(4, partisipant.getGroups());

           ps.executeUpdate();
           ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        public ArrayList<Users> getUsers() {
            ArrayList<Users> users = new ArrayList<Users>();
            try {
                Statement st = connection.createStatement();
                String sql = "SELECT * FROM registration.user";
                ResultSet res = st.executeQuery(sql);
                while (res.next()) {
                    users.add(new Users(res.getString("name"), res.getString("surname"),res.getString("login"), res.getString("password")));

                }
                st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return users;
        }
        public boolean checkUser(String login, String password){
        ArrayList<Users> users=getUsers();
        boolean check=false;
        for(Users temp:users){
            if(temp.getLogin().equals(login) && temp.getPassword().equals(password))
                check=true;
        }
        return check;
        }

    public void deleteUsersToDB(String login){
        try{
            PreparedStatement ps=connection.prepareStatement("DELETE FROM user WHERE login=?");
            ps.setString(1,login);
            int rows= ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void ChangeUser(Users user, String log){
        try{
            PreparedStatement ps=connection.prepareStatement("UPDATE user SET login = ?, password = ? WHERE login=?;");
            ps.setString(1,user.getLogin());
            ps.setString(2, user.getPassword());
            ps.setString(3, log);
            int rows= ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public Users GetByLog(String login){
        ArrayList<Users> user=getUsers();
        Users temp=null;
        for(Users u:user)
        {
            if(u.getLogin().equals(login)){
                temp=u;
            }
        }
        return temp;
    }
    }
