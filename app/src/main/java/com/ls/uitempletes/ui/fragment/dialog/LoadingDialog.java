package com.ls.uitempletes.ui.fragment.dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import com.ls.uitempletes.R;

public class LoadingDialog extends AlertDialog {

    private AlertDialog mDialog;

    protected LoadingDialog(Context context) {
        super(context);
        initViews(context);
    }

    public void show() {
        if (mDialog != null) {
            mDialog.show();
        }
    }

    public void dismiss() {
        if (mDialog != null) {
            mDialog.dismiss();
        }
    }

    private void initViews(@NonNull Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.Dialog_Light);
        builder.setView(R.layout.view_loading);

        mDialog = builder.create();
        mDialog.setCanceledOnTouchOutside(false);
    }
}
