package com.man.fapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ActivityAboutUs extends AppCompatActivity {
    private String[] names = new String[]{"Man Dhanani"};
    private String[] collage = new String[]{"VGEC"};
    private int[] images = new int[]{R.drawable.buss_man};

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        listView = findViewById(R.id.listView);
        List<HashMap<String, String>> aList = new ArrayList<>();
        for (int x = 0; x < names.length; x++) {
            HashMap<String, String> hm = new HashMap<>();
            hm.put("Name", names[x]);
            hm.put("collage", collage[x]);
            hm.put("Image", Integer.toString(images[x]));
            aList.add(hm);
        }
        String[] from = {"Image", "Name","collage"};
        int[] to = {R.id.memberimage, R.id.name,R.id.collagename};
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, aList, R.layout.activity_team_details, from, to);
        listView.setAdapter(simpleAdapter);
    }
}