package ru.qotofey.perceptron.view.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import ru.qotofey.perceptron.R;
import ru.qotofey.perceptron.model.Sample;
import ru.qotofey.perceptron.view.fragment.SampleListFragment;
import ru.qotofey.perceptron.view.fragment.dialog.NewSampleFragment;

public class SampleListActivity extends SingleFragmentActivity implements SampleListFragment.SampleListListener {

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_masterdetail;
    }

    @Override
    protected Fragment createFragment() {
        return new SampleListFragment();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onSampleClicked(Sample sample) {
        Intent intent = SampleActivity.createIntent(this, sample.getId());
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_sample_list, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add: {
//                Intent intent = new Intent(this, SampleNewActivity.class);
//                startActivity(intent);
                FragmentManager manager = getSupportFragmentManager();
                NewSampleFragment dialog = new NewSampleFragment();
                dialog.show(manager, "NewSampleDialog");
                break;
            }
            case R.id.action_build: {
//                Toast.makeText(this, "Нельзя построить!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, SampleActivity.class);
                startActivity(intent);
//                Snackbar.make(this, "Нельзя построить!", Snackbar.LENGTH_SHORT).show();
                break;
            }
            case R.id.action_learn: {
                Toast.makeText(this, "Нельзя тренировать!", Toast.LENGTH_SHORT).show();
                break;
            }
            default: {
                Toast.makeText(this, "Default", Toast.LENGTH_SHORT).show();
                Log.i("MenuItem", "не может быть");
            }
        }
        return super.onOptionsItemSelected(item);
    }

}
