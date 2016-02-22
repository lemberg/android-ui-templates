package com.ls.uitempletes.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.widget.Toast;
import com.ls.uitempletes.R;
import com.ls.uitempletes.model.networking.url.UrlFactory;

public class IntentUtils {

    public static void openUrl(@NonNull Context context, @NonNull String url) {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            context.startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(context, R.string.no_default_browser_found, Toast.LENGTH_SHORT).show();
        }
    }

    public static void openWiFiSettings(@NonNull Context context) {
        Intent intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
