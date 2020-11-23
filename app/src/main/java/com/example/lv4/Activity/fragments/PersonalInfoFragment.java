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

import com.example.lv4.Activity.listeners.PersonalListener;
import com.example.lv4.R;

public class PersonalInfoFragment extends Fragment {
    @NonNull
    public static PersonalInfoFragment newInstance(){
        Bundle args = new Bundle();
        PersonalInfoFragment fragment = new PersonalInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public PersonalListener personalListener;
    EditText etName, etSurname, etDate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.personal_info_layout, container, false);
        etName = view.findViewById(R.id.inpt_name);
        etName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(personalListener != null){
                    personalListener.setName(etName.getText().toString());
                }
            }
        });
        etSurname = view.findViewById(R.id.inpt_surname);
        etSurname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(personalListener != null){
                    personalListener.setSurname(etSurname.getText().toString());
                }

            }
        });
        etDate = view.findViewById(R.id.inpt_date);
        etDate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(personalListener != null){
                    personalListener.setDate(etDate.getText().toString());
                }

            }
        });
        return view;
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        personalListener = null;
    }
}
