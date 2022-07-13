package com.example.collegeapp_studentfaculty.ui.Home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.collegeapp_studentfaculty.R;
import com.squareup.picasso.Picasso;

public class Home extends Fragment {
    ImageView collegePic;
    String collegePicurl="https://firebasestorage.googleapis.com/v0/b/collegeapp-admin.appspot.com/o/images%2FcollegeJU.jpg?alt=media&token=525d7a86-c546-4298-bbfc-6add03a6bd22";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        collegePic=view.findViewById(R.id.college_pic);
        Picasso.get().load(collegePicurl).into(collegePic);
        return view;
    }
}