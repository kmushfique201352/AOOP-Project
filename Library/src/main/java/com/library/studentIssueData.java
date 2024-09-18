package com.library;

import java.util.Date;

public class studentIssueData {
    private final String studentID;
    private final String studentName;
    private final String bookName;
    private final Date date;
    private final String checkReturn;

    public studentIssueData(String studentID, String studentName, String bookName, Date date, String checkReturn) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.bookName = bookName;
        this.date = date;
        this.checkReturn = checkReturn;
    }


    public String getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getBookName() {
        return bookName;
    }

    public Date getDate() {
        return date;
    }

    public String getCheckReturn() {
        return checkReturn;
    }

    public int getstudentIssueData(){
        return this.getstudentIssueData();
    }

}
