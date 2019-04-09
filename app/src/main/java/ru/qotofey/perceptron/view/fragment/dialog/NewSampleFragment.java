package ru.qotofey.perceptron.view.fragment.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;

import ru.qotofey.perceptron.R;

public class NewSampleFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_new_sample, null);

        return new AlertDialog.Builder(getActivity())
                .setView(view)
                .setTitle("Новая выборка")
                .setPositiveButton("Создать", null)
                .create();
    }
}
