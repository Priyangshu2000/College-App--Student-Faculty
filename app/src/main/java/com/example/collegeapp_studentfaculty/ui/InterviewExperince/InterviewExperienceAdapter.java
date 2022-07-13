package com.example.collegeapp_studentfaculty.ui.InterviewExperince;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.collegeapp_studentfaculty.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class InterviewExperienceAdapter extends RecyclerView.Adapter<InterviewExperienceAdapter.viewholder> {
    ArrayList<InterviewExperienceModel>list;
    Context context;
    DatabaseReference noticeRef;

    public InterviewExperienceAdapter(ArrayList<InterviewExperienceModel> list, Context context) {
        this.list = list;
        this.context = context;
        noticeRef=FirebaseDatabase.getInstance().getReference().child("Notice");
    }

    public InterviewExperienceAdapter() {
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view
                = LayoutInflater.from(parent.getContext()).inflate(R.layout.singleinterviewexp, parent, false);
        context=parent.getContext();
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
       InterviewExperienceModel ithnotice=list.get(position);
        holder.heading.setText(ithnotice.getHeading());
        holder.noticeBody.setText(ithnotice.getBody());
        Picasso.get().load(ithnotice.getUserPic()).placeholder(R.drawable.ic_baseline_person_24).into(holder.userPic);
        Picasso.get().load(ithnotice.getInterviewExpPic()).into(holder.noticePic);
        String name= ithnotice.getUserName();
        String batch=ithnotice.getBatch();
        String dept=ithnotice.getDept();
//        Toast.makeText(context, name+"  "+"Batch: "+batch+dept, Toast.LENGTH_SHORT).show();
        String details=name+"  "+"Batch: "+batch+" , "+dept;
        holder.username.setText(details);

    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView heading,noticeBody;
        CircleImageView userPic;
        TextView username;
        ImageView noticePic;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            heading=itemView.findViewById(R.id.delete_notice_heading);
            noticeBody=itemView.findViewById(R.id.delete_notice_body);
            userPic=itemView.findViewById(R.id.delete_notice_userPic);
            noticePic=itemView.findViewById(R.id.delete_notice_notice_pic);
            username=itemView.findViewById(R.id.interviewExp_studentName);
        }
    }
}
