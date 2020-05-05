package com.company;

import javax.jws.soap.SOAPBinding;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Setting extends Container {
    private JButton newPass;
    private JButton newLogin;
    private JButton delete;
    private JButton back;

    public Setting(){
        setSize(700, 700);
        setLayout(null);
        Font font=new Font(Font.DIALOG, Font.ITALIC, 14);

        newPass=new JButton("Change password");
        newPass.setFont(font);
        newPass.setForeground(Color.red);
        newPass.setBounds(200, 255, 300, 40);
        newPass.addActionListener(e -> {
            UserConnect.frame.newpass.setVisible(true);
            UserConnect.frame.setting.setVisible(false);
        });
        add(newPass);

        newLogin=new JButton("Change username");
        newLogin.setFont(font);
        newLogin.setForeground(Color.red);
        newLogin.setBounds(200, 305, 300, 40);
        newLogin.addActionListener(e -> {
            UserConnect.frame.newlogin.setVisible(true);
            UserConnect.frame.setting.setVisible(false);
        });
        add(newLogin);

        delete=new JButton("Delete account");
        delete.setFont(font);
        delete.setForeground(Color.red);
        delete.setBounds(200, 355, 300, 40);
        delete.addActionListener(e -> {
            UserConnect.frame.delete.setVisible(true);
            UserConnect.frame.setting.setVisible(false);
        });
        add(delete);

        back=new JButton("Back");
        back.setFont(font);
        back.setForeground(Color.red);
        back.setBounds(200, 355, 300, 40);
        back.addActionListener(e -> {
            UserConnect.frame.menu2.setVisible(true);
            UserConnect.frame.setting.setVisible(false);
        });
        add(back);
    }
}
