package org.example.edupickrest.models;

import java.util.Date;

public class Exam {
    private int examID;
    private int courseID;
    private String examName;
    private Date examDate;
    private String examType;
    private String examURL;

    // Exam Variables with types
    // examID - int, courseID - int, examName - String, examDate - Date, examType - String, examURL - String

    public Exam() {
    }

    public Exam(int examID, int courseID, String examName, Date examDate, String examType, String examURL) {
        this.examID = examID;
        this.courseID = courseID;
        this.examName = examName;
        this.examDate = examDate;
        this.examType = examType;
        this.examURL = examURL;
    }

    public int getExamID() {
        return examID;
    }

    public void setExamID(int examID) {
        this.examID = examID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    public String getExamType() {
        return examType;
    }

    public void setExamType(String examType) {
        this.examType = examType;
    }

    public String getExamURL() {
        return examURL;
    }

    public void setExamURL(String examURL) {
        this.examURL = examURL;
    }
}
////SQL to create the table for the Exam class

// CREATE TABLE Exam ( examID INT PRIMARY KEY, courseID INT, examName VARCHAR(255), examDate DATE, examType VARCHAR(255), examURL VARCHAR(255), FOREIGN KEY (courseID) REFERENCES Course(courseID) );