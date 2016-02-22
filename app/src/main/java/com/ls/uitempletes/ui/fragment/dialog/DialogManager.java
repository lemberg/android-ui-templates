package com.ls.uitempletes.ui.fragment.dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import com.ls.uitempletes.R;

public class DialogManager {

    @NonNull
    public static AlertDialog showNoConnectionDialog(@NonNull Context context) {
        NoConnectionDialog dialog = new NoConnectionDialog(context);
        dialog.show();
        return dialog;
    }
}
