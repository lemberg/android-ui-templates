package com.ls.uitempletes.ui.activity.signin;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import com.ls.uitempletes.R;
import com.ls.uitempletes.model.networking.url.UrlFactory;
import com.ls.uitempletes.ui.activity.home.HomeActivity;
import com.ls.uitempletes.ui.activity.signup.SignUpActivity;
import com.ls.uitempletes.ui.fragment.dialog.DialogManager;
import com.ls.uitempletes.ui.fragment.dialog.LoadingDialog;
import com.ls.uitempletes.utils.IntentUtils;
import com.ls.uitempletes.utils.NetworkUtils;
import com.ls.uitempletes.utils.TextUtil;

public class SignInPresenter {

    private static final int MIN_PASSWORD_LENGTH = 4;
    private static final int SIGN_IN_DURATION = 3000;

    private Handler mHandler = new Handler(Looper.myLooper());
    private SignInActivity mActivity;

    public SignInPresenter(@NonNull SignInActivity activity) {
        mActivity = activity;
    }

    public void onDestroy() {
        if (mHandler != null) {
            mHandler.removeCallbacksAndMessages(null);
        }
    }

    public void onActivityResult(int requestCode, int resultCode) {
        if (requestCode == SignUpActivity.REQUEST_CODE_SIGN_UP && resultCode == Activity.RESULT_OK) {
            mActivity.finish();
        }
    }

    public void onSignUpClicked() {
        SignUpActivity.startForResult(mActivity);
    }

    public void onResetPasswordClicked() {
        IntentUtils.openUrl(mActivity, UrlFactory.RESTORE_PASSWORD_URL);
    }

    public void onSignInClicked() {
        if (isCredentialsValid() && isNetworkAvailable()) {
            performSignIn();
        }
    }

    private boolean isCredentialsValid() {
        String emailError = getEmailError();
        mActivity.setEmailError(emailError);

        String passwordError = getPasswordError();
        mActivity.setPasswordError(passwordError);

        return emailError == null && passwordError == null;
    }

    private boolean isNetworkAvailable() {
        boolean isAvailable = false;
        if (!NetworkUtils.isOn(mActivity)) {
            DialogManager.showNoConnectionDialog(mActivity);
        } else {
            isAvailable = true;
        }

        return isAvailable;
    }

    private void performSignIn() {
        //TODO perform sign in request here

        mActivity.displayLoadingDialog();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                onSignInSuccessful();
            }
        }, SIGN_IN_DURATION);
    }

    private void onSignInSuccessful() {
        mActivity.hideLoadingDialog();
        mActivity.finish();
        HomeActivity.start(mActivity);
    }

    @Nullable
    private String getEmailError() {
        String email = mActivity.getEmail();
        String emailError = null;

        if (email.isEmpty()) {
            emailError = mActivity.getString(R.string.can_not_be_empty);
        } else if (!TextUtil.isEmailValid(email)) {
            emailError = mActivity.getString(R.string.email_is_not_valid);
        }

        return emailError;
    }

    @Nullable
    private String getPasswordError() {
        String password = mActivity.getPassword();
        String passwordError = null;

        if (password.isEmpty()) {
            passwordError = mActivity.getString(R.string.can_not_be_empty);
        } else if (password.length() < MIN_PASSWORD_LENGTH) {
            passwordError = mActivity.getString(R.string.password_is_not_valid);
        }
        return passwordError;
    }
}
