package ru.qotofey.perceptron.view.activity;

import android.support.v4.app.Fragment;
import android.os.Bundle;

import ru.qotofey.perceptron.view.fragment.SampleFragment;

public class SampleActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new SampleFragment();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
