package com.example.geniusplazechallenge.recyclerview;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.geniusplazechallenge.OnItemClicked;
import com.example.geniusplazechallenge.R;
import com.example.geniusplazechallenge.model.DataItem;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<DataItem> dataItems;
    private OnItemClicked onItemClicked;
    private Context context;

    public MyAdapter(List<DataItem> dataItems,OnItemClicked onItemClicked,Context context) {
        this.dataItems = dataItems;
        this.onItemClicked=onItemClicked;
        this.context = context;
    }



    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View childView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.data_itemview, viewGroup, false);
        return new MyViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int i) {
        myViewHolder.firstName.setText(dataItems.get(i).getFirstName());
        myViewHolder.lastName.setText(dataItems.get(i).getLastName());
        myViewHolder.email.setText(dataItems.get(i).getEmail());
        Picasso.with(context).load(dataItems.get(i).getAvatar()).into(myViewHolder.avatar);
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              onItemClicked.itemClicked(dataItems.get(i));
            }
        });


    }

    @Override
    public int getItemCount() {
        return dataItems.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
     TextView firstName, lastName,email;
     ImageView avatar;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            firstName=itemView.findViewById(R.id.firstName);
            lastName=itemView.findViewById(R.id.lastName);
            email=itemView.findViewById(R.id.email);
            avatar=itemView.findViewById(R.id.avatar);
        }
    }
}
