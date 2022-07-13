package com.example.collegeapp_studentfaculty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.collegeapp_studentfaculty.ui.Faculty.Faculty;
import com.example.collegeapp_studentfaculty.ui.Gallery.gallery;
import com.example.collegeapp_studentfaculty.ui.Home.Home;
import com.example.collegeapp_studentfaculty.ui.InterviewExperince.InterviewExperience;
import com.example.collegeapp_studentfaculty.ui.Notice.Notice;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView Navigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Navigation=findViewById(R.id.bottom_nav_bar);
        replace(new Home());
        Navigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                switch(id){
                    case R.id.home:
                    {
                        replace(new Home());
                        break;}
                    case R.id.faculty:{
                        replace(new Faculty());
                        break;
                    }
                    case R.id.interviewExp:{
                        replace(new InterviewExperience());
                       break;
                    }
                    case R.id.notice:{
                        replace(new Notice());
                        break;
                    }
                    case R.id.gallery:{
                        replace(new gallery());
                       break;
                    }

                }
                return true;
            }
        });
    }
    private void replace(Fragment fragmentPost) {
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction().replace(R.id.dashboard_frame_layout,fragmentPost);
        ft.commit();
    }

}