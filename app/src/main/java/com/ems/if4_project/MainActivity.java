package com.ems.if4_project;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;

import com.ems.if4_project.gestion.ListAllActivity;
import com.ems.if4_project.gestion.Login;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btMainList,btMainConnect;
    LinearLayout ll_welcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btMainList=(Button)findViewById(R.id.btMainList);
        btMainConnect=(Button)findViewById(R.id.btMainConnect);
        ll_welcome=(LinearLayout)findViewById(R.id.ll_welcome);

        btMainList.setOnClickListener(this);
        btMainConnect.setOnClickListener(this);

        ll_welcome.animate().translationY(0)
                .setInterpolator(new DecelerateInterpolator())
                .setDuration(900)
                .start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btMainConnect:
                Intent intent=new Intent(getApplicationContext(), Login.class);
                startActivity(intent);

                break;
            case R.id.btMainList:
                Intent readOnly=new Intent(getApplicationContext(), ListAllActivity.class);
                startActivity(readOnly);

                break;

        }
    }



}