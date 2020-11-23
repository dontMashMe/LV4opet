package com.example.lv4.Activity.Activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.lv4.Activity.models.Student;
import com.example.lv4.Activity.models.StudentList;
import com.example.lv4.Activity.adapter.RecViewAdapter;
import com.example.lv4.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class StartActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button button;
    ArrayList<Student> studenti = new ArrayList<>();
    RecyclerView recyclerView;
    Intent intent;
    List<String> spinnerArr = new ArrayList<String>();
    int check;
    Spinner oSpinner;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        setVariables();
        setupSpinner();

        button.setOnClickListener(v->clickFun(v));
    }


    void setVariables(){
        button = findViewById(R.id.buttonAdd);

        Student stud1 = new Student("-", "-", "-");
        studenti.add(stud1);

        StudentList studentList = StudentList.getInstance();
        ArrayList<Student> studentiSingleton;
        studentiSingleton = (ArrayList<Student>) studentList.ReturnList();
        studenti.addAll(studentiSingleton);
        for(int i = 0; i < studenti.size(); i++){
            if(studenti.get(i).ime.equals("") || studenti.get(i).prezime.equals("") || studenti.get(i).predmet.equals("")){
                studenti.remove(i);
            }
        }
        recyclerView = findViewById(R.id.rview);
        RecViewAdapter mAdapter = new RecViewAdapter(studenti);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        oSpinner = findViewById(R.id.spinner);

        Button button = findViewById(R.id.cameraBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this,CameraActivity.class);
                startActivity(intent);

            }
        });



    }

    void clickFun(View view){
        intent = new Intent(StartActivity.this, CreateNewRecordActivity.class);
        startActivity(intent);
        finish();
    }
    private void setupSpinner()
    {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.lang_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        oSpinner.setAdapter(adapter);
        oSpinner.setOnItemSelectedListener(this);
        Locale current = getResources().getConfiguration().locale;

        if(current.getLanguage().equals("en")) {
            oSpinner.setSelection(0);
        }
        if(current.getLanguage().equals("hr")) {
            oSpinner.setSelection(1);
        }
        if(current.getLanguage().equals("hu")) {
            oSpinner.setSelection(2);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        setLocale(i);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        return;
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public void setLocale(Integer pos) {
        ArrayList<String> strLocale = new ArrayList<String>();
        strLocale.add("en");
        strLocale.add("hr");
        strLocale.add("hu");

        setAppLocale(strLocale.get(pos));
        if (++check > 1)
        {
            finish();
            startActivity(getIntent());
        }

    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @SuppressWarnings("deprecation")
    private void setAppLocale (String localeCode)
    {
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.setLocale(new Locale(localeCode.toLowerCase()));
        res.updateConfiguration(conf, dm);
    }
}