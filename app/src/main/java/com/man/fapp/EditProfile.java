package com.man.fapp;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.man.fapp.Fragment.FragmentProfile;

public class EditProfile extends AppCompatActivity {

    ImageView editimage;
    EditText editName;
    Button updateprofilebtn;
    ActivityResultLauncher<String> mtakephoto;
    Uri imageUri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        editimage = findViewById(R.id.editimage);
        editName  =findViewById(R.id.editname);
        updateprofilebtn = findViewById(R.id.updateprofilebtn);
        mtakephoto = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
            @Override
            public void onActivityResult(Uri o) {
               editimage.setImageURI(o);
                imageUri = o;
            }
        });
        editimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mtakephoto.launch("image/*");
            }
        });
        updateprofilebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString().trim();
                Intent i = new Intent(EditProfile.this, FragmentProfile.class);
                i.putExtra("name",name);
                if (imageUri!=null){
                    i.setData(imageUri);
                }
                startActivity(i);
            }
        });
    }
}