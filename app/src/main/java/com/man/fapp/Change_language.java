package com.man.fapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Change_language extends AppCompatActivity {

    TextView dialog_language;
    int lan_selected;
    RelativeLayout show_lan_dialog;
    Context context;
    Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_language);

        dialog_language=(TextView) findViewById(R.id.dialog_language);
        show_lan_dialog = (RelativeLayout) findViewById(R.id.showlangdialog);

        if(LocaleHelper.getLanguage(Change_language.this).equalsIgnoreCase("en")){
            context = LocaleHelper.setLocale(Change_language.this,"en");
            resources = context.getResources();
            lan_selected = 0;
            dialog_language.setText("ENGLISH");
            setTitle(resources.getString(R.string.app_name));
        }
        else if (LocaleHelper.getLanguage(Change_language.this).equalsIgnoreCase("gu")){
            context = LocaleHelper.setLocale(Change_language.this,"gu");
            resources = context.getResources();
            lan_selected = 1;
            dialog_language.setText("ગુજરાતી");
            setTitle(resources.getString(R.string.app_name));
        }

        show_lan_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] Language = {"ENGLISH","हिंदी","ગુજરાતી"};
                    final AlertDialog.Builder builder = new AlertDialog.Builder(Change_language.this);
                    builder.setTitle("Select A Language")
                            .setSingleChoiceItems(Language, lan_selected, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog_language.setText(Language[which]);

                                    if(Language[which].equals("ENGLISH")){
                                    context = LocaleHelper.setLocale(Change_language.this,"en");
                                    resources = context.getResources();
                                    lan_selected = 0;
                                    setTitle(resources.getString(R.string.app_name));
                                    }
                                else if(Language[which].equals("ગુજરાતી")){
                                      context = LocaleHelper.setLocale(Change_language.this,"gu");
                                      resources = context.getResources();
                                      lan_selected = 1;
                                      setTitle(resources.getString(R.string.app_name));
                                  }
//                                  if(Language[which].equals("ગુજરાતી")){
//                                      context = LocaleHelper.setLocale(Change_language.this,"guj");
//                                      resources = context.getResources();
//                                      lan_selected = 0;
//                                      setTitle(resources.getString(R.string.app_name));
//
//                                  }
                                }
                            }).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                    Intent i = new Intent(Change_language.this,MainActivity.class);
                                    startActivity(i);
                                }
                            });
                    builder.create().show();

            }
        });


    }
}