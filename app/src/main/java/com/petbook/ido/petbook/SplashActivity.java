package com.petbook.ido.petbook;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;

public class SplashActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        for (int nIndex = 0; nIndex < 5; nIndex++)
        {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.startActivity(new Intent(getApplicationContext(), MenuActivity.class));
    }
}
