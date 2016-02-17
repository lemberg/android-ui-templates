package com.ls.uitempletes.ui.views.font;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.ls.uitempletes.R;
import com.ls.uitempletes.utils.TypefaceHolder;

public class FontEditText extends AppCompatEditText {

    public FontEditText(Context context) {
        super(context);
    }

    public FontEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyAttributes(attrs);
    }

    public FontEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        applyAttributes(attrs);
    }

    private void applyAttributes(AttributeSet attrs) {
        initFont(attrs);
    }

    private void initFont(AttributeSet attrs) {
        TypedArray array = getContext().obtainStyledAttributes(attrs, R.styleable.FontTextView);
        if (!isInEditMode()) {
            String font = array.getString(R.styleable.FontTextView_customFont);
            if (font != null) {
                setTypeface(font);
            }
        }
        array.recycle();
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

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:
                setError(null);
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public void onEditorAction(int actionCode) {
        setError(null);
        super.onEditorAction(actionCode);
    }

    @Override
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        InputConnection conn = super.onCreateInputConnection(outAttrs);
        outAttrs.imeOptions &= ~EditorInfo.IME_FLAG_NO_ENTER_ACTION;
        return conn;
    }
}

