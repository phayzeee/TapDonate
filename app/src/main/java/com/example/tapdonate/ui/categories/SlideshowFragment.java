package com.example.tapdonate.ui.categories;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tapdonate.R;
import com.example.tapdonate.ui.home.HomeAdapter;

public class SlideshowFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        CategCons[] cons = new CategCons[]{
                new CategCons("Mobile",R.drawable.ic_mobile),
                new CategCons("Vehicles",R.drawable.ic_mobile),
                new CategCons("Pets",R.drawable.ic_mobile),
                new CategCons("Furnitiure & home decor",R.drawable.ic_mobile),
                new CategCons("Electronic & Appliances",R.drawable.ic_mobile),
                new CategCons("Fashion & Beauty",R.drawable.ic_mobile),
                new CategCons("Property for sell",R.drawable.ic_mobile),
                new CategCons("Property for rent",R.drawable.ic_mobile),
                new CategCons("Kids",R.drawable.ic_mobile),
                new CategCons("Bikes",R.drawable.ic_mobile),
                new CategCons("Services",R.drawable.ic_mobile),
                new CategCons("Book, Sports & HObbies",R.drawable.ic_mobile)
        };
        RecyclerView recyclerView =root.findViewById(R.id.categ_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        CategAdapter categAdapter = new CategAdapter(cons);
        recyclerView.setAdapter(categAdapter);
        return root;
        }

    }
