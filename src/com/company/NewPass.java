package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewPass extends Container {
    private JLabel error;
    private JLabel old;
    private JPasswordField oldP;
    private JLabel newP;
    private JPasswordField newPa;
    private JLabel repeat;
    private JPasswordField repeatP;
    private JButton change;
    private JButton back;

    NewPass(){
        setSize(700, 700);
        setLayout(null);
        Font font=new Font(Font.DIALOG, Font.ITALIC, 14);

        error=new JLabel("");
        error.setFont(font);
        error.setBounds(250, 150, 200, 40);
        add(error);

        old=new JLabel("Old Password");
        old.setFont(font);
        old.setBounds(100,200,120,40);
        add(old);

        oldP=new JPasswordField();
        oldP.setEchoChar('*');
        oldP.setBounds(250, 200, 350, 40);
        add(oldP);

        newP=new JLabel("New password");
        newP.setFont(font);
        newP.setBounds(100, 250, 120, 40);
        add(newP);

        newPa=new JPasswordField();
        newPa.setEchoChar('*');
        newPa.setBounds(250, 250, 350, 40);
        add(newPa);

        repeat=new JLabel("Repeat password");
        repeat.setFont(font);
        repeat.setBounds(100, 300,120, 40 );
        add(repeat);

        repeatP=new JPasswordField();
        repeatP.setEchoChar('*');
        repeatP.setBounds(250, 300, 350, 40);
        add(repeatP);

        change=new JButton("Save Changes");
        change.setFont(font);
        change.setForeground(Color.red);
        change.setBounds(100, 350, 500, 50 );
        change.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
String OP=new String(oldP.getPassword());
String NP=new String(newPa.getPassword());
String RP=new String(repeatP.getPassword());
                boolean check = UserConnect.login(UserConnect.login_,OP);
                if(!check){
                    error.setText("Incorrect password");
                }
                if(!(NP.equals(RP))){
                    error.setText("Password mismatch");
                }
                else {
                  UserConnect.UpdateUser(new Users(UserConnect.login_,NP));
                }
            }
        });
        add(change);

        back=new JButton("Back");
        back.setFont(font);
        back.setForeground(Color.red);
        back.setBounds(100,410 , 500, 50 );
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserConnect.frame.newpass.setVisible(false);
                UserConnect.frame.setting.setVisible(true);
            }
        });
        add(back);
    }

}
