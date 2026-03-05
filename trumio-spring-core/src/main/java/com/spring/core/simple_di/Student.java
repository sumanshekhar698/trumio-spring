package com.spring.core.simple_di;

// By Default, SPring follows Singleton Scope for the beans,
// thus only one instance of the bean will be created and shared across the application

public class Student {
    private int studentId;
    private String studentName;
    private String studentAddress;


//    By Default, Spring uses Setter Injection
//    to inject the values initialize the value instead of doing through parametrized constructors
    public void setStudentId(int studentId) {
        System.out.println("setting studentId");
        this.studentId = studentId;
    }

    public void setStudentName(String studentName) {
        System.out.println("setting studentName");
        this.studentName = studentName;
    }

    public void setStudentAddress(String studentAddress) {
        System.out.println("setting studentAddress");
        this.studentAddress = studentAddress;
    }


    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }


    public String getStudentAddress() {
        return studentAddress;
    }


    public Student() {
        super();
        System.out.println("Student parameterless constructor called");

    }

    public Student(int studentId, String studentName, String studentAddress) {
        super();
        System.out.println("Student parameterized constructor called");
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentAddress = studentAddress;
    }

    @Override
    public String toString() {
        return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentAddress=" + studentAddress
                + "]";
    }


}
