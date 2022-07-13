package com.example.collegeapp_studentfaculty.ui.Faculty;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.collegeapp_studentfaculty.R;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Faculty extends Fragment {
    RecyclerView cs,it,ece;
    LinearLayout csnodata,itnodata,ecenodata;
    ArrayList<FacultyModel> csfaculty,ecefaculty,ITfaculty;
    DatabaseReference facultyRef;
    FacultyAdapter adapterIT,adaptercs,adapterece;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_faculty, container, false);

        cs=view.findViewById(R.id.updateFaculty_cs_rv);
        it=view.findViewById(R.id.updateFaculty_IT_rv);
        ece=view.findViewById(R.id.updateFaculty_ece_rv);
        csnodata=view.findViewById(R.id.updateFaculty_nodatafoundcs);
        itnodata=view.findViewById(R.id.updateFaculty_nodatafoundIT);
        ecenodata=view.findViewById(R.id.updateFaculty_nodatafoundEce);

        csfaculty=new ArrayList<>();
        ecefaculty=new ArrayList<>();
        ITfaculty=new ArrayList<>();

        facultyRef= FirebaseDatabase.getInstance().getReference().child("Faculty");



        adapterIT=new FacultyAdapter(ITfaculty,getContext(),"Information Technology");
        it.setAdapter(adapterIT);
        LinearLayoutManager layoutManagerIT=new LinearLayoutManager(getContext());
        it.setLayoutManager(layoutManagerIT);

        adaptercs=new FacultyAdapter(csfaculty,getContext(),"Computer Science");
        cs.setAdapter(adaptercs);
        LinearLayoutManager layoutManagercs=new LinearLayoutManager(getContext());
        cs.setLayoutManager(layoutManagercs);


        adapterece=new FacultyAdapter(ecefaculty,getContext(),"Electronics and Communication");
        ece.setAdapter(adapterece);
        LinearLayoutManager layoutManagerece=new LinearLayoutManager(getContext());
        ece.setLayoutManager(layoutManagerece);


        csloadFaculty();
        ITloadFaculty();
        eceloadFaculty();

        return view;
    }



    private void ITloadFaculty() {
        facultyRef.child("Information Technology").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (!snapshot.exists()) {
                    itnodata.setVisibility(View.VISIBLE);
                    it.setVisibility(View.GONE);
                } else {
                    ITfaculty.clear();
                    itnodata.setVisibility(View.GONE);
                    it.setVisibility(View.VISIBLE);
                    for (DataSnapshot d : snapshot.getChildren()) {
                        FacultyModel model;
                        model = d.getValue(FacultyModel.class);
                        model.setFacultyId(d.getKey());
                        ITfaculty.add(model);
                    }
                    adapterIT.notifyDataSetChanged();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Can not retrieve information", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void csloadFaculty() {
        facultyRef.child("Computer Science").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                csfaculty.clear();
                if (!snapshot.exists()) {
                    csnodata.setVisibility(View.VISIBLE);
                    cs.setVisibility(View.GONE);}
                else{
                    csnodata.setVisibility(View.GONE);
                    cs.setVisibility(View.VISIBLE);
                    for (DataSnapshot d : snapshot.getChildren()) {
                        FacultyModel model;
                        model = d.getValue(FacultyModel.class);
                        model.setFacultyId(d.getKey());
                        csfaculty.add(model);
                    }
                    adaptercs.notifyDataSetChanged();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Can not retrieve information", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void eceloadFaculty() {
        facultyRef.child("Electronics And Communication").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ecefaculty.clear();
                if (!snapshot.exists()) {
                    ecenodata.setVisibility(View.VISIBLE);
                    ece.setVisibility(View.GONE);
                } else{
                    ecenodata.setVisibility(View.GONE);
                    ece.setVisibility(View.VISIBLE);
                    for (DataSnapshot d : snapshot.getChildren()) {
                        FacultyModel model;
                        model = d.getValue(FacultyModel.class);
                        model.setFacultyId(d.getKey());
                        ecefaculty.add(model);
                    }
                    adapterece.notifyDataSetChanged();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Can not retrieve information", Toast.LENGTH_SHORT).show();
            }
        });
    }
}