package com.ls.uitempletes.ui.activity.signup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import com.ls.uitempletes.R;

public class SignUpActivity extends AppCompatActivity {

    private TextInputLayout mTilEmail;
    private EditText mEdtEmail;

    private TextInputLayout mTilFullName;
    private EditText mEdtFullName;

    private TextInputLayout mTilPassword;
    private EditText mEdtPassword;

    private TextInputLayout mTilRepeatPassword;
    private EditText mEdtRepeatPassword;

    private SignUpPresenter mPresenter;

    public static void start(@NonNull Activity activity) {
        Intent intent = new Intent(activity, SignUpActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_sign_up);
        mPresenter = new SignUpPresenter(this);

        initActionBar();
        initViews();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
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
    public String getFullName() {
        if (mEdtFullName != null) {
            return mEdtFullName.getText().toString().trim();
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

    @NonNull
    public String getRepeatPassword() {
        if (mEdtRepeatPassword != null) {
            return mEdtRepeatPassword.getText().toString().trim();
        } else {
            return "";
        }
    }

    public void setEmailError(@Nullable String error) {
        if (mTilEmail != null) {
            mTilEmail.setError(error);
        }
    }

    public void setFullNameError(@Nullable String error) {
        if (mTilFullName != null) {
            mTilFullName.setError(error);
        }
    }

    public void setPasswordError(@Nullable String error) {
        if (mTilPassword != null) {
            mTilPassword.setError(error);
        }
    }

    public void setRepeatPasswordError(@Nullable String error) {
        if (mTilRepeatPassword != null) {
            mTilRepeatPassword.setError(error);
        }
    }

    private void initActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getString(R.string.sign_up));
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void initViews() {
        mTilEmail = (TextInputLayout) findViewById(R.id.tilEmail);
        mEdtEmail = (EditText) findViewById(R.id.edtEmail);

        mTilFullName = (TextInputLayout) findViewById(R.id.filFullName);
        mEdtFullName = (EditText) findViewById(R.id.edtFullName);

        mTilPassword = (TextInputLayout) findViewById(R.id.tilPassword);
        mEdtPassword = (EditText) findViewById(R.id.edtPassword);

        mTilRepeatPassword = (TextInputLayout) findViewById(R.id.tilRepeatPassword);
        mEdtRepeatPassword = (EditText) findViewById(R.id.edtRepeatPassword);

        findViewById(R.id.btnSignUp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.onSignUpClicked();
            }
        });
    }
}