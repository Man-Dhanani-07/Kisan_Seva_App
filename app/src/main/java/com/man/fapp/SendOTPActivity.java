package com.man.fapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.Firebase;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class SendOTPActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallback;

    ProgressBar progressBar;
    Button buttonGetOTP;
     EditText inputMobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_otpactivity);

        inputMobile = findViewById(R.id.inputMobile);
        buttonGetOTP = findViewById(R.id.buttonGetOTP);
        mAuth = FirebaseAuth.getInstance();

        progressBar = findViewById(R.id.progressBar);

        buttonGetOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inputMobile.getText().toString().trim().isEmpty()) {
                    Toast.makeText(SendOTPActivity.this, "Invalid Phone Number", Toast.LENGTH_SHORT).show();
                    return;
                } else if (inputMobile.getText().toString().trim().length() != 10) {
                    Toast.makeText(SendOTPActivity.this, "Type Valid Phone Number", Toast.LENGTH_SHORT).show();
                } else {
                    otpSend();
                }
            }
        });
    }
    private void otpSend() {

        progressBar.setVisibility(View.VISIBLE);
        buttonGetOTP.setVisibility(View.INVISIBLE);
            mCallback = new PhoneAuthProvider.OnVerificationStateChangedCallbacks(){

                @Override
                public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                    progressBar.setVisibility(View.GONE);
//                    progressBar.setVisibility(View.VISIBLE);
                }

                @Override
                public void onVerificationFailed(@NonNull FirebaseException e) {
                progressBar.setVisibility(View.GONE);
                progressBar.setVisibility(View.VISIBLE);
                buttonGetOTP.setEnabled(true);
                Toast.makeText(SendOTPActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
//                progressBar.setVisibility(View.GONE);
                }

                @Override
                public void onCodeSent(@NonNull String verificationId, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                   progressBar.setVisibility(View.GONE);
                   progressBar.setVisibility(View.VISIBLE);
                    buttonGetOTP.setEnabled(true);
                    Toast.makeText(SendOTPActivity.this,"OTP is successfully send to this mobile number",Toast.LENGTH_SHORT).show();
                   Intent intent = new Intent(SendOTPActivity.this, VerifyOTPActivity.class);
                   intent.putExtra("mobile",inputMobile.getText().toString().trim());
                   intent.putExtra("verificationId",verificationId);
                   startActivity(intent);
                }
            };
            PhoneAuthOptions options = PhoneAuthOptions.newBuilder(mAuth)
                    .setPhoneNumber("+91" + inputMobile.getText().toString().trim())
                    .setTimeout(60L,TimeUnit.SECONDS)
                    .setActivity(this)
                    .setCallbacks(mCallback)
                    .build();
            PhoneAuthProvider.verifyPhoneNumber(options);
    }
}