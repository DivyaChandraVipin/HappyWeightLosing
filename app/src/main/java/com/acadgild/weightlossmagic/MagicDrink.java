package com.acadgild.weightlossmagic;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

/**
 * Created by DivyaVipin on 1/22/2017.
 */

public class MagicDrink extends AppCompatActivity {
    TextView txtContent;
    Toolbar toolbar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.magic_drink);
        toolbar=(Toolbar)findViewById(R.id.toolbar) ;
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        txtContent=(TextView)findViewById(R.id.txtViewContent) ;
        Typeface font_content = Typeface.createFromAsset(getAssets(), "DroidSerif-Italic.ttf");
        txtContent.setTypeface(font_content);
    }
}
