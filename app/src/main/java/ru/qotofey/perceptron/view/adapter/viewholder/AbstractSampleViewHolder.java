package ru.qotofey.perceptron.view.adapter.viewholder;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

public abstract class AbstractSampleViewHolder<Item> extends RecyclerView.ViewHolder implements View.OnClickListener {

    public AbstractSampleViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
    }

    public abstract void bind(Item item);

    public abstract void unbind();

    @Override
    public void onClick(View v) {
        Snackbar.make(v, "Hello!", Snackbar.LENGTH_SHORT).show();
    }
}
