package com.myapps.kaushal.eatorganic;

/**
 * Created by Kaushal on 1/20/2015.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockFragment;
import com.astuetz.PagerSlidingTabStrip;



public class PageSlidingTabStripFragment extends Fragment {


    public static PageSlidingTabStripFragment newInstance(int someInt, String someTitle) {
        PageSlidingTabStripFragment fragmentDemo = new PageSlidingTabStripFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", someInt);
        args.putString("someTitle", someTitle);
        fragmentDemo.setArguments(args);
        return fragmentDemo;
    }



   // int id=  getArguments().getInt("ARG_DATA");


    public static final String TAG = PageSlidingTabStripFragment.class
            .getSimpleName();




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        int SomeInt = getArguments().getInt("someInt", 0);
        String someTitle = getArguments().getString("someTitle", "");
        Log.i("kaushal3", String.valueOf(SomeInt));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.pager, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) view
                .findViewById(R.id.tabs);
        ViewPager pager = (ViewPager) view.findViewById(R.id.pager);
        MyPagerAdapter adapter = new MyPagerAdapter(getChildFragmentManager());
        pager.setAdapter(adapter);
        tabs.setViewPager(pager);

    }




    public class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }
        int SomeInt = getArguments().getInt("someInt", 0);


        private final String[] TITLES = {"PLANTATION", "GROWING & HARVESTING"};
//just making a minor change
        @Override
        public CharSequence getPageTitle(int position) {
            return TITLES[position];
        }

        @Override
        public int getCount() {
            return TITLES.length;
        }

        @Override
        public SherlockFragment getItem(int position) {
            //Log.i("kaushalTest", String.valueOf(SomeInt));
            int pos = position;
            int position2=SomeInt;
           Log.i("kaushalTest", String.valueOf(pos));
            Log.i("PositionTest", String.valueOf(position2));

            return SuperAwesomeCardFragment.newInstance(position,position2);
        }

    }


}
