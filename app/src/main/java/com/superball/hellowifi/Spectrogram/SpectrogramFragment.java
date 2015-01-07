package com.superball.hellowifi.Spectrogram;

import android.app.Activity;
import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;

import com.superball.hellowifi.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SpectrogramFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SpectrogramFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SpectrogramFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ///
    private String title = "Signal Strength";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public SpectrogramFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SpectrogramFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SpectrogramFragment newInstance(String param1, String param2) {
        SpectrogramFragment fragment = new SpectrogramFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ///
        TabHost tabHost = (TabHost) inflater.inflate(R.layout.fragment_spectrogram, container, false);

        tabHost.setup();

        tabHost.addTab(tabHost.newTabSpec("tab1")
                .setIndicator("2.4G")
                .setContent(R.id.tab1));

        tabHost.addTab(tabHost.newTabSpec("tab2")
                .setIndicator("5G")
                .setContent(R.id.tab2));

        ///
        TabWidget tabWidget = tabHost.getTabWidget();

        ///
        LinearLayout linearLayout1 = (LinearLayout) tabHost.findViewById(R.id.tab1);

        linearLayout1.addView(new SpectrogramView(getActivity()));

        return tabHost;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}