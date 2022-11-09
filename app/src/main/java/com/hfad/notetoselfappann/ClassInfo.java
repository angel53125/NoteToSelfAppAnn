package com.hfad.notetoselfappann;

public class ClassInfo {
    private String title;
    private String status;
    private String description;


    public ClassInfo(String n,String s, String d)
    {
        title = n;
        status = s;
        description = d;

    }


    public String getTitle() {
        return title;
    }

    public String getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }
}
