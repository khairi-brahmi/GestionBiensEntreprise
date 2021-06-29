package com.ems.if4_project.gestion;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.ems.if4_project.model.Bien;
import com.ems.if4_project.R;
import com.ems.if4_project.utils.Message;

public class Insert extends AppCompatActivity {
    EditText descri, nom, dateBien;
    Button btInsert;
    RadioButton r_imb,r_mob;
    RadioGroup radio_select;
    SQLiteDatabase db;
    String _type="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);


        db = openOrCreateDatabase("db_bien", Context.MODE_PRIVATE, null);


        db.execSQL("CREATE TABLE IF NOT EXISTS bien(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "descri VARCHAR NOT NULL, " +
                "nom VARCHAR NOT NULL, " +
                "dateBien VARCHAR NOT NULL, " +
                "typeBien VARCHAR NOT NULL);");


        getSupportActionBar().setTitle("GestionBiens-IF4 - Ajouter");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        r_imb=(RadioButton)findViewById(R.id.r_imob);
        r_mob=(RadioButton)findViewById(R.id.r_mob);

        radio_select=(RadioGroup)findViewById(R.id.radio_select);
        radio_select.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton rb=(RadioButton)findViewById(i);
                _type=rb.getText().toString();
            }
        });



        descri = findViewById(R.id.editRa);
        nom = findViewById(R.id.editNom);
        dateBien = findViewById(R.id.editDateBien);

        btInsert = findViewById(R.id.btInsert);

        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bien bien = new Bien();
                bien.setDescription(descri.getText().toString());
                bien.setNom(nom.getText().toString());
                bien.setDateBien(dateBien.getText().toString());
                bien.setTypeBien(_type);

                // Coleta os dados digitados nos campos
                ContentValues values = new ContentValues();
                values.put("descri", bien.getDescription());
                values.put("nom", bien.getNom());
                values.put("dateBien", bien.getDateBien());
                values.put("typeBien", bien.getTypeBien());

                // Insere os dados na tabela
                long is_aded=db.insert("bien", null, values);


                Message message = new Message(Insert.this);
                message.show(
                        "Insertion avec succee !",
                        bien.getDados(),
                        R.drawable.ic_add);


                clearText();


            }
        });
    }

    // Configura o botão (seta) na ActionBar (Barra Superior)
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void clearText() {
        descri.setText("");
        nom.setText("");
        dateBien.setText("");

        descri.requestFocus();

        ((InputMethodManager) Insert.this.getSystemService(
                Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(
                getCurrentFocus().getWindowToken(), 0);
    }
}
