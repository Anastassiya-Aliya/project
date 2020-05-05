package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Delete extends Container {
private JButton delete;
private JButton back;


public Delete(){
    setSize(700, 700);
    setLayout(null);
    Font font=new Font(Font.DIALOG, Font.ITALIC, 16);


    delete=new JButton("Delete Account");
    delete.setFont(font);
    delete.setForeground(Color.red);
    delete.setBounds(100, 325, 500, 50);
    delete.addActionListener(e -> {

        try{


            UserConnect.deleteWithLogin(UserConnect.login_);

        }catch(Exception ex){
            ex.printStackTrace();
        }
        UserConnect.frame.delete.setVisible(false);
        UserConnect.frame.menu.setVisible(true);
    });
    add(delete);

    back=new JButton("Back");
    delete.setFont(font);
    delete.setForeground(Color.red);
    back.setBounds(100, 385, 500, 50);
    back.addActionListener(e -> {
        UserConnect.frame.delete.setVisible(false);
        UserConnect.frame.menu2.setVisible(true);
    });
}
}
