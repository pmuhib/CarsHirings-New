package com.carshiring.activities.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.carshiring.R;
import com.carshiring.utilities.AppBaseActivity;

public class LoginActivity extends AppBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void skipLogin(View view) {
    }
}