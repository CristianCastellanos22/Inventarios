package com.example.crist.myapplication;

public class Header {

    public String headerCode;
    public  String responsibleName;
    public String headerDate;

    public Header(String headerCode, String responsibleName, String headerDate) {
        this.headerCode = headerCode;
        this.responsibleName = responsibleName;
        this.headerDate = headerDate;
    }

    public String getHeaderCode() {
        return headerCode;
    }

    public void setHeaderCode(String headerCode) {
        this.headerCode = headerCode;
    }

    public String getResponsibleName() {
        return responsibleName;
    }

    public void setResponsibleName(String responsibleName) {
        this.responsibleName = responsibleName;
    }

    public String getHeaderDate() {
        return headerDate;
    }

    public void setHeaderDate(String headerDate) {
        this.headerDate = headerDate;
    }
}
