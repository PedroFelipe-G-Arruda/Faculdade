package com.example.android_lp3;

import android.content.ContentResolver;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor acelerometro;
    private TextView txvMensagem2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final EditText txtMensagem = (EditText)findViewById(R.id.txtMensagem);
        final TextView txvMensagem = (TextView)findViewById(R.id.txvMensagem);
        txvMensagem2 = (TextView)findViewById(R.id.txvMensagem);
        final Button btnOla = (Button) findViewById(R.id.btnOla);

        btnOla.setOnClickListener((view) -> {
            txvMensagem.setText("Olá do Android: " + txtMensagem.getText());
        });

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        acelerometro = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }
    @Override
    protected void onResume(){
        super.onResume();
        sensorManager.registerListener(this, acelerometro,SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }
    @Override
    public void onSensorChanged(SensorEvent event){
        int x = (int) event.values[0];
        int y = (int) event.values[1];
        int z = (int) event.values[2];

        txvMensagem2.setText("X:" + String.valueOf(x) + "," + "Y:" + String.valueOf(y) + "," + "Z:" + String.valueOf(z));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
