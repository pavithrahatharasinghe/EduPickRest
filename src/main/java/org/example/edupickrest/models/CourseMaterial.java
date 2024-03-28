package org.example.edupickrest.models;

public class CourseMaterial {

        private int materialId;
        private String materialName;
        private String materialType;
        private String materialLink;
        private int courseId;

        public CourseMaterial() {
        }

        public CourseMaterial(int materialId, String materialName, String materialType, String materialLink, int courseId) {
            this.materialId = materialId;
            this.materialName = materialName;
            this.materialType = materialType;
            this.materialLink = materialLink;
            this.courseId = courseId;
        }

        public int getMaterialId() {
            return materialId;
        }

        public void setMaterialId(int materialId) {
            this.materialId = materialId;
        }

        public String getMaterialName() {
            return materialName;
        }

        public void setMaterialName(String materialName) {
            this.materialName = materialName;
        }

        public String getMaterialType() {
            return materialType;
        }

        public void setMaterialType(String materialType) {
            this.materialType = materialType;
        }

        public String getMaterialLink() {
            return materialLink;
        }

        public void setMaterialLink(String materialLink) {
            this.materialLink = materialLink;
        }

        public int getCourseId() {
            return courseId;
        }

        public void setCourseId(int courseId) {
            this.courseId = courseId;
        }
}

//SQL to create the table for the CourseMaterial class
//CREATE TABLE CourseMaterial ( materialId INT PRIMARY KEY, materialName VARCHAR(255), materialType VARCHAR(255), materialLink VARCHAR(255), courseId INT, FOREIGN KEY (courseId) REFERENCES Course(courseId) );