package com.yovivi.uas_mobiledevice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class NewActivity extends AppCompatActivity {

    private Spinner etSpinner;
    int currentItem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        etSpinner = findViewById(R.id.etSpinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getApplicationContext(),
                R.array.CekPilihan, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        etSpinner.setAdapter(adapter);
        etSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();

                if (selectedItem.equals("Jelajahi")) {
                    Intent intent = new Intent(NewActivity.this, Jelajahi.class);
                    startActivity(intent);
                }

                else if (selectedItem.equals("Hubungi")) {
                    Intent intent = new Intent(NewActivity.this, Hubungi.class);
                    startActivity(intent);
                }

                else if (selectedItem.equals("Baca Data")) {
                    Intent intent = new Intent(NewActivity.this, BacaData.class);
                    startActivity(intent);
                }

                else if (selectedItem.equals("Cek Posisi")) {
                    Intent intent = new Intent(NewActivity.this, CekPosisi.class);
                    startActivity(intent);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}
