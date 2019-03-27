package ru.qotofey.perceptron.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import ru.qotofey.perceptron.view.fragment.SampleNewFragment;

public class SampleNewActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new SampleNewFragment();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
