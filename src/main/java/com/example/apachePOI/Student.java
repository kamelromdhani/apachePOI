package com.example.apachePOI;

public class Student {
    private int rollNo;
    private String firstName;
    private String lastName;
    private String subject;

    public Student(int rollNo, String firstName, String lastName, String subject) {
        this.rollNo = rollNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
