package com.library;

public class AvailableStudents {
    private final String studentID;
    private final String password;
    private final String image;

    public AvailableStudents(String studentID, String password, String image) {
        this.studentID = studentID;
        this.password = password;
        this.image = image;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getPassword() {
        return password;
    }

    public String getImage() {
        return image;
    }
}
