package ru.qotofey.perceptron.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ru.qotofey.perceptron.model.Sample;
import ru.qotofey.perceptron.view.adapter.modelholder.SampleModelHolder;
import ru.qotofey.perceptron.view.adapter.viewholder.SampleViewHolder;

public class SampleListAdapter extends RecyclerView.Adapter<SampleViewHolder> {

    public interface OnItemClickListener {
        void onUserItemClicked(Sample sample);
    }

    public OnItemClickListener onItemClickListener;

    private List<SampleModelHolder> mList;

    public SampleListAdapter() {
        mList = new ArrayList<>();
    }

    @Override
    public SampleViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return getItem(i).createViewHolder(viewGroup);
    }

    @Override
    public void onBindViewHolder(SampleViewHolder viewHolder, final int i) {
        try {
            viewHolder.bind(getItem(i));
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onUserItemClicked(getItem(i).getSample());
                }
            });
        } catch(IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onViewRecycled(SampleViewHolder holder) {
        super.onViewRecycled(holder);
        holder.unbind();
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    //new methods

    public SampleModelHolder getItem(int position) {
        return mList.get(position);
    }

    public List<SampleModelHolder> addItems(List<SampleModelHolder> list) {
        mList.addAll(list);
        notifyDataSetChanged();
        return mList;
    }

    public List<SampleModelHolder> setItems(List<SampleModelHolder> list) {
        clearList();
        addItems(list);
        return mList;
    }

    public void clearList() {
        mList.clear();
    }

}
