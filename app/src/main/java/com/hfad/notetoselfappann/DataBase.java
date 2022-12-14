package com.hfad.notetoselfappann;

import java.util.ArrayList;

public class DataBase {
    private static ArrayList<Note> allNotes;


    public static ArrayList<Note> getData() {
        if (allNotes == null) {
            loadData();
        }
        return allNotes;
    }


    private static void loadData() {
        allNotes= new ArrayList<Note>();

        ArrayList<String> status = new ArrayList<String>();
        ArrayList<String> title = new ArrayList<String>();
        ArrayList<String> desc = new ArrayList<String>();

        status.add("Idea");
        status.add("Homework");
        status.add("Wish List");
        status.add("Classes");
        status.add("Teachers");
        status.add("Friends");
        status.add("Not Friends");
        status.add("Hobbies");
        status.add("Friends");
        status.add("Not Friends");
        status.add("Hobbies");


        title.add("title");
        title.add("title 2");
        title.add("title 3");
        title.add("title 4");
        title.add("title 5");
        title.add("title 6");
        title.add("title 7");
        title.add("title 8");
        title.add("title 6");
        title.add("title 7");
        title.add("title 8");

        desc.add("desc");
        desc.add("desc 2");
        desc.add("desc 3");
        desc.add("desc 4");
        desc.add("desc 5");
        desc.add("desc 6");
        desc.add("desc 7");
        desc.add("desc 8");
        desc.add("desc 6");
        desc.add("desc 7");
        desc.add("desc 8");



        for (int i = 0;i < status.size();i++)
        {
            allNotes.add(new Note(status.get(i),title.get(i),desc.get(i)));
        }

    }

    public static void addNote(String status, String title, String desc)
    {
       Note c = new Note(title,status,desc);
       allNotes.add(c);
    }
}
