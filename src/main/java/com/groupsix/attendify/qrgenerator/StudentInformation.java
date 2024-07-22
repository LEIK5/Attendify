package com.groupsix.attendify.qrgenerator;

public class StudentInformation {
    
    private final String studentNumber;
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String section;
    private final String attendanceStatus;

    public StudentInformation(String studentNumber, String firstName, String middleName, String lastName, String section) {
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.section = section;
        this.attendanceStatus = null;
    }
    
    public StudentInformation(String studentNumber, String firstName, String middleName, String lastName, String section, String attendanceStatus) {
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.section = section;
        this.attendanceStatus = attendanceStatus;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public String getSection() {
        return section;
    }

    public String getAttendanceStatus() {
        return attendanceStatus;
    }
    

    public String getFullName() {
        return firstName + " " + middleName + " " + lastName;
    }
}
