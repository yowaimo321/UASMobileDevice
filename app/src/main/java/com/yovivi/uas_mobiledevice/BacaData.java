package com.yovivi.uas_mobiledevice;

import android.annotation.SuppressLint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;


public class BacaData extends AppCompatActivity implements SensorEventListener {

    SensorManager pengelolaSensor;

    List<Sensor> daftarSensor;

    TextView text;  Sensor sensorJarak;


    @SuppressLint("ServiceCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baca_data);
        text = findViewById(R.id.textView);
        pengelolaSensor = (SensorManager) this.getSystemService(SENSOR_SERVICE);
        daftarSensor = pengelolaSensor.getSensorList(Sensor.TYPE_ALL);

        int jumlahSensor = daftarSensor.size();
        for (int x=0; x < jumlahSensor; x++){
            text.append(daftarSensor.get(x).getName() + '\n');

        }

        sensorJarak = pengelolaSensor.getDefaultSensor(Sensor.TYPE_PROXIMITY);

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float nilaiJarak = sensorEvent.values[0];
        text.setText(String.valueOf(nilaiJarak));

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

        text.setText(String.valueOf(1));
        text.invalidate();

    }

    @Override
    public void onPause(){
        super.onPause();
        pengelolaSensor.unregisterListener(this,sensorJarak);
    }

    @Override
    public void onResume(){
        super.onResume();
        pengelolaSensor.registerListener(
                this, sensorJarak, SensorManager.SENSOR_DELAY_NORMAL);

    }
}