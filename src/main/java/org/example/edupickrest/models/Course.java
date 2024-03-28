package org.example.edupickrest.models;

public class Course {
    private int courseID;
    private String courseName;
    private String courseDescription;
    private String courseImage;
    private String courseCategory;
    private String courseLevel;
    private String courseLanguage;
    private double coursePrice;
    private String courseURL;

    //Course class variables
    //CourseID, CourseName, CourseDescription, CourseImage, CourseCategory, CourseLevel, CourseLanguage, CoursePrice, CourseURL

    public Course(int courseID, String courseName, String courseDescription, String courseImage, String courseCategory, String courseLevel, String courseLanguage, double coursePrice, String courseURL) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.courseImage = courseImage;
        this.courseCategory = courseCategory;
        this.courseLevel = courseLevel;
        this.courseLanguage = courseLanguage;
        this.coursePrice = coursePrice;
        this.courseURL = courseURL;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public String getCourseImage() {
        return courseImage;
    }

    public void setCourseImage(String courseImage) {
        this.courseImage = courseImage;
    }

    public String getCourseCategory() {
        return courseCategory;
    }

    public void setCourseCategory(String courseCategory) {
        this.courseCategory = courseCategory;
    }

    public String getCourseLevel() {
        return courseLevel;
    }

    public void setCourseLevel(String courseLevel) {
        this.courseLevel = courseLevel;
    }

    public String getCourseLanguage() {
        return courseLanguage;
    }

    public void setCourseLanguage(String courseLanguage) {
        this.courseLanguage = courseLanguage;
    }

    public double getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(double coursePrice) {
        this.coursePrice = coursePrice;
    }

    public String getCourseURL() {
        return courseURL;
    }

    public void setCourseURL(String courseURL) {
        this.courseURL = courseURL;
    }
}


// sql to create the table for the Course class
// CREATE TABLE Course ( courseID INT PRIMARY KEY, courseName VARCHAR(255), courseDescription VARCHAR(255), courseImage VARCHAR(255), courseCategory VARCHAR(255), courseLevel VARCHAR(255), courseLanguage VARCHAR(255), coursePrice DOUBLE, courseURL VARCHAR(255) );