package com.example.lab2;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

/*
 * Main Activity class that loads {@link MainFragment2}.
 */
public class fpeach extends FragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fpeach);
        /*if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_browse_fragment, new MainFragment2())
                    .commitNow();
        }*/
    }
}