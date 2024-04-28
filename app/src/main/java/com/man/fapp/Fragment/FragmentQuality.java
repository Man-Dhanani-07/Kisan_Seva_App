package com.man.fapp.Fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.man.fapp.QualityTestResult;
import com.man.fapp.R;

import org.checkerframework.checker.units.qual.A;

public class FragmentQuality extends Fragment implements AdapterView.OnItemSelectedListener {

    private static final int PICK_IMAGE_REQUEST = 1;
    EditText etCategory;
    ImageView imagebtn;
    Button submitbtn;
    Uri imageUri;
    TextView tvMessage;
    ProgressBar progressBar;
    Spinner spinner;

    ActivityResultLauncher<String> mtakephoto;

    public FragmentQuality() {
        // Required empty public constructor
    }
String [] category;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_quality, container, false);

        category = new String[]{"Select Category","Wheat","Rice","Other"};
//        etCategory = v.findViewById(R.id.et_title);
        submitbtn = v.findViewById(R.id.submitPost);
        tvMessage = v.findViewById(R.id.tvMessage);
         spinner = v.findViewById(R.id.spinner_category);
        progressBar = v.findViewById(R.id.pb_testing);

        spinner.setOnItemSelectedListener(this);

        ArrayAdapter<String> aa =  new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1,category);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(aa);

        imagebtn = v.findViewById(R.id.imageButton);
        imagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mtakephoto.launch("image/*");
            }
        });
        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    connectToServer();
            }
        });
        mtakephoto = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
            @Override
            public void onActivityResult(Uri o) {
                imagebtn.setImageURI(o);
                imageUri = o;
            }
        });
        return v;
    }
    @SuppressLint("SetTextI18n")
    private void connectToServer() {
        tvMessage.setVisibility(View.VISIBLE);
        tvMessage.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            tvMessage.setTextColor(getResources().getColor(R.color.green_light));
            tvMessage.setText("Uploading... Please wait!");
            progressBar.setVisibility(View.VISIBLE);
            submitbtn.setVisibility(View.GONE);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    progressBar.setVisibility(View.GONE);
                    submitbtn.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(getContext(), QualityTestResult.class);
                    intent.putExtra("category", spinner.getSelectedItem().toString());
                    startActivity(intent);

                }
            },0000);
        FragmentManager fm = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.content, new Item_list());
        ft.commit();
        }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}