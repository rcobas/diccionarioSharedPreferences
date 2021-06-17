package com.example.diccionarioconsharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText et1, et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
    }

    public void guardar(View view) {

        SharedPreferences sp = getSharedPreferences("diccionario", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        String palabra = et1.getText().toString();
        String traduccion = et2.getText().toString();
        editor.putString(palabra, traduccion);
        editor.commit();
        et1.setText("");
        et2.setText("");
        Toast.makeText(this, "Nueva palabra añadida al diccionario", Toast.LENGTH_LONG).show();

    }

    public void traducir(View view){
        SharedPreferences sp = getSharedPreferences("diccionario", Context.MODE_PRIVATE);
        String dato = sp.getString(et1.getText().toString(), "");
        if (dato.equals("")){
            et2.setText("");
            Toast.makeText(this, "El término introducido no existe en el diccionario", Toast.LENGTH_LONG).show();
        } else {
            et2.setText(dato);
        }


    }


}