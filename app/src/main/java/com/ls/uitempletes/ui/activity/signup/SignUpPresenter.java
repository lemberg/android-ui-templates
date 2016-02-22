package com.ls.uitempletes.ui.activity.signup;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.ls.uitempletes.R;
import com.ls.uitempletes.utils.TextUtil;

public class SignUpPresenter {

    private static final int MIN_PASSWORD_LENGTH = 4;
    private SignUpActivity mActivity;

    public SignUpPresenter(@NonNull SignUpActivity activity) {
        mActivity = activity;
    }

    public void onSignUpClicked() {
        if (isCredentialsValid()) {

        }
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
