package com.ems.if4_project.gestion;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;

import com.ems.if4_project.MainActivity;
import com.ems.if4_project.R;

public class Home extends AppCompatActivity {
    Button logout,insert,viewall;
    LinearLayout ll_admin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
        getSupportActionBar().setTitle("CRUD BD SQLite - administration");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        logout=(Button)findViewById(R.id.btMaindeconnect);
        insert=(Button)findViewById(R.id.bt_add);

        viewall=(Button)findViewById(R.id.btMainList);
        ll_admin=(LinearLayout)findViewById(R.id.ll_admin);
        ll_admin.animate().translationY(0)
                .setInterpolator(new DecelerateInterpolator())
                .setDuration(900)
                .start();
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Home.this);
                builder.setCancelable(true);
                builder.setTitle("Déconnexion");
                builder.setMessage("Voulez vous Déconnecter !");
                builder.setPositiveButton("Déconnecter",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                                finish();

                            }
                        });

                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();


            }
        });
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), Insert.class);
                startActivity(intent);
            }
        });

        viewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), ListAll.class);
                startActivity(intent);
            }
        });
    }
}