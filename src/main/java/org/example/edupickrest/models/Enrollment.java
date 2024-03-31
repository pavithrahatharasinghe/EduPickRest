package org.example.edupickrest.models;

import java.util.Date;

public class Enrollment {
   //-- enrollmentID - int - primary key, userID - int - foreign key, courseID - int - foreign key, enrollmentDate - date, completionDate - date, completionStatus - int

    private int enrollmentID;
    private int userID;
    private int courseID;
    private String enrollmentDate;
    private String completionDate;
    private int completionStatus;

    public Enrollment() {
    }

    public Enrollment(int enrollmentID, int userID, int courseID, String enrollmentDate, String completionDate, int completionStatus) {
        this.enrollmentID = enrollmentID;
        this.userID = userID;
        this.courseID = courseID;
        this.enrollmentDate = enrollmentDate;
        this.completionDate = completionDate;
        this.completionStatus = completionStatus;
    }

    public int getEnrollmentID() {
        return enrollmentID;
    }

    public void setEnrollmentID(int enrollmentID) {
        this.enrollmentID = enrollmentID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(String enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public String getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(String completionDate) {
        this.completionDate = completionDate;
    }

    public int getCompletionStatus() {
        return completionStatus;
    }

    public void setCompletionStatus(int completionStatus) {
        this.completionStatus = completionStatus;
    }
}

