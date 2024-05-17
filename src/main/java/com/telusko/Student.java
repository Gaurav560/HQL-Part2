package com.telusko;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//POJO
@Entity
public class Student {

    @Id
    private int rollNo;
    private String sname;
    private int marks;


    //getters and setters

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public int getRollNo() {
        return rollNo;
    }

    @Override
    public String toString() {
        return "Student [rollNo=" + rollNo + ", sname=" + sname + ", marks=" + marks + "]";
    }


}