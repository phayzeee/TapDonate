package com.example.tapdonate.ui.categories;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tapdonate.R;

public class CategAdapter extends RecyclerView.Adapter<CategAdapter.Viewer> {

    private CategCons categCons[];
    private Context context;

    public CategAdapter(CategCons[] categCons) {
        this.categCons = categCons;
        this.context = context;
    }

    @NonNull
    @Override
    public Viewer onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View list = layoutInflater.inflate(R.layout.layout_category, parent, false);
        Viewer root = new Viewer(list);
        return root;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewer holder, int position) {
        final CategCons listdata = categCons[position];
        holder.imageView.setImageResource(listdata.getImage1());
        holder.textView.setText(listdata.getText1());

    }

    @Override
    public int getItemCount() {
        return categCons.length;
    }

    public class Viewer extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView textView;
        public Viewer(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.categ_image);
            textView = itemView.findViewById(R.id.txt_category);
        }
    }
}
