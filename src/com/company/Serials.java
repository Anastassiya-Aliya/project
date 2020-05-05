package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Serials extends Container {
    private JLabel choice;
    private JComboBox serials;
    private JButton search;
    private JTextArea info;
    private JButton back;
    private ArrayList<Object> temp= UserConnect.getSerials();
    public Serials() {
        setSize(700, 700);
        setLayout(null);
        Font font=new Font(Font.DIALOG, Font.ITALIC, 14);
        choice = new JLabel("Choose:");
        choice.setFont(font);
        choice.setBounds(100, 100, 100, 40);
        add(choice);

        serials = new JComboBox(((ArrayList<String>)temp.get(0)).toArray());
        serials.setBounds(220, 100, 280, 40);
        serials.addActionListener((e)->{
            int a=serials.getSelectedIndex();
            info.setText(((ArrayList<String>)temp.get(1)).get(a));
        });
        add(serials);

        info = new JTextArea();
        info.setBounds(100, 160, 500, 380);
        add(info);

        back = new JButton("Back");
        back.setFont(font);
        back.setForeground(Color.red);
        back.setBounds(300, 560, 100, 40);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserConnect.frame.menu2.setVisible(true);
                UserConnect.frame.serials.setVisible(false);
            }
        });
        add(back);
    }
}
