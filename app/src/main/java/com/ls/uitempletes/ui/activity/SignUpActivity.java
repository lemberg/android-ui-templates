package com.ls.uitempletes.ui.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.widget.EditText;
import com.ls.uitempletes.R;
import com.ls.uitempletes.ui.activity.signup.SignInActivity;

public class SignUpActivity extends AppCompatActivity {

    private TextInputLayout tilEmail;
    private EditText edtEmail;

    private TextInputLayout tilFirstName;
    private EditText edtFirstName;

    private TextInputLayout tilLastName;
    private EditText edtLastName;

    private TextInputLayout tilPassword;
    private EditText edtPassword;

    private TextInputLayout tilRepeatPassword;
    private EditText edtRepeatPassword;

    public static void start(@NonNull Activity activity) {
        Intent intent = new Intent(activity, SignUpActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_sign_up);

        initViews();
    }

    private void initViews() {
        tilEmail = (TextInputLayout) findViewById(R.id.tilEmail);
        edtEmail = (EditText) findViewById(R.id.edtEmail);

        tilFirstName = (TextInputLayout) findViewById(R.id.tilFirstName);
        edtFirstName = (EditText) findViewById(R.id.edtFirstName);

        tilLastName = (TextInputLayout) findViewById(R.id.tilLastName);
        edtLastName = (EditText) findViewById(R.id.edtLastName);

        tilPassword = (TextInputLayout) findViewById(R.id.tilPassword);
        edtPassword = (EditText) findViewById(R.id.edtPassword);

        tilRepeatPassword = (TextInputLayout) findViewById(R.id.tilRepeatPassword);
        edtRepeatPassword = (EditText) findViewById(R.id.edtRepeatPassword);
    }
}