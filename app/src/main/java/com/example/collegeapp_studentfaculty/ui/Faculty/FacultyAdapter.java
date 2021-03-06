package com.example.collegeapp_studentfaculty.ui.Faculty;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.collegeapp_studentfaculty.R;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FacultyAdapter extends RecyclerView.Adapter<FacultyAdapter.viewholder> {
    ArrayList<FacultyModel> list;
    Context context;
    DatabaseReference facultyRef;
    String Dept;
    public FacultyAdapter(ArrayList<FacultyModel> list, Context context, String department) {
        this.list = list;
        this.context = context;
        Dept=department;
        facultyRef= FirebaseDatabase.getInstance().getReference().child("Faculty");
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view
                = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlefaculty, parent, false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
       FacultyModel model=list.get(position);
        holder.name.setText(model.getName());
        holder.designation.setText(model.getDesignation());
        holder.email.setText(model.getEmail());
        Picasso.get().load(model.getUserpic()).placeholder(R.drawable.ic_baseline_person_24).into(holder.userPic);
        if(model.getGender().equals("Female"))
            Picasso.get().load(model.getUserpic()).placeholder(R.drawable.ic_baseline_person_2_24).into(holder.userPic);
        holder.moreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,FacultyInfo.class);
                context.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView name,designation,email;
        MaterialButton update,delete;
        MaterialButton moreInfo;
        ImageView userPic;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.updateFaculty_name);
            designation=itemView.findViewById(R.id.updateFaculty_position);
            email=itemView.findViewById(R.id.updateFaculty_email);
//            update=itemView.findViewById(R.id.updateFaculty_updateButton);
//            delete=itemView.findViewById(R.id.updateFaculty_deleteButton);
            moreInfo=itemView.findViewById(R.id.updateFaculty_moreInfoButton);
            userPic=itemView.findViewById(R.id.updateFaculty_userPic);
        }
    }
}
