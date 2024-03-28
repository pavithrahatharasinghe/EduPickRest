package org.example.edupickrest.models;

import java.util.Date;

public class Enrollment {
    private int enrollmentID;
    private int userID;
    private int courseID;
    private Date enrollmentDate;
    private Date completionDate;
    private int completionStatus;

    //enrollmentID, userID, courseID, enrollmentDate, completionDate, completionStatus

    public Enrollment() {
    }

    public Enrollment(int enrollmentID, int userID, int courseID, Date enrollmentDate, Date completionDate, int completionStatus) {
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

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public Date getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }

    public int getCompletionStatus() {
        return completionStatus;
    }

    public void setCompletionStatus(int completionStatus) {
        this.completionStatus = completionStatus;
    }
}

//SQL to create the table for the Enrollment class
//CREATE TABLE Enrollment ( enrollmentID INT PRIMARY KEY, userID INT, courseID INT, enrollmentDate DATE, completionDate DATE, completionStatus INT, FOREIGN KEY (userID) REFERENCES User(userID), FOREIGN KEY (courseID) REFERENCES Course(courseID) );
