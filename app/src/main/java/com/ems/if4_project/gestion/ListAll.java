package com.ems.if4_project.gestion;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.ems.if4_project.R;
import com.ems.if4_project.model.Bien;
import com.ems.if4_project.model.MyListAdapter;

import java.util.ArrayList;

public class ListAll extends AppCompatActivity {
    ListView listViewBiens;
    ArrayList<Bien> biens = new ArrayList<>();
    SQLiteDatabase db;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        getSupportActionBar().setTitle("GestionBiens-IF4 - Tous les biens");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        listViewBiens = findViewById(R.id.listagem);



        db = openOrCreateDatabase("db_bien", Context.MODE_PRIVATE, null);




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
                Intent itBien = new Intent(getApplicationContext(), Details.class);
                itBien.putExtra("objBien", bien);
                startActivity(itBien);
            }
        });
    }



}