package model;

import java.io.Serializable;

public class Student implements Serializable {
    private String msv;
    private String name;
    private int age;
    private String gender;
    private String address;
    private double score;

    public Student() {
    }

    public Student(String msv, String name, int age, String gender, String address, double score) {
        this.msv = msv;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.score = score;
    }

    public String getMsv() {
        return msv;
    }

    public void setMsv(String msv) {
        this.msv = msv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        String toString = String.format("%-10s%-20s%-10d%-15s%-25s%-6.2f",msv,name,age,gender,address,score);
        return toString;
    }
}
