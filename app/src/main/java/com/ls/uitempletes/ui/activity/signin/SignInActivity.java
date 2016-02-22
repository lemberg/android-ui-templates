package com.ls.uitempletes.ui.activity.signin;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.ls.uitempletes.R;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {

    private TextInputLayout mTilEmail;
    private EditText mEdtEmail;

    private TextInputLayout mTilPassword;
    private EditText mEdtPassword;

    private SignInPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_sign_in);
        mPresenter = new SignInPresenter(this);

        initActionBar();
        initViews();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {

            case R.id.btnSignIn:
                mPresenter.onSignInClicked();
                break;

            case R.id.btnResetPassword:
                mPresenter.onResetPasswordClicked();
                break;

            case R.id.viewSignUp:
                mPresenter.onSignUpClicked();
                break;
        }
    }

    @NonNull
    public String getEmail() {
        if (mEdtEmail != null) {
            return mEdtEmail.getText().toString().trim();
        } else {
            return "";
        }
    }

    @NonNull
    public String getPassword() {
        if (mEdtPassword != null) {
            return mEdtPassword.getText().toString().trim();
        } else {
            return "";
        }
    }

    public void setEmailError(@Nullable String errorText) {
        if (mTilEmail != null) {
            mTilEmail.setError(errorText);
        }
    }

    public void setPasswordError(@Nullable String errorText) {
        if (mTilPassword != null) {
            mTilPassword.setError(errorText);
        }
    }

    private void initActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getString(R.string.sign_in));
        }
    }

    private void initViews() {
        mTilEmail = (TextInputLayout) findViewById(R.id.tilEmail);
        mEdtEmail = (EditText) findViewById(R.id.edtEmail);

        mTilPassword = (TextInputLayout) findViewById(R.id.tilPassword);
        mEdtPassword = (EditText) findViewById(R.id.edtPassword);

        Button btnSignIn = (Button) findViewById(R.id.btnSignIn);
        btnSignIn.setOnClickListener(this);

        Button btnResetPassword = (Button) findViewById(R.id.btnResetPassword);
        btnResetPassword.setOnClickListener(this);

        LinearLayout viewSignUp = (LinearLayout) findViewById(R.id.viewSignUp);
        viewSignUp.setOnClickListener(this);
    }
}
