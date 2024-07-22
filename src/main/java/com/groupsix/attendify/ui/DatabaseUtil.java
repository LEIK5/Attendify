package com.groupsix.attendify.ui;

import com.groupsix.attendify.qrgenerator.StudentInformation;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseUtil {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/attendify";
    private static final String JDBC_USER = "safdar";
    private static final String JDBC_PASSWORD = "123456";

    public static List<Student> getStudents() { // Changed the return type to List<Student>
        List<Student> students = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            Statement statement = connection.createStatement();
            String query = "SELECT studentNumber, lastName FROM students";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String studentId = resultSet.getString("studentNumber");
                String lastName = resultSet.getString("lastName");
                Student student = new Student(studentId, lastName);
                students.add(student);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }
    
    public static int updateAttendanceStatus(String studentNumber) {
        int count = 0;
        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            String query = "UPDATE students SET attendanceStatus = ? WHERE studentNumber = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setObject(1, "Present");
            statement.setObject(2, studentNumber);
            statement.execute();
            count = statement.getUpdateCount();
            System.out.println("Update Successful");

            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
    private static String escapeStudentNumber(String studentNumber){
        return studentNumber.replace("-", "\\-");
    }
    public static StudentInformation getStudentInformation(String studentNumber) {
        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            String query = "SELECT * FROM students WHERE studentNumber = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setObject(1, studentNumber);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String studentId = resultSet.getString("studentNumber");
                String firstName = resultSet.getString("firstName");
                String middleName = resultSet.getString("middleName");
                String lastName = resultSet.getString("lastName");
                String section = resultSet.getString("section");
                String attendanceStatus = resultSet.getString("attendanceStatus");
                System.out.println("Get Successful");
                return new StudentInformation(studentId, firstName, middleName, lastName, section, attendanceStatus);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
