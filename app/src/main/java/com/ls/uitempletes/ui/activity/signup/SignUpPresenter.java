package com.ls.uitempletes.ui.activity.signup;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.ls.uitempletes.R;
import com.ls.uitempletes.ui.activity.home.HomeActivity;
import com.ls.uitempletes.ui.fragment.dialog.DialogManager;
import com.ls.uitempletes.utils.NetworkUtils;
import com.ls.uitempletes.utils.TextUtil;

public class SignUpPresenter {

    private static final int MIN_PASSWORD_LENGTH = 4;
    private static final int SIGN_UP_DURATION = 3000;

    private Handler mHandler = new Handler(Looper.myLooper());
    private SignUpActivity mActivity;

    public SignUpPresenter(@NonNull SignUpActivity activity) {
        mActivity = activity;
    }

    public void onDestroy() {
        if (mHandler != null) {
            mHandler.removeCallbacksAndMessages(null);
        }
    }

    public void onSignUpClicked() {
        if (isCredentialsValid() && isNetworkAvailable()) {
            performSignUp();
        }
    }

    private void performSignUp() {
        //TODO perform sign up request here
        mActivity.displayLoadingDialog();

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                onSignUpSuccessful();
            }

        }, SIGN_UP_DURATION);
    }

    private void onSignUpSuccessful() {
        mActivity.hideLoadingDialog();
        mActivity.setResult(Activity.RESULT_OK);
        mActivity.finish();

        HomeActivity.start(mActivity);
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

    private boolean isCredentialsValid() {
        String emailError = getEmailError();
        mActivity.setEmailError(emailError);

        String fullNameError = getFullNameError();
        mActivity.setFullNameError(fullNameError);

        String passwordError = getPasswordError();
        mActivity.setPasswordError(passwordError);

        String repeatPasswordError = getRepeatPasswordError();
        mActivity.setRepeatPasswordError(repeatPasswordError);

        boolean isValid = emailError == null &&
                fullNameError == null &&
                passwordError == null &&
                repeatPasswordError == null;

        return isValid;
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

    @Nullable
    private String getFullNameError() {
        String fullName = mActivity.getFullName();
        String fullNameError = null;

        if (fullName.isEmpty()) {
            fullNameError = mActivity.getString(R.string.can_not_be_empty);
        }

        return fullNameError;
    }

    @Nullable
    private String getRepeatPasswordError() {
        String repeatPassword = mActivity.getRepeatPassword();
        String password = mActivity.getPassword();
        String passwordError = null;

        if (repeatPassword.isEmpty()) {
            passwordError = mActivity.getString(R.string.can_not_be_empty);
        } else if (!repeatPassword.equals(password)) {
            passwordError = mActivity.getString(R.string.passwords_does_not_match);
        }

        return passwordError;
    }
}
