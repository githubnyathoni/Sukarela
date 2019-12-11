package com.example.sukarela.ui.dashboard;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sukarela.R;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    List<Model> my_list;
    Context context;

    public CustomAdapter(List<Model> my_list, Context context){
        this.my_list = my_list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i){
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_list,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        final Model model=my_list.get(i);
        myViewHolder.name.setText(model.getName());
        myViewHolder.image.setImageDrawable(context.getResources().getDrawable(model.getImage()));
        myViewHolder.parent_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,DetailsActivity.class);
                intent.putExtra("image",model.getImage());
                intent.putExtra("name",model.getName());
                intent.putExtra("about",model.getAbout());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return my_list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name,about;
        RelativeLayout parent_layout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.image);
            name=itemView.findViewById(R.id.name);
            about=itemView.findViewById(R.id.about);
            parent_layout=itemView.findViewById(R.id.parent_layout);

        }
    }
}
