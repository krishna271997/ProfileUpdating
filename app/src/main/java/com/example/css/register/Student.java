package com.example.css.register;

import io.realm.RealmObject;

public class Student extends RealmObject {

    private int roll_no;
    private String name;
    private int tamil;
    private int english;
    private int maths;
    private int science;
    private int social;


    public int getRoll_no() {
        return roll_no;
    }

    public String getName() {
        return name;
    }

    public int getTamil() {
        return tamil;
    }

    public int getEnglish() {
        return english;
    }

    public int getMaths() {
        return maths;
    }

    public int getScience() {
        return science;
    }

    public int getSocial() {
        return social;
    }

    public void setRoll_no(int roll_no) {
        this.roll_no = roll_no;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTamil(int tamil) {
        this.tamil = tamil;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public void setMaths(int maths) {
        this.maths = maths;
    }

    public void setScience(int science) {
        this.science = science;
    }

    public void setSocial(int social) {
        this.social = social;
    }






}
