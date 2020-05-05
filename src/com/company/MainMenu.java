package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Set;

public class MainMenu extends Container {
    private JLabel login;
    private JTextField loginText;
    private JLabel password;
    private JPasswordField passwordText;
    private JButton enter;
    private JButton register;
    private JButton exit;

    public MainMenu(){
        setSize(700, 700);
        setLayout(null);
        Font font=new Font(Font.DIALOG, Font.ITALIC, 14);
        login=new JLabel("Login");
        login.setFont(font);
        login.setBounds(100,200,120,40);
        add(login);
        File file2=new File("welcome (2).jpg");
        JLabel imgLabel2=new JLabel(new ImageIcon(file2.getName()));
        imgLabel2.setBounds(100,0,500,180);
        add(imgLabel2);


        loginText=new JTextField();
        loginText.setBounds(230,200,250,40);
        add(loginText);

        password=new JLabel("Password");
        password.setFont(font);
        password.setBounds(100,250,120,40);
        add(password);

        passwordText=new JPasswordField();
        passwordText.setEchoChar('*');
        passwordText.setBounds(230,250,250,40);
        add(passwordText);


        enter=new JButton("Enter");
        enter.setFont(font);
        enter.setForeground(Color.red);
        enter.setBounds(100, 300,380, 40);
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean check = UserConnect.login(loginText.getText(), new String(passwordText.getPassword()));
                if (check) {
                    UserConnect.login_=loginText.getText();
                    UserConnect.newUser=UserConnect.getByLogin(loginText.getText());
                    UserConnect.frame.menu.setVisible(false);
                    UserConnect.frame.menu2.setVisible(true);
                   login.setText(UserConnect.getByLogin(loginText.getText()).toString());
                   loginText.setText("");
                   passwordText.setText("");
                }
            }
        });
        add(enter);

        register=new JButton("Register");
        register.setForeground(Color.red);
        register.setFont(font);
        register.setBounds(100, 350, 380, 40);
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
UserConnect.frame.menu.setVisible(false);
UserConnect.frame.registration.setVisible(true);
            }
        });
        add(register);

        exit=new JButton("Exit");
        exit.setForeground(Color.red);
        exit.setFont(font);
        exit.setBounds(100, 400, 380, 40);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(exit);
    }
}
