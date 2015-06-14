package com.example.humbertina.sensoresaplicacion;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends ActionBarActivity implements SensorEventListener{

    //Variables de los editText
    private TextView lista, val1, val2, val3, val4, val5, val6, val7, val8, val9, val10, val11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (TextView) findViewById(R.id.lista);
        val1 = (TextView) findViewById(R.id.val1);
        val2 = (TextView) findViewById(R.id.val2);
        val3 = (TextView) findViewById(R.id.val3);
        val4 = (TextView) findViewById(R.id.val4);
        val5 = (TextView) findViewById(R.id.val5);
        val6 = (TextView) findViewById(R.id.val6);
        val7 = (TextView) findViewById(R.id.val7);
        val8 = (TextView) findViewById(R.id.val8);
        val9 = (TextView) findViewById(R.id.val9);
        val10 = (TextView) findViewById(R.id.val10);
        val11 = (TextView) findViewById(R.id.val11);

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        List<Sensor> listaSensores = sensorManager.getSensorList(Sensor.TYPE_ALL);

        for (Sensor sensor: listaSensores) {
            log(sensor.getName());
        }
    }

    public  void iniciar (View v) {
        lista.setText("");
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> listaSensores = sensorManager.getSensorList(Sensor.TYPE_ALL);

        for (Sensor sensor: listaSensores) {
            log(sensor.getName());
        }

        listaSensores = sensorManager.getSensorList(Sensor.TYPE_ORIENTATION);

        if (!listaSensores.isEmpty()) {
            Sensor orientationSensor = listaSensores.get(0);
            sensorManager.registerListener(this, orientationSensor,
                    SensorManager.SENSOR_DELAY_UI);}

        listaSensores = sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);

        if (!listaSensores.isEmpty()) {
            Sensor acelerometerSensor = listaSensores.get(0);
            sensorManager.registerListener(this, acelerometerSensor,
                    SensorManager.SENSOR_DELAY_NORMAL);}

        listaSensores = sensorManager.getSensorList(Sensor.TYPE_PROXIMITY);

        if (!listaSensores.isEmpty()) {
            Sensor proximitySensor = listaSensores.get(0);
            sensorManager.registerListener(this, proximitySensor,
                    SensorManager.SENSOR_DELAY_NORMAL);}

        listaSensores = sensorManager.getSensorList(Sensor.TYPE_GYROSCOPE);

        if (!listaSensores.isEmpty()) {
            Sensor giroscopioSensor = listaSensores.get(0);
            sensorManager.registerListener(this, giroscopioSensor,
                    SensorManager.SENSOR_DELAY_UI);}

        listaSensores = sensorManager.getSensorList(Sensor.TYPE_MAGNETIC_FIELD);

        if (!listaSensores.isEmpty()) {
            Sensor magneticSensor = listaSensores.get(0);
            sensorManager.registerListener(this, magneticSensor,
                    SensorManager.SENSOR_DELAY_NORMAL);}

        listaSensores = sensorManager.getSensorList(Sensor.TYPE_LIGHT);

        if (!listaSensores.isEmpty()) {
            Sensor luzSensor = listaSensores.get(0);
            sensorManager.registerListener(this, luzSensor,
                    SensorManager.SENSOR_DELAY_NORMAL);}

        listaSensores = sensorManager.getSensorList(Sensor.TYPE_GRAVITY);

        if (!listaSensores.isEmpty()) {
            Sensor gravedadSensor = listaSensores.get(0);
            sensorManager.registerListener(this, gravedadSensor,
                    SensorManager.SENSOR_DELAY_NORMAL);}

        listaSensores = sensorManager.getSensorList(Sensor.TYPE_TEMPERATURE);

        if (!listaSensores.isEmpty()) {
            Sensor temperatureSensor = listaSensores.get(0);
            sensorManager.registerListener(this, temperatureSensor,
                    SensorManager.SENSOR_DELAY_NORMAL);}

    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public void onSensorChanged(SensorEvent event) {
        synchronized (this) {
            switch(event.sensor.getType()) {
                case Sensor.TYPE_ORIENTATION:
                    break;
                case Sensor.TYPE_ACCELEROMETER:
                    val1.setText("Aceler\u00f3metro X: " + event.values[0]);
                    val2.setText("Aceler\u00f3metro Y: " + event.values[1]);
                    val3.setText("Aceler\u00f3metro Z: "+event.values[2]);
                    break;
                case Sensor.TYPE_GYROSCOPE:
                    val4.setText("Eje X: "+event.values[0]);
                    val5.setText("Eje Y: "+event.values[1]);
                    val6.setText("Eje Z: "+event.values[2]);
                    break;
                case Sensor.TYPE_MAGNETIC_FIELD:
                    val7.setText("Eje X: " + event.values[0]);
                    val8.setText("Eje Y: " + event.values[1]);
                    val9.setText("Eje Z: " + event.values[2]);
                    break;
                case Sensor.TYPE_PROXIMITY:
                    val10.setText("Proximidad: " + event.values[0]);
                    break;
                case Sensor.TYPE_LIGHT:
                    break;
                case Sensor.TYPE_GRAVITY:
                    break;
                default:
                    for (int i=0 ; i<event.values.length ; i++) {
                        val11.setText("Temperatura "+i+": "+event.values[i]);
                    }
            }
        }
    }

    private void log (String string) {
        lista.append(string + "\n");
    }

    @Override
    protected void onPause() {
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager.unregisterListener(this);
        super.onPause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        List<Sensor> listaSensores = sensorManager.getSensorList(Sensor.TYPE_ALL);

        listaSensores = sensorManager.getSensorList(Sensor.TYPE_ORIENTATION);

        if (!listaSensores.isEmpty()) {
            Sensor orientationSensor = listaSensores.get(0);
            sensorManager.registerListener(this, orientationSensor,
                    SensorManager.SENSOR_DELAY_UI);}

        listaSensores = sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);

        if (!listaSensores.isEmpty()) {
            Sensor acelerometerSensor = listaSensores.get(0);
            sensorManager.registerListener(this, acelerometerSensor,
                    SensorManager.SENSOR_DELAY_NORMAL);}

        listaSensores = sensorManager.getSensorList(Sensor.TYPE_PROXIMITY);

        if (!listaSensores.isEmpty()) {
            Sensor proximitySensor = listaSensores.get(0);
            sensorManager.registerListener(this, proximitySensor,
                    SensorManager.SENSOR_DELAY_NORMAL);}


        listaSensores = sensorManager.getSensorList(Sensor.TYPE_GYROSCOPE);

        if (!listaSensores.isEmpty()) {
            Sensor giroscopioSensor = listaSensores.get(0);
            sensorManager.registerListener(this, giroscopioSensor,
                    SensorManager.SENSOR_DELAY_UI);}

        listaSensores = sensorManager.getSensorList(Sensor.TYPE_MAGNETIC_FIELD);

        if (!listaSensores.isEmpty()) {
            Sensor magneticSensor = listaSensores.get(0);
            sensorManager.registerListener(this, magneticSensor,
                    SensorManager.SENSOR_DELAY_NORMAL);}

        listaSensores = sensorManager.getSensorList(Sensor.TYPE_LIGHT);

        if (!listaSensores.isEmpty()) {
            Sensor luzSensor = listaSensores.get(0);
            sensorManager.registerListener(this, luzSensor,
                    SensorManager.SENSOR_DELAY_NORMAL);}

        listaSensores = sensorManager.getSensorList(Sensor.TYPE_GRAVITY);

        if (!listaSensores.isEmpty()) {
            Sensor gravedadSensor = listaSensores.get(0);
            sensorManager.registerListener(this, gravedadSensor,
                    SensorManager.SENSOR_DELAY_NORMAL);}

        listaSensores = sensorManager.getSensorList(Sensor.TYPE_TEMPERATURE);

        if (!listaSensores.isEmpty()) {
            Sensor temperatureSensor = listaSensores.get(0);
            sensorManager.registerListener(this, temperatureSensor,
                    SensorManager.SENSOR_DELAY_NORMAL);}
    }

    public void detener(View v) {
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager.unregisterListener(this);
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager.unregisterListener(this);
        super.onDestroy();
    }

    public  void salir (View v) {
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
