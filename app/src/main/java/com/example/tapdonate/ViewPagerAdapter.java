package com.example.tapdonate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import org.w3c.dom.Text;

import java.util.List;

public class ViewPagerAdapter extends PagerAdapter {

    Context mContext;
    List<ScreenCons> mScreenCons;

    public ViewPagerAdapter(Context mContext, List<ScreenCons> mScreenCons) {
        this.mContext = mContext;
        this.mScreenCons = mScreenCons;
    }



    @Override
    public int getCount() {
        return mScreenCons.size();

    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
       LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.layout_onboarding1, null);
        ImageView slideImageView = (ImageView) view.findViewById(R.id.logo_image);
        TextView slideHeading = (TextView) view.findViewById(R.id.first_text);
        TextView slideDescription = (TextView) view.findViewById(R.id.sec_text);

        slideHeading.setText(mScreenCons.get(position).getTitle());
        slideDescription.setText(mScreenCons.get(position).getDesc());
        slideImageView.setImageResource(mScreenCons.get(position).getScreenImg());


        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
