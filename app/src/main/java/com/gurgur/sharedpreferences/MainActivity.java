package com.gurgur.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;

    EditText e_key,e_value;
    Button b_get,b_set,clear_data,remove_data;
    TextView t_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        e_key = findViewById(R.id.edtkey);
        e_value = findViewById(R.id.edtvalue);
        b_get = findViewById(R.id.btnget);
        b_set = findViewById(R.id.btnset);
        t_data = findViewById(R.id.txtData);
        clear_data = findViewById(R.id.clearData);
        remove_data = findViewById(R.id.removeData);
        b_set.setOnClickListener(this);
        b_get.setOnClickListener(this);
        clear_data.setOnClickListener(this);
        remove_data.setOnClickListener(this);

        sharedPreferences = getSharedPreferences("ShrdInfo", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnget:
                //todo click btnGet
                String text = sharedPreferences.getString(e_key.getText().toString(),"Not Found Data");
                Log.i("firat" , text);
                t_data.setText(text);
                break;

            case R.id.btnset:
                //todo click btnSet
                editor.putString(e_key.getText().toString(),e_value.getText().toString());
                editor.apply();
                Toast.makeText(this, "Ekleme Yapıldı", Toast.LENGTH_SHORT).show();
                e_key.setText("");
                e_value.setText("");
                break;

            case R.id.clearData:
                editor.clear();
                editor.apply();
                e_key.setText("");
                e_value.setText("");
                break;

            case R.id.removeData:
                editor.remove(e_key.getText().toString().trim());
                editor.apply();
                e_key.setText("");
                e_value.setText("");
                break;
            default:
                break;
        }

    }
}
