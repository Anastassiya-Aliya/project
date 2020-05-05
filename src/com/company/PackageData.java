package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class PackageData implements Serializable {
    String operationType;
    ArrayList<Users> users;
    Users user;
    ArrayList<CoursePartisipants> partisipants;
    CoursePartisipants partisipant;
    ArrayList<Object> box;
    String login;

    public PackageData() {
    }

    public PackageData(String operationType, ArrayList<Users> users, Users user,  ArrayList<CoursePartisipants> partisipants, CoursePartisipants partisipant, String login) {
        this.operationType = operationType;
        this.users = users;
        this.user = user;
        this.partisipants=partisipants;
        this.partisipant=partisipant;
        this.login=login;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public Users getUsers() {
        return user;
    }

    public void setUsers(ArrayList<Users> users) {
        this.users = users;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public ArrayList<CoursePartisipants> getPartisipants() {
        return partisipants;
    }

    public void setPartisipants(ArrayList<CoursePartisipants> partisipants) {
        this.partisipants = partisipants;
    }

    public CoursePartisipants getPartisipant() {
        return partisipant;
    }

    public void setPartisipant(CoursePartisipants partisipant) {
        this.partisipant = partisipant;
    }

    public ArrayList<Object> getBox() {
        return box;
    }

    public void setBox(ArrayList<Object> box) {
        this.box = box;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "PackageData{" +
                "operationType='" + operationType + '\'' +
                ", users=" + users +
                ", user=" + user +
                ", partisipants=" + partisipants +
                ", partisipant=" + partisipant +
                ", box=" + box + login+
                '}';
    }
}
