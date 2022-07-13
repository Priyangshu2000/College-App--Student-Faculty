package com.example.collegeapp_studentfaculty.ui.Gallery;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.collegeapp_studentfaculty.FullImage;
import com.example.collegeapp_studentfaculty.R;
import com.example.collegeapp_studentfaculty.ui.Notice.NoticeAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.viewholder> {
    List<String>list;

    public GalleryAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;


    }

    Context context;
    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view
                = LayoutInflater.from(parent.getContext()).inflate(R.layout.singleimage, parent, false);
        context=parent.getContext();
        return new GalleryAdapter.viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        String imageUrl=list.get(position);
        Picasso.get().load(imageUrl).into(holder.imageView);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos= holder.getAdapterPosition();
                Intent intent=new Intent(context, FullImage.class);
                intent.putExtra("imageUrl",list.get(pos));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
//        Toast.makeText(context, list.size()+"", Toast.LENGTH_SHORT).show();
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{
        ImageView imageView;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image);
        }
    }
}
