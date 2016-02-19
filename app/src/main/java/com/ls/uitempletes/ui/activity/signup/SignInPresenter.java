package com.ls.uitempletes.ui.activity.signup;

import android.support.annotation.NonNull;
import com.ls.uitempletes.ui.activity.SignUpActivity;

public class SignInPresenter {

    private SignInActivity mActivity;

    public SignInPresenter(@NonNull SignInActivity activity) {
        mActivity = activity;
    }

    public void onSignUpClicked() {
        SignUpActivity.start(mActivity);
    }

    public void onResetPasswordClicked() {
        //TODO implement password reset
    }

    public void onSignInClicked() {

    }
}
