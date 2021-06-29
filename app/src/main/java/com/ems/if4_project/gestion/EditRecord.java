package com.ems.if4_project.gestion;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.ems.if4_project.R;
import com.ems.if4_project.model.Bien;
import com.ems.if4_project.utils.Message;

public class EditRecord extends AppCompatActivity {

    TextView id;
    EditText descri, nom, dateBien, typeBien;
    Button btEnreg;
    Bien bienss;
    SQLiteDatabase db;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);


        getSupportActionBar().setTitle("GestionBiens-IF4 - Modifier");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        id = findViewById(R.id.id);
        descri = findViewById(R.id.descri);
        nom = findViewById(R.id.nom);
        dateBien = findViewById(R.id.dateBien);
        typeBien = findViewById(R.id.typeBien);
        btEnreg = findViewById(R.id.btEnreg);

        final Intent itBien = getIntent();
        final Bien bien = (Bien) itBien.getExtras().getSerializable("objBien");
        id.setText(String.valueOf(bien.getId()));
        descri.setText(bien.getDescription());
        nom.setText(bien.getNom());
        dateBien.setText(bien.getDateBien());
        typeBien.setText(bien.getTypeBien());

        btEnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                
                ContentValues values = new ContentValues();
                values.put("descri", descri.getText().toString());
                values.put("nom", nom.getText().toString());
                values.put("dateBien", dateBien.getText().toString());
                values.put("typeBien", typeBien.getText().toString());

                bienss = new Bien();
                bienss.setDescription(descri.getText().toString());
                bienss.setNom(nom.getText().toString());
                bienss.setDateBien(dateBien.getText().toString());
                bienss.setTypeBien(typeBien.getText().toString());


                db = openOrCreateDatabase("db_bien", Context.MODE_PRIVATE, null);
                db.execSQL("UPDATE bien SET " +
                        "descri='" + bienss.getDescription() + "'," +
                        "nom='" + bienss.getNom() + "'," +
                        "dateBien='" + bienss.getDateBien() + "'," +
                        "typeBien='" + bienss.getTypeBien() + "' " +
                        "WHERE id=" + bien.getId()
                );

            Toast.makeText(getApplicationContext(),"Modification avec succée !",Toast.LENGTH_LONG).show();
                Intent itBien = new Intent(getApplicationContext(), Details.class);
                itBien.putExtra("objBien", bienss);
                itBien.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP );
                startActivity(itBien);
                finish();

            }
        });
    }


}