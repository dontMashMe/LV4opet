package com.example.lv4.Activity.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.Button;

import com.example.lv4.Activity.adapter.CreateNewRecordAdapter;
import com.example.lv4.Activity.adapter.RecViewAdapter;
import com.example.lv4.Activity.fragments.PersonalInfoFragment;
import com.example.lv4.Activity.fragments.StudentInfoFragment;
import com.example.lv4.Activity.fragments.SummaryFragment;
import com.example.lv4.R;

import java.util.ArrayList;

public class CreateNewRecordActivity extends AppCompatActivity {

    public ViewPager2 viewPager;
    CreateNewRecordAdapter newRecordAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_record);
        ViewPagerSetup();
    }

    private void ViewPagerSetup()
    {
        newRecordAdapter = new CreateNewRecordAdapter(this);
        newRecordAdapter.addFragment(new PersonalInfoFragment());
        newRecordAdapter.addFragment(new StudentInfoFragment());
        newRecordAdapter.addFragment(new SummaryFragment());
        viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(newRecordAdapter);
    }

}