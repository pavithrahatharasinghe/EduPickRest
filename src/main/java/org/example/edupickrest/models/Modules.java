package org.example.edupickrest.models;

public class Modules {

    private int moduleID;
    private int courseID;
    private String moduleName;
    private String moduleDescription;
    private String moduleURL;
    private String moduleStatus;

    public Modules() {
    }

    public Modules(int moduleID, int courseID, String moduleName, String moduleDescription, String moduleURL, String moduleStatus) {
        this.moduleID = moduleID;
        this.courseID = courseID;
        this.moduleName = moduleName;
        this.moduleDescription = moduleDescription;
        this.moduleURL = moduleURL;
        this.moduleStatus = moduleStatus;
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

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleDescription() {
        return moduleDescription;
    }

    public void setModuleDescription(String moduleDescription) {
        this.moduleDescription = moduleDescription;
    }

    public String getModuleURL() {
        return moduleURL;
    }

    public void setModuleURL(String moduleURL) {
        this.moduleURL = moduleURL;
    }

    public String getModuleStatus() {
        return moduleStatus;
    }

    public void setModuleStatus(String moduleStatus) {
        this.moduleStatus = moduleStatus;
    }
}
