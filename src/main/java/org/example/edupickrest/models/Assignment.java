package org.example.edupickrest.models;

public class Assignment {

    //assignmentID - int , moduleID - int , courseID - int , assignmentName - varchar(255) , assignmentDescription - text , assignmentURL - varchar(255) , assignmentType - varchar(255) , assignmentStatus - varchar(255) , dueDateTime - datetime

    private int assignmentID;
    private int moduleID;
    private int courseID;
    private String assignmentName;
    private String assignmentDescription;
    private String assignmentURL;
    private String assignmentType;
    private String assignmentStatus;
    private String dueDateTime;

    public Assignment() {
    }

    public Assignment(int assignmentID, int moduleID, int courseID, String assignmentName, String assignmentDescription, String assignmentURL, String assignmentType, String assignmentStatus, String dueDateTime) {
        this.assignmentID = assignmentID;
        this.moduleID = moduleID;
        this.courseID = courseID;
        this.assignmentName = assignmentName;
        this.assignmentDescription = assignmentDescription;
        this.assignmentURL = assignmentURL;
        this.assignmentType = assignmentType;
        this.assignmentStatus = assignmentStatus;
        this.dueDateTime = dueDateTime;
    }

    public int getAssignmentID() {
        return assignmentID;
    }

    public void setAssignmentID(int assignmentID) {
        this.assignmentID = assignmentID;
    }

    public int getModuleID() {
        return moduleID;
    }

    public void setModuleID(int moduleID) {
        this.moduleID = moduleID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
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

    public String getAssignmentURL() {
        return assignmentURL;
    }

    public void setAssignmentURL(String assignmentURL) {
        this.assignmentURL = assignmentURL;
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

    public String getDueDateTime() {
        return dueDateTime;
    }

    public void setDueDateTime(String dueDateTime) {
        this.dueDateTime = dueDateTime;
    }
}
