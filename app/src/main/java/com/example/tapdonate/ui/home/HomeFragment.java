package com.example.tapdonate.ui.home;

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

public class HomeFragment extends Fragment{


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        HomeCons[] hpp = new HomeCons[]{
                new HomeCons("Aghosh Karachi", "Sochlay Special 40% discount on entire menu", R.drawable.aghoshpdf),
                new HomeCons("Saylani Welfare Trust", "Sochlay Special 40% discount on entire menu", R.drawable.saaylaani),
                new HomeCons("Aghosh Karachi", "Sochlay Special 40% discount on entire menu", R.drawable.secagho),
                new HomeCons("Dhoraji Association", "Sochlay Special 40% discount on entire menu", R.drawable.dhora),
                new HomeCons("Sun Beams", "Sochlay Special 40% discount on entire menu", R.drawable.sunb),
                new HomeCons("Aghosh Karachi", "Sochlay Special 40% discount on entire menu", R.drawable.alhri),
                new HomeCons("Dhoraji Association", "Sochlay Special 40% discount on entire menu", R.drawable.dhora),
                new HomeCons("Sun Beams", "Sochlay Special 40% discount on entire menu", R.drawable.sunb),
                new HomeCons("Aghosh Karachi", "Sochlay Special 40% discount on entire menu", R.drawable.alhri)

        };

        RecyclerView recyclerView =root.findViewById(R.id.tap_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        HomeAdapter homeAdapter = new HomeAdapter(hpp);
        recyclerView.setAdapter(homeAdapter);
        return root;
    }
}
