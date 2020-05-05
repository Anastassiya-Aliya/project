package com.company;

import java.io.Serializable;

public class CoursePartisipants implements Serializable {
   /* private long id;
    private String name;
    private String surname;
    private String number;
    private String group;
    private String time;*/
   private String name;
   private String surname;
   private String number;
   private String groups;

    public CoursePartisipants() {
    }

    public CoursePartisipants( String name, String surname, String number, String groups) {

        this.name = name;
        this.surname = surname;
        this.number = number;
        this.groups = groups;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getGroups() {
        return groups;
    }

    public void setGroups(String groups) {
        this.groups = groups;
    }


    @Override
    public String toString() {
        return "CoursePartisipants{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", number='" + number + '\'' +
                ", group='" + groups + '\''+
                '}';
    }
}
