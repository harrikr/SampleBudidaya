package com.handsome.budidaya.views.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.handsome.budidaya.R;
import com.handsome.budidaya.helpers.SQLiteHelper;
import com.handsome.budidaya.views.activities.DetailBDActivity;
import com.handsome.budidaya.views.adapters.BudidayaItemAdapter;

/**
 * Created by handsome on 11/12/17.
 */
public class BudidayaFragment extends Fragment {
    private ListView listBudidaya;
    private BudidayaItemAdapter hia;
    private EditText txtSearch;

    public static BudidayaFragment newInstance(String kategori){
        BudidayaFragment fragment = new BudidayaFragment();
        Bundle bundle = new Bundle();
        bundle.putString("kategori", kategori);
        fragment.setArguments(bundle);

        return fragment;
    }

    public BudidayaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_budidaya, container, false);
        listBudidaya = (ListView)view.findViewById(R.id.listBudidaya);
        txtSearch = (EditText)view.findViewById(R.id.txtCariBd);
        setupData();
        return view;
    }
    
    private void setupData(){
        hia = new BudidayaItemAdapter(getActivity(), SQLiteHelper.getInstance(getActivity()).getBudidayas(getArguments().getString("kategori")));
        listBudidaya.setAdapter(hia);
        listBudidaya.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("MainApp","Pos : " + position + " id : " + id);
                Intent i = new Intent(getActivity(), DetailBDActivity.class);
                i.putExtra("id_rs", ++position);
                startActivity(i);
            }
        });
        txtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                hia.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

}
