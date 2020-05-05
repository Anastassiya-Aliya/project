package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Menu2 extends JPanel {
    private JButton movies;
    private JButton cartoons;
    private JButton serials;
    private JButton songs;
    private JButton settings;
    private JButton courses;
    private JButton back;

    public Menu2(){
        setSize(700, 700);
        setLayout(null);
        Font font=new Font(Font.DIALOG, Font.ITALIC, 14);
       //// this.setBackground(Color.blue);
        File file=new File("movie.jpg");
        JLabel imgLabel=new JLabel(new ImageIcon(file.getName()));
        imgLabel.setBounds(100,100,100,100);
        add(imgLabel);

        File file1=new File("cartoons.jpg");
        JLabel imgLabel1=new JLabel(new ImageIcon(file1.getName()));
        imgLabel1.setBounds(300,100,100,100);
        add(imgLabel1);

        File file3=new File("serials (1).jpg");
        JLabel imgLabel3=new JLabel(new ImageIcon(file3.getName()));
        imgLabel3.setBounds(500,100,100,100);
        add(imgLabel3);

        File file4=new File("songs.jpg");
        JLabel imgLabel4=new JLabel(new ImageIcon(file4.getName()));
        imgLabel4.setBounds(100,400,100,100);
        add(imgLabel4);

        File file5=new File("settings.jpg");
        JLabel imgLabel5=new JLabel(new ImageIcon(file5.getName()));
        imgLabel5.setBounds(300,400,100,100);
        add(imgLabel5);

        File file6=new File("courses (2).jpg");
        JLabel imgLabel6=new JLabel(new ImageIcon(file6.getName()));
        imgLabel6.setBounds(500,400,100,100);
        add(imgLabel6);


        movies=new JButton("Movies");
        movies.setFont(font);
        movies.setForeground(Color.red);
        movies.setBounds(100, 250, 100, 50 );
        movies.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserConnect.frame.menu2.setVisible(false);
                UserConnect.frame.movies.setVisible(true);
            }
        });
        add(movies);

        cartoons=new JButton("Cartoons");
        cartoons.setFont(font);
        cartoons.setForeground(Color.red);
        cartoons.setBounds(300, 250, 100, 50);
        cartoons.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserConnect.frame.menu2.setVisible(false);
                UserConnect.frame.cartoons.setVisible(true);
            }
        });
        add(cartoons);

        serials=new JButton("Serials");
        serials.setFont(font);
        serials.setForeground(Color.red);
        serials.setBounds(500, 250, 100, 50);
        serials.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserConnect.frame.menu2.setVisible(false);
                UserConnect.frame.serials.setVisible(true);
            }
        });
        add(serials);

        songs=new JButton("Songs");
        songs.setForeground(Color.red);
        songs.setFont(font);
        songs.setBounds(100, 550 ,100, 50);
        songs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
UserConnect.frame.menu2.setVisible(false);
UserConnect.frame.songs.setVisible(true);
            }
        });
        add(songs);

        settings=new JButton("Settings");
        settings.setForeground(Color.red);
        settings.setFont(font);
        settings.setBounds(300, 550, 100, 50);
        settings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserConnect.frame.menu2.setVisible(false);
                UserConnect.frame.setting.setVisible(true);
            }
        });
        add(settings);

        courses=new JButton("Online Courses");
        courses.setForeground(Color.red);
        courses.setFont(font);
        courses.setBounds(500, 550, 100, 50);
        courses.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
UserConnect.frame.menu2.setVisible(false);
UserConnect.frame.courses.setVisible(true);
            }
        });
        add(courses);

        back=new JButton("Back");
        back.setForeground(Color.red);
        back.setFont(font);
        back.setBounds(50, 40, 100, 40);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserConnect.frame.menu2.setVisible(false);
                UserConnect.frame.menu.setVisible(true);
            }
        });
        add(back);
    }
}
