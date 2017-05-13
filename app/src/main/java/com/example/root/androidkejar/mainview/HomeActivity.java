package com.example.root.androidkejar.mainview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.root.androidkejar.R;

public class HomeActivity extends AppCompatActivity {

    private TextView mTxtUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mTxtUsername = (TextView)findViewById(R.id.txt_username);

        Intent mIntent = getIntent();
        String username = mIntent.getStringExtra("username");
        mTxtUsername.setText(username);
    }
}
