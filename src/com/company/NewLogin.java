package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewLogin extends Container {
    private JLabel old;
    private JTextField oldL;
    private JLabel newL;
    private JTextField newLo;
    private JLabel repeat;
    private JTextField repeatL;
    private JButton change;
    private JButton back;

    public NewLogin(){
        setSize(700, 700);
        setLayout(null);
        Font font=new Font(Font.DIALOG, Font.ITALIC, 14);

        old=new JLabel("Old Username");
        old.setFont(font);
        old.setBounds(100,200,120,40);
        add(old);

        oldL=new JTextField();
        oldL.setBounds(250, 200, 350, 40);
        add(oldL);

        newL=new JLabel("New Username");
        newL.setFont(font);
        newL.setBounds(100, 250, 120, 40);
        add(newL);

        newLo=new JTextField();
        newLo.setBounds(250, 250, 350, 40);
        add(newLo);


        change=new JButton("Save Changes");
        change.setFont(font);
        change.setForeground(Color.red);
        change.setBounds(100, 350, 500, 50 );
        change.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
         Users temp=UserConnect.newUser;
         temp.setLogin(newLo.getText());
         UserConnect.UpdateUser(temp);
         UserConnect.login_=newLo.getText();
         UserConnect.newUser=UserConnect.getByLogin(UserConnect.login_);
         newLo.setText("");
         oldL.setText("");
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
                UserConnect.frame.newlogin.setVisible(false);
                UserConnect.frame.setting.setVisible(true);
            }
        });
        add(back);
    }

}
