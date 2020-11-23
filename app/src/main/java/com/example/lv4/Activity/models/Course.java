package com.example.lv4.Activity.models;

import java.util.ArrayList;

public class Course {
    String title;
    ArrayList<Instructor> instructors;

    public String getTitle(){
        return this.title;
    }
    public ArrayList<Instructor> getInstructors(){
        return this.instructors;
    }
}
