package org.example.edupickrest.models;

public class Results {

    public int resultId;
    public int userID;
    public int assignmentID;
    public int marks;
    public String resultDate;

    public Results() {
    }

    public Results(int resultId, int userId, int assignmentId, int marks, String resultDate) {
        this.resultId = resultId;
        this.userID = userId;
        this.assignmentID = assignmentId;
        this.marks = marks;
        this.resultDate = resultDate;
    }

    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }

    public int getUserId() {
        return userID;
    }

    public void setUserId(int userId) {
        this.userID = userId;
    }

    public int getAssignmentId() {
        return assignmentID;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentID = assignmentId;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getResultDate() {
        return resultDate;
    }

    public void setResultDate(String resultDate) {
        this.resultDate = resultDate;
    }
}
