package com.roqua;

import android.os.Bundle;

import static com.roqua.HelperMethod.ReplaceFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme2);
        setContentView(R.layout.activity_main);
        ReplaceFragment( getSupportFragmentManager(), new MainFragment(), R.id.container
            , null, "");
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}