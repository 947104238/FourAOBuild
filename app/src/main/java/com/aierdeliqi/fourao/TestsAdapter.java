package com.aierdeliqi.fourao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.LinkedList;

public class TestsAdapter extends BaseAdapter{
    LinkedList<Tests>mData;
    Context context;

    public TestsAdapter(LinkedList<Tests> mData, Context context) {
        this.mData = mData;
        this.context = context;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.list_test,parent,false);
            holder = new ViewHolder();
            holder.tv_item = convertView.findViewById(R.id.tv_item);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder)convertView.getTag();
        }
        holder.tv_item.setText(mData.get(position).getTest());
        return convertView;
    }

    static class ViewHolder{
        TextView tv_item;
    }
}
