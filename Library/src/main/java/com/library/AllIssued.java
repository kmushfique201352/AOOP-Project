package com.library;

public class AllIssued {

    private final String studentID;
    private final String bookName;

    public String getStudentID() {
        return studentID;
    }

    public String getBookName() {
        return bookName;
    }

    public AllIssued(String studentID, String bookName){
        this.studentID=studentID;
        this.bookName=bookName;
    }
}
