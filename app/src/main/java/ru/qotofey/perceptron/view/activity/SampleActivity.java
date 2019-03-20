package ru.qotofey.perceptron.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ru.qotofey.perceptron.R;

public class SampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
