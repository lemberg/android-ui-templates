package com.ls.uitempletes.ui.fragment.dialog;

import android.content.Context;
import android.support.annotation.NonNull;

public class DialogManager {

    @NonNull
    public static NoConnectionDialog showNoConnectionDialog(@NonNull Context context) {
        NoConnectionDialog dialog = new NoConnectionDialog(context);
        dialog.show();
        return dialog;
    }

    @NonNull
    public static LoadingDialog showLoadingDialog(@NonNull Context context, @NonNull String message) {
        LoadingDialog dialog = new LoadingDialog(context, message);
        dialog.show();
        return dialog;
    }
}
