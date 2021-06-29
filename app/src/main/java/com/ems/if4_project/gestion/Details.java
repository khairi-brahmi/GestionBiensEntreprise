package com.ems.if4_project.gestion;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.ems.if4_project.R;
import com.ems.if4_project.model.Bien;

public class Details extends AppCompatActivity {
    Button edit,delete;
    TextView id, descri, nom, dateBien, typeBien;
    SQLiteDatabase db;
    LinearLayout ll_detali,ll_bouttons;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        getSupportActionBar().setTitle("GestionBiens-IF4 - Détails");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        id = findViewById(R.id.id);
        descri = findViewById(R.id.descri);
        nom = findViewById(R.id.nom);
        dateBien = findViewById(R.id.dateBien);
        typeBien = findViewById(R.id.typeBien);

        ll_detali=(LinearLayout)findViewById(R.id.ll_detail);
        ll_bouttons=(LinearLayout)findViewById(R.id.ll_bouttons);
        ll_detali.animate().translationY(0)
                .setInterpolator(new DecelerateInterpolator())
                .setDuration(900)
                .start();
        ll_bouttons.animate().translationX(0)
                .setInterpolator(new DecelerateInterpolator())
                .setDuration(1000)
                .start();
        db = openOrCreateDatabase("db_bien", Context.MODE_PRIVATE, null);

        edit = findViewById(R.id.bt_edit);
        delete=(Button)findViewById(R.id.bt_delete);

        Intent itBien = getIntent();

        final Bien bien = (Bien) itBien.getExtras().getSerializable("objBien");

        id.setText(String.valueOf(bien.getId()));
        descri.setText(bien.getDescription());
        nom.setText(bien.getNom());
        dateBien.setText(bien.getDateBien());
        typeBien.setText(bien.getTypeBien());

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent edit = new Intent(getApplicationContext(), EditRecord.class);
                edit.putExtra("objBien", bien);
                startActivity(edit);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Details.this);
                builder.setCancelable(true);
                builder.setTitle("Supprimer");
                builder.setMessage("Voulez vous supprimer cet element !");
                builder.setPositiveButton("Confirmer",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(delete(String.valueOf(bien.getId()))){
                                    Intent all = new Intent(getApplicationContext(), ListAll.class);
                                    startActivity(all);
                                    finish();
                                };
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

    }

    public  boolean delete(String id){

        return db.delete("bien",  "id=" + id, null) > 0;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}