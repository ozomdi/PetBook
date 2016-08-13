package com.petbook.ido.petbook;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;

/**
 * Created by Omri on 13/08/2016.
 */
public class Popup extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int nWidth = dm.widthPixels;
        int nHeight = dm.heightPixels;

        getWindow().setLayout((int)(nWidth * .3 ), (int)(nHeight * .2));
    }
}