package com.ems.if4_project.gestion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.ems.if4_project.R;
import com.ems.if4_project.model.Bien;
import com.ems.if4_project.model.MyListAdapter;

import java.util.ArrayList;

public class ListAllActivity extends AppCompatActivity {
    TextView id, descri, nom, dateBien, typeBien;
    SQLiteDatabase db;
    ListView listViewBiens;
    ArrayList<Bien> biens = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onlylist);

        getSupportActionBar().setTitle("GestionBiens-IF4 -  Liste des Biens");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        id = findViewById(R.id.id);
        descri = findViewById(R.id.descri);
        nom = findViewById(R.id.nom);
        dateBien = findViewById(R.id.dateBien);
        typeBien = findViewById(R.id.typeBien);


        db = openOrCreateDatabase("db_bien", Context.MODE_PRIVATE, null);

        listViewBiens = findViewById(R.id.listAll);


        biens.clear();
        Cursor c = db.rawQuery("SELECT * FROM bien ORDER BY nom ASC", null);
        while (c.moveToNext()) {
            biens.add(new Bien(
                    c.getInt(0),
                    c.getString(1),
                    c.getString(2),
                    c.getString(3),
                    c.getString(4)));
        }

        MyListAdapter adapter = new MyListAdapter(this, biens);

        listViewBiens.setAdapter(adapter);
        listViewBiens.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bien bien = (Bien) listViewBiens.getItemAtPosition(position);
                Intent itBien = new Intent(getApplicationContext(), OnlyDetailsActivity.class);
                itBien.putExtra("objBien", bien);
                startActivity(itBien);
            }
        });


    }
}