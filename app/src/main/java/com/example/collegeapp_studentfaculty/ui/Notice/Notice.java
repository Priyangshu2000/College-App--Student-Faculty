package com.example.collegeapp_studentfaculty.ui.Notice;

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

public class Notice extends Fragment {
    RecyclerView recyclerView;
    ProgressBar progressBar;
    DatabaseReference noticeRef;
    NoticeAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_notice, container, false);
        progressBar=view.findViewById(R.id.notice_progressbar);
        recyclerView=view.findViewById(R.id.notice_rv);
        progressBar.setVisibility(View.VISIBLE);
        ArrayList<NoticeModel> noticeModel=new ArrayList<>();
        adapter=new NoticeAdapter(noticeModel,getContext());
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        noticeRef= FirebaseDatabase.getInstance().getReference();
        noticeRef.child("Notice").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                noticeModel.clear();
                for(DataSnapshot d:snapshot.getChildren()){
                    NoticeModel model=d.getValue(NoticeModel.class);
                    model.setNoticeId(d.getKey());
                    model.setHeading("Heading of Notice");
                    noticeModel.add(model);
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
    @Override
    public void onStart()
    {
        super.onStart();
//        adapter.notify();

    }
    @Override public void onStop()
    {
        super.onStop();
//        adapter.notify();
    }
}