package com.example.lv4.Activity.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lv4.Activity.Activities.StartActivity;
import com.example.lv4.Activity.models.Student;
import com.example.lv4.Activity.models.StudentList;
import com.example.lv4.Activity.listeners.SummaryInfoDataSource;
import com.example.lv4.R;

public class SummaryFragment extends Fragment {
    public static SummaryFragment newInstance(){
        Bundle args = new Bundle();
        SummaryFragment fragment = new SummaryFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public SummaryInfoDataSource dataSource;
    Intent intent;
    Button button;
    Student student;

    TextView tvName, tvSurname, tvProf, tvSub;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.summary_info_layout, container, false);

        button = (Button)view.findViewById(R.id.buttonFinish);
        button.setOnClickListener(this::onClick);
        setupViews(view);
        return view;
    }


    public void onClick(View view){

        StudentList studentList = StudentList.getInstance();
        studentList.AddStudent(student);
        intent = new Intent(getActivity(), StartActivity.class);
        startActivity(intent);
    }

    void setupViews(View view){
        tvName = view.findViewById(R.id.txtName);
        tvSurname = view.findViewById(R.id.txtSurname);
        tvProf = view.findViewById(R.id.txtProf);
        tvSub = view.findViewById(R.id.txtSub);
    }
    void setupData(Student student){
        tvName.setText(student.ime);
        tvSurname.setText(student.prezime);
        tvProf.setText(student.profesor);
        tvSub.setText(student.predmet);
    }
    @Override
    public void onPause(){
        super.onPause();
        if(dataSource != null){
            Log.i("CALLED", "PAUZA");
            student = dataSource.getStudent();
        }
    }
    @Override
    public void onResume(){
        super.onResume();
        student = dataSource.getStudent();

        //idk koje od ovog radI? niti sta radi iskreno zbunjen sam
        if(getView() != null && student!=null){
            setupData(student);
        }else{
            Log.i("!", "studenta nema");
        }
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        dataSource = null;
    }


}



