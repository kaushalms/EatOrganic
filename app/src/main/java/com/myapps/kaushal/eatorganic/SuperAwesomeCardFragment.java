package com.myapps.kaushal.eatorganic;

/**
 * Created by Kaushal on 1/21/2015.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app._ActionBarSherlockTrojanHorse;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;


import com.actionbarsherlock.app.SherlockFragment;

import java.util.Locale;

import static android.content.Intent.getIntent;

public class SuperAwesomeCardFragment extends SherlockFragment {

    public static final String ARG_PLANET_NUMBER = "planet_number";
    private static final String ARG_POSITION = "position";
    private static final String DRAWER_POSITION = "drawerposition";
    private int position;
    private int drawerposition;



    public static SuperAwesomeCardFragment newInstance(int position, int drawerPosition) {
        SuperAwesomeCardFragment f = new SuperAwesomeCardFragment();
        Bundle b = new Bundle();
        b.putInt(ARG_POSITION, position);
        b.putInt(DRAWER_POSITION,drawerPosition);
        f.setArguments(b);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        position = getArguments().getInt(ARG_POSITION);
        drawerposition = getArguments().getInt(DRAWER_POSITION);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {



        String[] plantation = getResources().getStringArray(R.array.plantation);
        String[] harvest= getResources().getStringArray(R.array.Harvesting);
        View rootView = inflater.inflate(R.layout.fragment_planet, container, false);

        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);

        FrameLayout fl = new FrameLayout(getActivity());
        fl.setLayoutParams(params);
        String plant = getResources().getStringArray(R.array.planets_array)[drawerposition];

        final int margin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, getResources()
                .getDisplayMetrics());
        Log.i("ARG_POSITION", String.valueOf(position));
        Log.i("DRAWER_POSITION", String.valueOf(drawerposition));


        plant = plant.replace(" ", "");
        int imageId = getResources().getIdentifier(plant.toLowerCase(Locale.getDefault()),
              "drawable", getActivity().getPackageName());


        ScrollView sv = new ScrollView(getActivity());
        TextView v = new TextView(getActivity());
        ImageView IV;
        IV = (ImageView)rootView.findViewById(R.id.image);
        params.setMargins(margin, margin, margin, margin);
        v.setLayoutParams(params);
        sv.setLayoutParams(params);
        v.setTextSize(16);
        v.setGravity(Gravity.NO_GRAVITY);
        //v.setGravity(Gravity.CENTER);

        v.setBackgroundResource(R.drawable.background_card);
        sv.setBackgroundResource(R.drawable.background_card);
        IV.setImageResource(imageId);




        if (position==0)
            v.setText(plantation[drawerposition]);// + (position + 1));
        if (position==1)
            v.setText(harvest[drawerposition]);
        IV.setBackgroundColor(0xffffffff);
        sv.addView(v);
        fl.addView(IV);
        fl.addView(sv);


        return fl;
    }

}