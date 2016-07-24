package com.example.ganesh.brokerapp.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ganesh.brokerapp.R;


public class LandingPagePagerFragment extends Fragment {

    private OnLandingPagePagerFragmentInteractionListener mListener;

    private static final String LOG_TAG = "Landing page container";

    public LandingPagePagerFragment() {
        // Required empty public constructor
    }

    public static LandingPagePagerFragment newInstance() {
        LandingPagePagerFragment fragment = new LandingPagePagerFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_landing_page_pager, container, false);

        SectionsPagerAdapter sectionsPagerAdapter;
        ViewPager viewpager;

        sectionsPagerAdapter = new SectionsPagerAdapter(getActivity().getSupportFragmentManager());
        viewpager = (ViewPager) rootView.findViewById(R.id.container_landing_page);
        if (viewpager != null) {
            viewpager.setAdapter(sectionsPagerAdapter);
            viewpager.setCurrentItem(1);
        }

        TabLayout tabLayout = (TabLayout) rootView.findViewById(R.id.lp_tabs);
        if (tabLayout != null) {
            tabLayout.setupWithViewPager(viewpager);
        }

        return rootView;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onLandingPagePagerFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnLandingPagePagerFragmentInteractionListener) {
            mListener = (OnLandingPagePagerFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnLandingPagePagerFragmentInteractionListener {
        // TODO: Update argument type and name
        void onLandingPagePagerFragmentInteraction(Uri uri);
    }

    private class SectionsPagerAdapter extends FragmentStatePagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch(position) {
                case 0 : return ExploreFragment.newInstance();
                case 1 : return HomeFragment.newInstance();
                case 2 : return TrendFragment.newInstance();
                default : return null;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            switch(position){
                case 0: return "CATEGORY";
                case 1 : return "HOME";
                case 2 : return "TREND";
            }
            return null;
        }
    }

}
