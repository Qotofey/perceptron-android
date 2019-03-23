package ru.qotofey.perceptron.view.adapter;
import android.support.v4.util.ArrayMap;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ru.qotofey.perceptron.view.adapter.viewholder.AbstractSampleViewHolder;
import ru.qotofey.perceptron.view.adapter.modelholder.AbstractSampleModelHolder;

public class SampleListAdapter extends RecyclerView.Adapter<AbstractSampleViewHolder<AbstractSampleModelHolder>> {

    private List<AbstractSampleModelHolder> mList;
    private Map<Integer, AbstractSampleModelHolder> mTypeInstances;

    public SampleListAdapter() {
        mList = new ArrayList<>();
        mTypeInstances = new ArrayMap<>();
    }

    @Override
    public AbstractSampleViewHolder<AbstractSampleModelHolder> onCreateViewHolder(ViewGroup viewGroup, int i) {
        return mTypeInstances.get(i).createViewHolder(viewGroup);
    }

    @Override
    public void onBindViewHolder(AbstractSampleViewHolder<AbstractSampleModelHolder> holder, int i) {
        holder.bind(getItem(i));
    }

    @Override
    public void onViewRecycled(AbstractSampleViewHolder<AbstractSampleModelHolder> holder) {
        super.onViewRecycled(holder);
        holder.unbind();
    }

    @Override
    public int getItemViewType(int position) {
        return getItem(position).getType().getResId();
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    //render viewHolder

    public void registerTypeInstance(AbstractSampleModelHolder item) {
        if (!mTypeInstances.containsKey(item.getType())) {
            mTypeInstances.put(item.getType().getResId(), item);
        }
    }

    //new methods

    public AbstractSampleModelHolder getItem(int position) {
        return mList.get(position);
    }

    public List<AbstractSampleModelHolder> addItems(List<? extends AbstractSampleModelHolder> list) {
        for (AbstractSampleModelHolder item : list) {
            registerTypeInstance(item);
        }
        mList.addAll(list);

        notifyDataSetChanged();

        return mList;
    }

    public List<AbstractSampleModelHolder> setItems(List<AbstractSampleModelHolder> list) {
        clearList();
        addItems(list);
        return mList;
    }

    public void clearList() {
        mList.clear();
    }

}
