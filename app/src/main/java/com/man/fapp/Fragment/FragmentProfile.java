package com.man.fapp.Fragment;

import static android.content.Intent.getIntent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.man.fapp.ActivityAboutUs;
import com.man.fapp.EditProfile;
import com.man.fapp.Logistic_info;
import com.man.fapp.R;


public class FragmentProfile extends Fragment {

    public FragmentProfile() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        Intent intent = getActivity().getIntent();

        ImageView imageView = v.findViewById(R.id.ivProfileImage);
        imageView.setImageURI(intent.getData());
//        String name = intent.getStringExtra("name");
//
//        TextView textViewName = v.findViewById(R.id.tv_name);
//        textViewName.setText(name);

        v.findViewById(R.id.cv_logistics).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), Logistic_info.class);
                startActivity(i);
            }
        });
        v.findViewById(R.id.editprofile).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), EditProfile.class);
                startActivity(i);
            }
        });
        v.findViewById(R.id.aboutuss).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i  = new Intent(getActivity(), ActivityAboutUs.class);

                startActivity(i);
            }
        });
        return v;
    }

}