package com.example.lv4.Activity.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.graphics.Camera;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.lv4.Activity.fragments.CameraFragment;
import com.example.lv4.R;

public class CameraActivity extends AppCompatActivity {

    FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        frameLayout.findViewById(R.id.frameLayout);
        setupFragment();
    }

    private void setupFragment(){
        Fragment fragment = CameraFragment.newInstance(R.drawable.ic_launcher_background);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frameLayout, fragment)
                .commit();
    }
}