package com.example.lv4.Activity.adapter;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.lv4.Activity.models.Student;
import com.example.lv4.Activity.fragments.PersonalInfoFragment;
import com.example.lv4.Activity.fragments.StudentInfoFragment;
import com.example.lv4.Activity.fragments.SummaryFragment;
import com.example.lv4.Activity.listeners.PersonalListener;
import com.example.lv4.Activity.listeners.StudentListener;
import com.example.lv4.Activity.listeners.SummaryInfoDataSource;

import java.util.ArrayList;

public class CreateNewRecordAdapter extends FragmentStateAdapter implements PersonalListener, StudentListener, SummaryInfoDataSource {

    private String name = "", surname ="", date ="", subject ="", ects ="", hours ="", profesor ="";

    public ArrayList<Fragment> fragmentList = new ArrayList<>();
    public CreateNewRecordAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment;
        Log.i("POZICIJA", ": " +position);
        switch(position){
            case 0:
                fragment = PersonalInfoFragment.newInstance();
                ((PersonalInfoFragment)fragment).personalListener = this;
                break;
            case 1:
                fragment = StudentInfoFragment.newInstance();
                ((StudentInfoFragment)fragment).studentListener = this;
                break;
            default:
                fragment = SummaryFragment.newInstance();
                ((SummaryFragment)fragment).dataSource = this;

        }
        return fragment;
    }

    public void addFragment(Fragment fragment)
    {
        fragmentList.add(fragment);
    }

    @Override
    public int getItemCount() {
        return fragmentList.size();
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    @Override
    public void setECTS(String ects) {
        this.ects = ects;
    }

    @Override
    public void setHours(String hours) {
        this.hours = hours;
    }

    @Override
    public Student getStudent() {
        return new Student(name, surname, subject);
    }
}
