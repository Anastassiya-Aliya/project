package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Movies extends Container {
    private JLabel choice;
    private JComboBox films;
    private JButton search;
    private JTextArea info;
    private JButton back;
    private ArrayList<Object> temp= UserConnect.getMovies();
    public  Movies() {
    setSize(700, 700);
    setLayout(null);
    Font font=new Font(Font.DIALOG, Font.ITALIC, 14);

    choice=new JLabel("Choose:");
    choice.setFont(font);
    choice.setBounds(100, 100, 100, 40);
    add(choice);

    films=new JComboBox(((ArrayList<String>)temp.get(0)).toArray());
    films.setBounds(220, 100, 280, 40);
    films.addActionListener((e)->{
        int a=films.getSelectedIndex();
        info.setText(((ArrayList<String>)temp.get(1)).get(a));
    });
    add(films);


    info=new JTextArea();
    info.setLineWrap(true);
    info.setEditable(false);
    info.setBounds(100, 160,500 , 380);
    add(info);

    back=new JButton("Back");
    back.setFont(font);
    back.setForeground(Color.red);
    back.setBounds(300,560 , 100, 40 );
    back.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            UserConnect.frame.menu2.setVisible(true);
            UserConnect.frame.movies.setVisible(false);
        }
    });
    add(back);
}
}
