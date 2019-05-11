package com.example.geniusplazechallenge.recyclerview;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.geniusplazechallenge.R;
import com.example.geniusplazechallenge.model.DataItem;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<DataItem> dataItems;

    public MyAdapter(List<DataItem> dataItems) {
        this.dataItems = dataItems;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View childView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.data_itemview, viewGroup, false);
        return new MyViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        myViewHolder.firstName.setText(dataItems.get(i).getFirstName());
        myViewHolder.lastName.setText(dataItems.get(i).getLastName());
        myViewHolder.email.setText(dataItems.get(i).getEmail());


    }

    @Override
    public int getItemCount() {
        return dataItems.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
     TextView firstName, lastName,email;
     ImageView avatar;
        public MyViewHolder( View itemView) {
            super(itemView);
            firstName=itemView.findViewById(R.id.firstName);
            lastName=itemView.findViewById(R.id.lastName);
            email=itemView.findViewById(R.id.email);
            avatar=itemView.findViewById(R.id.avatar);
        }
    }
}
