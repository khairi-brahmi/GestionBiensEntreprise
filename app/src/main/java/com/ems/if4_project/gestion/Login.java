package com.ems.if4_project.gestion;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ems.if4_project.R;

public class Login extends AppCompatActivity  {
    Button connect;
    EditText username,password;
    private String _password="admin";
    private String _username="admin@admin";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        connect=(Button)findViewById(R.id.Connect);
        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!username.getText().toString().isEmpty()&&!password.getText().toString().isEmpty()){
                    if(_username.equals(username.getText().toString())&&_password.equals(password.getText().toString())){
                        Toast.makeText(getApplicationContext(),"Connecté",Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(getApplicationContext(), Home.class);
                        startActivity(intent);
                        finish();
                    }else {
                        Toast.makeText(getApplicationContext(),"Mot de passe ou mail inncorrect !",Toast.LENGTH_LONG).show();
                    }

                }else{
                    Toast.makeText(getApplicationContext(),"Mot de passe et mail sont obligatoires",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}