package com.example.lv4.Activity.fragments;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lv4.R;

public class CameraFragment extends Fragment {
    private static final String EXTRA_IMAGE_ID = "EXTRA_IMAGE_ID";
    private static final int REQUEST_IMAGE_CAPTURE = 1;

    public static CameraFragment newInstance(int imageResourceId){
        Bundle args = new Bundle();
        args.putInt(EXTRA_IMAGE_ID, imageResourceId);
        CameraFragment cameraFragment = new CameraFragment();
        cameraFragment.setArguments(args);
        return  cameraFragment;
    }

    ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.camera_layout, container,false);
        imageView = view.findViewById(R.id.imageViewPic);

        Button button = view.findViewById(R.id.btnCamera);
        button.setOnClickListener(onCameraButtonClickListener);

        Bundle bundle = getArguments();

        if(bundle != null){
            setupImageView(bundle.getInt(EXTRA_IMAGE_ID));
        }

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if ( requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK){
            Bitmap imageBitmap = (Bitmap) data.getExtras().get("data");
            setupImageView(imageBitmap);
        }
    }

    private void setupImageView(int drawableId){
        imageView.setImageResource(drawableId);
    }

    private void setupImageView(Bitmap bitmap){
        imageView.setImageBitmap(bitmap);
    }

    View.OnClickListener  onCameraButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE); if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE); }
        }
    };


}
