package com.example.collegeapp_studentfaculty.ui.Gallery;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.collegeapp_studentfaculty.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class gallery extends Fragment {

    RecyclerView convocation,independence;
    GalleryAdapter inadapter,conadapter;
    DatabaseReference galleryRef;
    List<String> listcon,listin;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_gallery, container, false);
        convocation=view.findViewById(R.id.convocation_rv);
        independence=view.findViewById(R.id.independence_rv);

        galleryRef= FirebaseDatabase.getInstance().getReference().child("Images");
        getConvoImage();
        getindependentImage();

        listin=new ArrayList<>();
        inadapter=new GalleryAdapter(listin,getContext());
        GridLayoutManager gridLayoutManage1=new GridLayoutManager(getContext(),4);
        independence.setAdapter(inadapter);
        independence.setLayoutManager(gridLayoutManage1);

        listcon=new ArrayList<>();
        conadapter=new GalleryAdapter(listcon,getContext());
        GridLayoutManager gridLayoutManage2=new GridLayoutManager(getContext(),4);
        convocation.setAdapter(conadapter);
        convocation.setLayoutManager(gridLayoutManage2);



        return view;
    }

    private void getindependentImage() {
        galleryRef.child("others").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                listin.clear();
                for(DataSnapshot d:snapshot.getChildren()){
                    String imageUrl=d.getValue(String.class);
                    listin.add(imageUrl);
//                    Toast.makeText(getContext(), listin.isEmpty()+"2", Toast.LENGTH_SHORT).show();
                }
                inadapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getConvoImage() {
        galleryRef.child("convocation").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listcon.clear();
                for(DataSnapshot d:snapshot.getChildren()) {
                    String imageUrl = d.getValue(String.class);
                    listcon.add(imageUrl);
//                    Toast.makeText(getContext(), "Convo"+ d.getKey(), Toast.LENGTH_SHORT).show();
                }
                conadapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Failed", Toast.LENGTH_SHORT).show();

            }
        });
    }
}