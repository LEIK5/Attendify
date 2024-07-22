package com.groupsix.attendify.ui;

/**
 *
 * @author User
 */
public class Student {
    private String studentNumber;
    private String lastName;

    public Student(String studentNumber, String lastName) {
        this.studentNumber = studentNumber;
        this.lastName = lastName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

