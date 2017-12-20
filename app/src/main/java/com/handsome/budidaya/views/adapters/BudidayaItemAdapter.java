package com.handsome.budidaya.views.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.handsome.budidaya.R;
import com.handsome.budidaya.models.Budidaya;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by handsome on 11/12/17.
 */

public class BudidayaItemAdapter extends BaseAdapter implements Filterable{
    private Context context;
    private List<Budidaya> budidayas;
    private List<Budidaya> tempBudidaya;

    public BudidayaItemAdapter(Context context, List<Budidaya> budidayas) {
        this.context = context;
        this.budidayas = budidayas;
        this.tempBudidaya = budidayas;
    }

    @Override
    public int getCount() {
        if(tempBudidaya.size() > 0)
            return tempBudidaya.size();
        else
            return budidayas.size();
    }

    @Override
    public Object getItem(int position) {
        if(tempBudidaya.size() > 0)
            return tempBudidaya.get(position);
        else
            return budidayas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.budidaya_item_layout, parent, false);
        TextView txtJudulBd = (TextView)view.findViewById(R.id.txtJudulBd);
        if(tempBudidaya.size() > 0) {
            txtJudulBd.setText(budidayas.get(position).getJudul());
        } else {
            txtJudulBd.setText(tempBudidaya.get(position).getJudul());
        }
        return view;
    }

    public Filter getFilter() {
        Filter filter = new Filter() {

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint, Filter.FilterResults results) {
                tempBudidaya=(ArrayList<Budidaya>)results.values;
                notifyDataSetChanged();
            }

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();
                Log.d("MainApp", "keyword : "+constraint);
                ArrayList<Budidaya> FilteredList= new ArrayList<Budidaya>();
                if (constraint == null || constraint.length() == 0) {
                    // No filter implemented we return all the list
                    results.values = budidayas;
                    results.count = budidayas.size();
                } else {
                    for (int i = 0; i < budidayas.size(); i++) {
                        String data = budidayas.get(i).getJudul();
                        if (data.toLowerCase().contains(constraint.toString()))  {
                            FilteredList.add(budidayas.get(i));
                        }
                    }
                    results.values = FilteredList;
                    results.count = FilteredList.size();
                }
                return results;
            }
        };
        return filter;
    }
}
