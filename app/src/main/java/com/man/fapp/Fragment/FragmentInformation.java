package com.man.fapp.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.man.fapp.Adapter.crop_list_adapter;
import com.man.fapp.CropDetailActivity;
import com.man.fapp.R;


public class FragmentInformation extends Fragment {
    String[] crops = {"Wheat", "Rice", "Corn", "Potato", "Tomato"};
    int[] cropImages = {R.drawable.wheat1, R.drawable.rice, R.drawable.corn, R.drawable.potato, R.drawable.tomato};
    ListView listView;


    public FragmentInformation() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_information, container, false);
        listView = view.findViewById(R.id.listView);
        crop_list_adapter adapter = new crop_list_adapter(requireActivity(), crops, cropImages);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedCrop = crops[position];
                int selectedImage = cropImages[position];
                Intent intent = new Intent(getActivity(), CropDetailActivity.class);
                intent.putExtra("crop", selectedCrop);
                intent.putExtra("image", selectedImage);
                startActivity(intent);
            }
        });
        return view;
    }
}