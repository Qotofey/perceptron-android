package ru.qotofey.perceptron.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.qotofey.perceptron.R;
import ru.qotofey.perceptron.view.SampleNewView;

public class SampleNewFragment extends Fragment implements SampleNewView {


    public SampleNewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sample_new, container, false);

        return view;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
