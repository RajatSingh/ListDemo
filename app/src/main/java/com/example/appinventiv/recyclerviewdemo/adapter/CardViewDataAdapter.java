package com.example.appinventiv.recyclerviewdemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appinventiv.recyclerviewdemo.R;
import com.example.appinventiv.recyclerviewdemo.bean.ItemBean;

import java.util.List;

/**
 * Created by appinventiv on 21/7/15.
 */
public class CardViewDataAdapter extends RecyclerView.Adapter<CardViewDataAdapter.ViewHolder>   {



    private List<ItemBean> itemBeanList;

    public CardViewDataAdapter(List<ItemBean> itemBeanList) {
        this.itemBeanList = itemBeanList;

    }

    // Create new views

    public CardViewDataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        // create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.cardview_row, null);

        // create ViewHolder

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }


    // Bind data with holder

    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        viewHolder.tvName.setText(itemBeanList.get(position).getName());

        viewHolder.tvEmailId.setText(itemBeanList.get(position).getEmailId());

        viewHolder.singlebean=itemBeanList.get(position);

    }

    // Return the size arraylist

    public int getItemCount() {
        return itemBeanList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvName;
        public TextView tvEmailId;
        public ItemBean singlebean;

        public ViewHolder(View itemLayoutView) {

            super(itemLayoutView);

            tvName = (TextView) itemLayoutView.findViewById(R.id.tvName);

            tvEmailId = (TextView) itemLayoutView.findViewById(R.id.tvEmailId);

            // Onclick event for the row to show the data in toast

            itemLayoutView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    Toast.makeText(
                            v.getContext(),
                            "Data : \n" + singlebean.getName() + " \n"
                                    + singlebean.getEmailId(),
                            Toast.LENGTH_SHORT).show();

                }
            });

        }

    }

}






