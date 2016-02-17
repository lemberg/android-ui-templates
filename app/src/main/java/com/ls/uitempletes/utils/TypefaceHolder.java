package com.ls.uitempletes.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.StringRes;

import java.util.HashMap;
import java.util.Map;

public class TypefaceHolder {

    private final static Map<String, Typeface> sFontsMap = new HashMap<>();

    private static String getFontPath(String fontName) {
        return "fonts/" + fontName;
    }

    public static Typeface getTypeface(Context context, String fontName) {
        Typeface typeface;
        typeface = sFontsMap.get(fontName);
        if (typeface == null) {
            typeface = Typeface.createFromAsset(context.getAssets(), getFontPath(fontName));
            sFontsMap.put(fontName, typeface);
        }

        return typeface;
    }

    public static Typeface getTypeface(Context context, @StringRes int fontNameId) {
        return getTypeface(context, context.getResources().getString(fontNameId));
    }
}
