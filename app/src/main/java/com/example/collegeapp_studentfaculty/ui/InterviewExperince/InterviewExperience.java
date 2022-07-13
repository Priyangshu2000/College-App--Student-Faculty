package com.example.collegeapp_studentfaculty.ui.InterviewExperince;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.collegeapp_studentfaculty.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class InterviewExperience extends Fragment {
    RecyclerView recyclerView;
    ProgressBar progressBar;
    DatabaseReference noticeRef;
    InterviewExperienceAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_interview_experience, container, false);
        recyclerView=view.findViewById(R.id.interviewExp_rv);
        progressBar=view.findViewById(R.id.interviewExp_progressbar);
        progressBar.setVisibility(View.VISIBLE);
        ArrayList<InterviewExperienceModel> interviewExpmodel=new ArrayList<>();
        adapter=new InterviewExperienceAdapter(interviewExpmodel,getContext());
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        noticeRef= FirebaseDatabase.getInstance().getReference();
        noticeRef.child("Interview Experience").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                interviewExpmodel.clear();
                for(DataSnapshot d:snapshot.getChildren()){
                    InterviewExperienceModel model=d.getValue(InterviewExperienceModel.class);
//                    model.(d.getKey());
                    interviewExpmodel.add(model);
                    progressBar.setVisibility(View.GONE);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(view.getContext(), "Can not retrieve information", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}