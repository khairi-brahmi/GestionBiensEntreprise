package com.ems.if4_project.gestion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ems.if4_project.R;
import com.ems.if4_project.model.Bien;

public class OnlyDetailsActivity extends AppCompatActivity {
    TextView id, descri, nom, dateBien, typeBien;
    SQLiteDatabase db;
    LinearLayout ll_detail1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_only_details);
        getSupportActionBar().setTitle("GestionBiens-IF4 - Détails");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        id = findViewById(R.id.id);
        descri = findViewById(R.id.descri);
        nom = findViewById(R.id.nom);
        dateBien = findViewById(R.id.dateBien);

        typeBien = findViewById(R.id.typeBien);
        ll_detail1=(LinearLayout)findViewById(R.id.ll_detail1);
        ll_detail1.animate().translationY(0)
                .setInterpolator(new DecelerateInterpolator())
                .setDuration(900)
                .start();

        db = openOrCreateDatabase("db_bien", Context.MODE_PRIVATE, null);

        Intent itBien = getIntent();

        final Bien bien = (Bien) itBien.getExtras().getSerializable("objBien");
        id.setText(String.valueOf(bien.getId()));
        descri.setText(bien.getDescription());
        nom.setText(bien.getNom());
        dateBien.setText(bien.getDateBien());
        typeBien.setText(bien.getTypeBien());
    }

}