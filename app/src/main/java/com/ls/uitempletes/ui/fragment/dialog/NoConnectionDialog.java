package com.ls.uitempletes.ui.fragment.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import com.ls.uitempletes.R;
import com.ls.uitempletes.utils.IntentUtils;

public class NoConnectionDialog extends AlertDialog {

    private AlertDialog mDialog;

    protected NoConnectionDialog(Context context) {
        super(context);
        initViews(context);
    }

    public void show() {
        if (mDialog != null) {
            mDialog.show();
        }
    }

    private void initViews(@NonNull Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.Dialog_Light);
        builder.setTitle(context.getString(R.string.something_went_wrong));
        builder.setMessage(context.getString(R.string.looks_like_you_do_not_have_internet_connection));

        String correct = context.getString(R.string.correct);
        builder.setPositiveButton(correct, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                IntentUtils.openWiFiSettings(getContext());
            }
        });

        String cancel = context.getString(R.string.cancel);
        builder.setNegativeButton(cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {/*empty*/}
        });

        mDialog = builder.create();
    }
}
