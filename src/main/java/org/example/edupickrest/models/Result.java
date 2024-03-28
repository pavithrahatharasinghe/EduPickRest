package org.example.edupickrest.models;

public class Result {
    private int resultID;
    private int userID;
    private int courseID;
    private double marks;
    private String resultDate;

    public Result(int resultID, int userID, int courseID, double marks, String resultDate) {
        this.resultID = resultID;
        this.userID = userID;
        this.courseID = courseID;
        this.marks = marks;
        this.resultDate = resultDate;
    }

    public int getResultID() {
        return resultID;
    }

    public void setResultID(int resultID) {
        this.resultID = resultID;
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

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public String getResultDate() {
        return resultDate;
    }

    public void setResultDate(String resultDate) {
        this.resultDate = resultDate;
    }
}

////SQL to create the table for the Result class

//CREATE TABLE Result ( resultID INT PRIMARY KEY, userID INT, courseID INT, marks DOUBLE, resultDate DATE, FOREIGN KEY (userID) REFERENCES User(userID), FOREIGN KEY (courseID) REFERENCES Course(courseID) );