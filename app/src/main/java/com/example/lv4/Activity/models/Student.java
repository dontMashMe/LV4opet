package com.example.lv4.Activity.models;


import java.io.Serializable;
import java.util.List;

public class Student {

    public String ime;
    public String prezime;
    public String datum_rodenja;
    public String predmet;
    public String broj_ects;
    public String broj_sati;
    public String profesor;
    public Student(String n, String p, String pred){
        this.ime = n;
        this.prezime = p;
        this.predmet = pred;
    }

    public String VratiImePrezime()
    {
        return this.ime + " " + this.prezime;
    }

    public String VratiPredmet(){
        return this.predmet;
    }


}
