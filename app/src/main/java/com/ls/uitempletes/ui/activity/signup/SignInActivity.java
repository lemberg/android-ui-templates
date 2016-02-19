package com.ls.uitempletes.ui.activity.signup;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.ls.uitempletes.R;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {

    private TextInputLayout tilEmail;
    private EditText mEdtEmail;

    private TextInputLayout tilPassword;
    private EditText mEdtPassword;

    private Button mBtnSignIn;
    private Button mBtnResetPassword;
    private LinearLayout mViewSignUp;

    private SignInPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_sign_in);
        mPresenter = new SignInPresenter(this);

        initViews();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {

            case R.id.btnSignIn:

                break;

            case R.id.btnResetPassword:
                mPresenter.onResetPasswordClicked();
                break;

            case R.id.viewSignUp:
                mPresenter.onSignUpClicked();
                break;
        }
    }

    private void initViews() {
        tilEmail = (TextInputLayout) findViewById(R.id.tilEmail);
        mEdtEmail = (EditText) findViewById(R.id.edtEmail);

        tilPassword = (TextInputLayout) findViewById(R.id.tilPassword);
        mEdtPassword = (EditText) findViewById(R.id.edtPassword);

        mBtnSignIn = (Button) findViewById(R.id.btnSignIn);
        mBtnSignIn.setOnClickListener(this);

        mBtnResetPassword = (Button) findViewById(R.id.btnResetPassword);
        mBtnResetPassword.setOnClickListener(this);

        mViewSignUp = (LinearLayout) findViewById(R.id.viewSignUp);
        mViewSignUp.setOnClickListener(this);
    }
}
