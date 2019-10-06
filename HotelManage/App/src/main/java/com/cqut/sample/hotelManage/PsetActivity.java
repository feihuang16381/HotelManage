package com.cqut.sample.hotelManage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.cqut.sample.R;

public class PsetActivity extends AppCompatActivity {
LinearLayout AccountandSecurity;
LinearLayout feedback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setup);
        initview();

    }
    public void initview( ){
        AccountandSecurity = findViewById(R.id.AccountandSecurity);
        feedback = findViewById(R.id.feedback);
        AccountandSecurity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PsetActivity.this, AccountandSecurityActivity.class);
                startActivity(intent);
            }
        });
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PsetActivity.this, FeedBackActivity.class);
                startActivity(intent);
            }
        });
    }
}
