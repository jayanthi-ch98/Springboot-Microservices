package com.example.springboot_rest_api.Beans;

public class Student {

    private int rollno;
    private String studentName;
    private String StudentClass;

    public Student(int rollno, String studentName, String studentClass) {
        this.rollno = rollno;
        this.studentName = studentName;
        StudentClass = studentClass;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentClass() {
        return StudentClass;
    }

    public void setStudentClass(String studentClass) {
        StudentClass = studentClass;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollno=" + rollno +
                ", studentName='" + studentName + '\'' +
                ", StudentClass='" + StudentClass + '\'' +
                '}';
    }
}
