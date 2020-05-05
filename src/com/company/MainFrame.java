package com.company;

import javax.swing.*;

public class MainFrame extends JFrame  {
public UsersRegistration registration;
public MainMenu menu;
public Menu2 menu2;
public Movies movies;
public Cartoons cartoons;
public Serials serials;
public Songs songs;
public Setting setting;
public Courses courses;
public NewPass newpass;
public NewLogin newlogin;
public Delete delete;
    public MainFrame() {
        setTitle("WELCOME");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 700);
        setLayout(null);
        setLocationRelativeTo(null);

        menu=new MainMenu();
        menu.setLocation(0,0);
        menu.setVisible(true);
        add(menu);

        registration=new UsersRegistration();
        registration.setLocation(0, 0);
        registration.setVisible(false);
        add(registration);

        menu2=new Menu2();
        menu2.setLocation(0, 0);
        menu2.setVisible(false);
        add(menu2);

        movies=new Movies();
        movies.setLocation(0, 0);
        movies.setVisible(false);
        add(movies);

        cartoons=new Cartoons();
        cartoons.setLocation(0, 0);
        cartoons.setVisible(false);
        add(cartoons);

        serials=new Serials();
        serials.setLocation(0,0);
        serials.setVisible(false);
        add(serials);

        songs=new Songs();
        songs.setLocation(0, 0);
        songs.setVisible(false);
        add(songs);

        setting=new Setting();
        setting.setLocation(0, 0);
        setting.setVisible(false);
        add(setting);

        courses=new Courses();
        courses.setLocation(0, 0);
        courses.setVisible(false);
        add(courses);

        newpass=new NewPass();
        newpass.setLocation(0, 0);
        newpass.setVisible(false);
        add(newpass);

        newlogin=new NewLogin();
        newlogin.setLocation(0,0);
        newlogin.setVisible(false);
        add(newlogin);

        delete=new Delete();
        delete.setLocation(0,0);
        delete.setVisible(false);
        add(delete);

        repaint();
    }
}
