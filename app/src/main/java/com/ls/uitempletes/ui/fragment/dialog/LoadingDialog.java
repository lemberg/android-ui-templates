package com.ls.uitempletes.ui.fragment.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.TextView;
import com.ls.uitempletes.R;

public class LoadingDialog extends AlertDialog {

    private AlertDialog mDialog;

    protected LoadingDialog(@NonNull Context context, @NonNull String message) {
        super(context);
        initViews(context, message);
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

    private void initViews(@NonNull Context context, @NonNull String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.Dialog_Light);

        @SuppressLint("InflateParams")
        View view = getLayoutInflater().inflate(R.layout.view_loading, null);
        TextView txtMessage = (TextView) view.findViewById(R.id.txtMessage);
        txtMessage.setText(message);

        builder.setView(view);
        mDialog = builder.create();
        mDialog.setCanceledOnTouchOutside(false);
    }
}
