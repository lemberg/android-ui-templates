package com.ls.uitempletes.ui.views.font;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import com.ls.uitempletes.R;
import com.ls.uitempletes.utils.TypefaceHolder;

public class FontTextView extends AppCompatTextView {

    public FontTextView(Context context) {
        super(context);
    }

    public FontTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyAttributes(attrs);
    }

    public FontTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        applyAttributes(attrs);
    }

    private void applyAttributes(AttributeSet attrs) {
        if (!isInEditMode()) {
            TypedArray array = getContext().obtainStyledAttributes(attrs, R.styleable.FontTextView);
            String font = array.getString(R.styleable.FontTextView_customFont);
            if (font != null) {
                setTypeface(font);
            }
            array.recycle();
        }
    }

    public void setTypeface(final String theName) {
        this.setTypeface(TypefaceHolder.getTypeface(getContext(), theName));
    }

    public void setTypeface(final String theName, int theStyle) {
        this.setTypeface(TypefaceHolder.getTypeface(getContext(), theName), theStyle);
    }

    public void setTypeface(int theNameResId) {
        this.setTypeface(TypefaceHolder.getTypeface(getContext(), theNameResId));
    }

    public void setTypeface(int theNameResId, int theStyle) {
        this.setTypeface(TypefaceHolder.getTypeface(getContext(), theNameResId), theStyle);
    }
}
