package com.example.lv4.Activity.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.example.lv4.Activity.interfaces.StudentListener;
import com.example.lv4.Activity.models.ApiCall;
import com.example.lv4.Activity.models.Course;
import com.example.lv4.Activity.models.Instructor;
import com.example.lv4.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class StudentInfoFragment extends Fragment implements Callback<ArrayList<ApiCall>> {

    @NonNull
    public static StudentInfoFragment newInstance(){
        Bundle args = new Bundle();
        StudentInfoFragment fragment = new StudentInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }
    Callback<ArrayList<Course>> courses;
    EditText etECTS, etHours;
    Spinner spinnerSubject, spinnerProfessor;
    public StudentListener studentListener;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.student_info_layout, container, false);

        etECTS = view.findViewById(R.id.inpt_ects);
        etECTS.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(studentListener != null){
                    studentListener.setECTS(etECTS.getText().toString());
                }
            }
        });

        etHours = view.findViewById(R.id.inpt_sati);
        etHours.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(studentListener != null){
                    studentListener.setProfesor(etHours.getText().toString());
                }
            }
        });
        return view;
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        studentListener = null;
    }
    public void setupSpinners(){
        spinnerProfessor.findViewById(R.id.spinnerProf);
        spinnerSubject.findViewById(R.id.spinnerSub);

        //ovo tu pogledaj --> odabir u spinneru predmeta bi trebao popuniti profesore samo s tog predmeta ! OK
       // ArrayAdapter<Instructor> adapter = ArrayAdapter.createFromResource()
    }


    @Override
    public void onResponse(Call<ArrayList<ApiCall>> call, Response<ArrayList<ApiCall>> response) {

    }

    @Override
    public void onFailure(Call<ArrayList<ApiCall>> call, Throwable t) {

    }
}
