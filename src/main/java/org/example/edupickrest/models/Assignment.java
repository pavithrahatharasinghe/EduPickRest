package org.example.edupickrest.models;

public class Assignment {

    //AssignmentID, AssignmentName, AssignmentDescription, AssignmentType, AssignmentStatus, AssignmentDueDate, AssignmentDueTime, AssignmentCourse, AssignmentModule, AssignmentFile
    private int assignmentID;
    private String assignmentName;
    private String assignmentDescription;
    private String assignmentType;
    private String assignmentStatus;
    private String assignmentDueDate;
    private String assignmentDueTime;
    private String assignmentCourse;
    private String assignmentModule;
    private String assignmentFile;

    public Assignment() {
    }

    public Assignment(int assignmentID, String assignmentName, String assignmentDescription, String assignmentType, String assignmentStatus, String assignmentDueDate, String assignmentDueTime, String assignmentCourse, String assignmentModule, String assignmentFile) {
        this.assignmentID = assignmentID;
        this.assignmentName = assignmentName;
        this.assignmentDescription = assignmentDescription;
        this.assignmentType = assignmentType;
        this.assignmentStatus = assignmentStatus;
        this.assignmentDueDate = assignmentDueDate;
        this.assignmentDueTime = assignmentDueTime;
        this.assignmentCourse = assignmentCourse;
        this.assignmentModule = assignmentModule;
        this.assignmentFile = assignmentFile;
    }

    public int getAssignmentID() {
        return assignmentID;
    }

    public void setAssignmentID(int assignmentID) {
        this.assignmentID = assignmentID;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    public String getAssignmentDescription() {
        return assignmentDescription;
    }

    public void setAssignmentDescription(String assignmentDescription) {
        this.assignmentDescription = assignmentDescription;
    }

    public String getAssignmentType() {
        return assignmentType;
    }

    public void setAssignmentType(String assignmentType) {
        this.assignmentType = assignmentType;
    }

    public String getAssignmentStatus() {
        return assignmentStatus;
    }

    public void setAssignmentStatus(String assignmentStatus) {
        this.assignmentStatus = assignmentStatus;
    }

    public String getAssignmentDueDate() {
        return assignmentDueDate;
    }

    public void setAssignmentDueDate(String assignmentDueDate) {
        this.assignmentDueDate = assignmentDueDate;
    }

    public String getAssignmentDueTime() {
        return assignmentDueTime;
    }

    public void setAssignmentDueTime(String assignmentDueTime) {
        this.assignmentDueTime = assignmentDueTime;
    }

    public String getAssignmentCourse() {
        return assignmentCourse;
    }

    public void setAssignmentCourse(String assignmentCourse) {
        this.assignmentCourse = assignmentCourse;
    }

    public String getAssignmentModule() {
        return assignmentModule;
    }

    public void setAssignmentModule(String assignmentModule) {
        this.assignmentModule = assignmentModule;
    }

    public String getAssignmentFile() {
        return assignmentFile;
    }

    public void setAssignmentFile(String assignmentFile) {
        this.assignmentFile = assignmentFile;
    }
}

// sql to create the table for the Assignment class
// CREATE TABLE Assignment ( assignmentID INT PRIMARY KEY, assignmentName VARCHAR(255), assignmentDescription VARCHAR(255), assignmentType VARCHAR(255), assignmentStatus VARCHAR(255), assignmentDueDate DATE, assignmentDueTime TIME, assignmentCourse VARCHAR(255), assignmentModule VARCHAR(255), assignmentFile VARCHAR(255) );
