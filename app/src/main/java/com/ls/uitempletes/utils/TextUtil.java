package com.ls.uitempletes.utils;

import android.support.annotation.NonNull;
import android.text.TextUtils;

public class TextUtil {

    public static boolean isEmailValid(@NonNull String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
