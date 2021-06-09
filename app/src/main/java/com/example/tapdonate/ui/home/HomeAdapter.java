package com.example.tapdonate.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tapdonate.R;

import org.w3c.dom.Text;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.Viewer>{

    private HomeCons homeCons[];
    private Context context;

    public HomeAdapter(HomeCons[] homeCons) {
        this.homeCons = homeCons;
        this.context = context;

    }

    @NonNull
    @Override
    public Viewer onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View list =layoutInflater.inflate(R.layout.layout_recycler, parent, false);
        Viewer root =new Viewer(list);
        return root;

    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.Viewer holder, int position) {
        final HomeCons listdata = homeCons[position];
        holder.first_txt.setText(listdata.getT1());
        holder.second_txt.setText(listdata.getT2());
        holder.image_logo.setImageResource(listdata.getLogoImage());
    }

    @Override
    public int getItemCount() {
        return homeCons.length;
    }

    public static class Viewer extends RecyclerView.ViewHolder {
        public TextView first_txt,second_txt;
        public ImageView image_logo;
        public Button btn_imagee;
        public Viewer(@NonNull View itemView) {
            super(itemView);


            first_txt = itemView.findViewById(R.id.aghosh_txt);
            second_txt = itemView.findViewById(R.id.aghosh_second);
            image_logo = itemView.findViewById(R.id.aghoshlogo);
            btn_imagee = itemView.findViewById(R.id.btn_donate);
        }
    }
}
