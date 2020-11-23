package com.example.lv4.Activity.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lv4.Activity.interfaces.StudentListener;
import com.example.lv4.R;

public class StudentInfoFragment extends Fragment {

    @NonNull
    public static StudentInfoFragment newInstance(){
        Bundle args = new Bundle();
        StudentInfoFragment fragment = new StudentInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }
    EditText etSubject, etProfesor, etECTS, etHours;
    public StudentListener studentListener;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.student_info_layout, container, false);
        etSubject = view.findViewById(R.id.inpt_predmet);
        etSubject.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(studentListener != null){
                    studentListener.setSubject(etSubject.getText().toString());
                }
            }
        });
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
        etProfesor = view.findViewById(R.id.inpt_prof);
        etProfesor.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(studentListener != null){
                    studentListener.setProfesor(etProfesor.getText().toString());
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
}
