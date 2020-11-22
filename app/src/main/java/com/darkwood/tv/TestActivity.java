package com.darkwood.tv;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.darkwood.dkplayer.DKPlayer;

public class TestActivity extends AppCompatActivity {
    private DKPlayer mDKPlayer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        mDKPlayer = findViewById(R.id.dkplayer);
    }
}
