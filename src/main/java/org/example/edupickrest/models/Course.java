package org.example.edupickrest.models;

public class Course {private int courseID;
    private java.lang.String courseName;
    private java.lang.String courseDescription;
    private java.lang.String courseImage;
    private java.lang.String courseCategory;
    private java.lang.String courseLevel;
    private java.lang.String courseLanguage;
    private double coursePrice;
    private java.lang.String courseURL;
    private java.lang.String courseDuration;

    public Course() {
    }

    public Course(int courseID, String courseName, String courseDescription, String courseImage, String courseCategory, String courseLevel, String courseLanguage, double coursePrice, String courseURL, String courseDuration) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.courseImage = courseImage;
        this.courseCategory = courseCategory;
        this.courseLevel = courseLevel;
        this.courseLanguage = courseLanguage;
        this.coursePrice = coursePrice;
        this.courseURL = courseURL;
        this.courseDuration = courseDuration;
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

    public String getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(String courseDuration) {
        this.courseDuration = courseDuration;
    }
}


