package com.man.fapp;

import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.man.fapp.Adapter.Logistic_Adapter;
import com.man.fapp.Model.LogisticInfo;

import java.util.ArrayList;

public class Logistic_info extends AppCompatActivity {
    private ArrayList<LogisticInfo> logList;
    private Logistic_Adapter logAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logistic_info);

        initRecyclerView();
        initData();
    }

    private void initData() {
        logAdapter = new Logistic_Adapter(logList, this);
       RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(logAdapter);
    }

    private void initRecyclerView() {

        logList = new ArrayList<>();
        logList.add(new LogisticInfo(getString(R.string.rivigo), "relay.rivigo.com", getString(R.string.rivigo_desc)));
        logList.add(new LogisticInfo(getString(R.string.truck_suvidha), " www.trucksuvidha.com", getString(R.string.truck_suvidha_desc)));
        logList.add(new LogisticInfo(getString(R.string.transin_logistics), "www.transin.in", getString(R.string.Transin_Logistics_desc)));
        logList.add(new LogisticInfo(getString(R.string.truck_guru), "www.truckguru.co.in", getString(R.string.truck_guru_desc)));
        logList.add(new LogisticInfo(getString(R.string.elasctic_run), "www.elastic.run", getString(R.string.Elasctic_Run_desc)));
        logList.add(new LogisticInfo(getString(R.string.blackBuck), "www.blackbuck.com", getString(R.string.BlackBuck_desc)));
        logList.add(new LogisticInfo(getString(R.string.Mavyn), "www.mavyn.in", getString(R.string.Mavyn_desc)));
        logList.add(new LogisticInfo(getString(R.string.Jusdac_India_desc), "www.jusdaindia.com", getString(R.string.Jusdac_india_desc)));
        logList.add(new LogisticInfo(getString(R.string.eParivahan), "www.eparivahan.com", getString(R.string.eParivahan_desc)));


    }
}