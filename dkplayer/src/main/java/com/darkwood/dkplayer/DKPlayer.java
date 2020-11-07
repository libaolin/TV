package com.darkwood.dkplayer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DKPlayer extends FrameLayout {

    static {
        System.loadLibrary("jni_dkplayer");
    }

    public DKPlayer(@NonNull Context context) {
        this(context, null);
    }

    public DKPlayer(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DKPlayer(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public DKPlayer(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }


    private void init() {
        native_init();
    }

    private native void native_init();
}
