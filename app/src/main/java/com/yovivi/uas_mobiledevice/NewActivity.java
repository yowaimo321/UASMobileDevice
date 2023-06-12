package com.yovivi.uas_mobiledevice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String [] CekPilihan = {"Jelajahi", "Hubungi", "Baca Data", "Cek Posisi"};
    Spinner etSpinner;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        Spinner spin = findViewById(R.id.etSpinner);
        spin.setOnItemSelectedListener(this);

        ArrayAdapter ad = new ArrayAdapter((this, android.R.layout.simple_spinner_item, CekPilihan);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spin.setAdapter(ad);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        Toast.makeText(getApplicationContext(),CekPilihan[position],Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    /*public void onClick(View view){
        int index = etSpinner.getSelectedItemPosition();
        if ( CekPilihan [index]) == "Jelajahi") {

        }*/
}