package ru.qotofey.perceptron.view.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class AbstractSampleViewHolder<Item> extends RecyclerView.ViewHolder {

    public AbstractSampleViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bind(Item item);

    public abstract void unbind();

}
