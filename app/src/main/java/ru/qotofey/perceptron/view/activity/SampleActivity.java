package ru.qotofey.perceptron.view.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;

import java.util.UUID;

import ru.qotofey.perceptron.view.fragment.SampleFragment;

public class SampleActivity extends SingleFragmentActivity {

    public static final String EXTRA_SAMPLE_ID = "ru.qotofey.sample_id";

    public static Intent createIntent(Context context, UUID sampleId) {
        Intent intent = new Intent(context, SampleActivity.class);
        intent.putExtra(EXTRA_SAMPLE_ID, sampleId);
        return intent;
    }

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
