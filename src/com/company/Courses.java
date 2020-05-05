package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Courses extends Container {
    private JLabel name;
    private JTextField name1;
    private JLabel surname;
    private JTextField surname1;
    private JLabel number;
    private JTextField numberText;
    private JLabel group;
    private JTextField groupText;
    private JTextArea cost;
    private JButton add;
    private JButton back1;

    public Courses(){
        setSize(700, 700);
        setLayout(null);
        Font font=new Font(Font.DIALOG, Font.ITALIC, 14);

        name=new JLabel("Name");
        name.setFont(font);
        name.setBounds(100, 100, 120,40);
        add(name);

        surname=new JLabel("Surname");
        surname.setFont(font);
        surname.setBounds(100,150 ,120, 40);
        add(surname);

        number=new JLabel("Phone Number");
        number.setFont(font);
        number.setBounds(100, 200, 120,40);
        add(number);

        group=new JLabel("Group");
        group.setFont(font);
        group.setBounds(100, 250, 120, 40);
        add(group);


        name1=new JTextField();
        name1.setBounds(230, 100, 230,40);
        add(name1);

        surname1=new JTextField();
        surname1.setBounds(230, 150, 230, 40);
        add(surname1);

        numberText=new JTextField();
        numberText.setBounds(230,200, 230, 40);
        add(numberText);

      groupText=new JTextField();
      groupText.setBounds(230, 250, 230, 40);
      add(groupText);


        cost=new JTextArea();
        cost.setText("For all courses the cost is similar: 36 000 per month. "+"\n" +"Lessons are held 3 times a week " +
                "\n"+"and last for one and a half hour.");
        cost.setBounds(100, 350, 380, 80);
        add(cost);

        add=new JButton("Add");
        add.setFont(font);
        add.setForeground(Color.red);
        add.setBounds(100, 440, 380, 40);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    CoursePartisipants partisipants = new CoursePartisipants( name1.getText(), surname1.getText(), numberText.getText(),groupText.getText());
                    UserConnect.addParticipants(partisipants);
                    name1.setText("");
                    surname1.setText("");
                    numberText.setText("");
                    groupText.setText("");
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        add(add);

        back1=new JButton("Back");
        back1.setFont(font);
        back1.setForeground(Color.red);
        back1.setBounds(100, 490, 380, 40);
        back1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserConnect.frame.courses.setVisible(false);
                UserConnect.frame.menu2.setVisible(true);
            }
        });
        add(back1);
    }
}
