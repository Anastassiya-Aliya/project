package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class UsersRegistration extends Container {
    private JLabel labelName;
    private JTextField textName;
    private JLabel labelSurname;
    private JTextField textSurname;
    private JLabel login;
    private JTextField textLogin;
    private JLabel labelPassword;
    private JPasswordField textPassword;
    private JButton save;
    private JButton back;
    public UsersRegistration() {
        setLayout(null);
        setSize(700, 700);
Font font=new Font(Font.DIALOG, Font.ITALIC, 14);
        labelName=new JLabel("Name:");
        labelName.setFont(font);
        labelName.setBounds(100,200,120,40);
        add(labelName);

        textName=new JTextField();
        textName.setBounds(230,200,250,40);
        add(textName);

        labelSurname=new JLabel("Surname:");
        labelSurname.setFont(font);
        labelSurname.setBounds(100,250,120,40);
        add(labelSurname);

        textSurname=new JTextField();
        textSurname.setBounds(230,250,250,40);
        add(textSurname);

        login=new JLabel("Login");
        login.setFont(font);
        login.setBounds(100,300,120,40);
        add(login);

        textLogin=new JTextField();
        textLogin.setBounds(230,300,250,40);
        add(textLogin);

        labelPassword=new JLabel("PasswordNumber");
        labelPassword.setFont(font);
        labelPassword.setBackground(Color.white);
        labelPassword.setBounds(100,350,120,40);
        add(labelPassword);

        textPassword=new JPasswordField();
        textPassword.setEchoChar('*');
        textPassword.setBounds(230,350,250,40);
        add(textPassword);


       save=new JButton("Save");
       save.setFont(font);
        save.setForeground(Color.red);
       save.setBounds(100, 400, 380, 40);
       save.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               try {
                   Users users = new Users(textName.getText(), textSurname.getText(), textLogin.getText(), new String(textPassword.getPassword()));
                   UserConnect.addUsers(users);
                   textName.setText("");
                   textSurname.setText("");
                   textLogin.setText("");
                   textPassword.setText("");
               }catch(Exception ex){
                   ex.printStackTrace();
               }
           }
       });
add(save);

back=new JButton("Back");
back.setFont(font);
back.setForeground(Color.red);
back.setBounds(100, 450, 380, 40);
back.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        UserConnect.frame.registration.setVisible(false);
        UserConnect.frame.menu.setVisible(true);
    }
});
    add(back);
    }
}