package com.man.fapp.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.man.fapp.R;

import java.util.List;

public class crop_list_adapter extends ArrayAdapter<String> {
        Activity context;
        String[] crops;
        int[] cropImages;

    public crop_list_adapter(@NonNull Activity context,String[] crops, int[] cropImages) {
        super(context, R.layout.infromation_item_list, crops);
        this.context = context;
        this.crops = crops;
        this.cropImages = cropImages;
    }
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.infromation_item_list, null, true);
        TextView txtTitle = rowView.findViewById(R.id.txt);
        ImageView imageView = rowView.findViewById(R.id.img);
        txtTitle.setText(crops[position]);
        imageView.setImageResource(cropImages[position]);
        return rowView;
    }
}
