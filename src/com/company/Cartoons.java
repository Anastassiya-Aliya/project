package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Cartoons extends Container {
    private JLabel choice;
    private JComboBox cartoons;
    private JButton search;
    private JTextArea info;
    private JButton back;
    private ArrayList<Object> temp= UserConnect.getCartoons();

    public Cartoons() {
        setSize(700, 700);
        setLayout(null);
        Font font=new Font(Font.DIALOG, Font.ITALIC, 14);
        choice = new JLabel("Choose:");
        choice.setFont(font);
        choice.setBounds(100, 100, 100, 40);
        add(choice);

        cartoons = new JComboBox(((ArrayList<String>)temp.get(0)).toArray());
        cartoons.setBounds(220, 100, 280, 40);
        cartoons.addActionListener((e)->{
            int a=cartoons.getSelectedIndex();
            info.setText(((ArrayList<String>)temp.get(1)).get(a));
        });
        add(cartoons);

        info = new JTextArea();
        info.setBounds(100, 160, 500, 380);
        info.setEditable(false);
        info.setLineWrap(true);
        add(info);

        back = new JButton("Back");
        back.setFont(font);
        back.setForeground(Color.red);
        back.setBounds(300, 560, 100, 40);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserConnect.frame.menu2.setVisible(true);
                UserConnect.frame.cartoons.setVisible(false);
            }
        });
        add(back);
    }
}