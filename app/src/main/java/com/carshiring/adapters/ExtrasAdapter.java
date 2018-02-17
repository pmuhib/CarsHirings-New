package com.carshiring.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.carshiring.R;
import com.carshiring.models.ExtraBean;

import java.util.ArrayList;

/**
 * Created by Muhib.
 * Contact Number : +91 9796173066
 */
public class ExtrasAdapter extends RecyclerView.Adapter<ExtrasAdapter.ViewHolder> {

    Context context;
    ArrayList<ExtraBean> beanArrayList=new ArrayList<>();

    public ExtrasAdapter(Context context, ArrayList<ExtraBean> beanArrayList) {
        this.context = context;
        this.beanArrayList = beanArrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row= LayoutInflater.from(parent.getContext()).inflate(R.layout.extraslist,parent,false);
        return new ViewHolder(row);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
       holder.txt_extrasname.setText(beanArrayList.get(position).getName());
       holder.txt_price.setText(beanArrayList.get(position).getCurrency()+" "+beanArrayList.get(position).getPrice());


    }

    @Override
    public int getItemCount() {
        return beanArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_extrasname,txt_price;
        Spinner spinner;
        public ViewHolder(View itemView) {
            super(itemView);
            txt_extrasname=itemView.findViewById(R.id.txt_extrasname);
            txt_price=itemView.findViewById(R.id.txt_price);
            spinner=itemView.findViewById(R.id.spinner2);
        }
    }
}
