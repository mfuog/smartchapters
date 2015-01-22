package com.example.myrthafuog.smartchapters;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends Activity implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mSensor;
    private long lastUpdate = 0;
    private float lastX, lastY, lastZ;
    private TextView xAxisText, yAxisText, zAxisText;

    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mSensor, mSensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        mSensorManager.registerListener(this, mSensor, mSensorManager.SENSOR_DELAY_NORMAL);

        xAxisText = (TextView) findViewById(R.id.x_axis);
        yAxisText = (TextView) findViewById(R.id.y_axis);
        zAxisText = (TextView) findViewById(R.id.z_axis);


        //TODOgetIntent().getFloatExtra("XAxis", 0.0f);
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

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {


        //TODOfinal Intent startNewActivityIntent = new Intent(MainActivity.this, NotesListActivity.class);
        //TODOstartNewActivityIntent.getExtras().putFloat("XAxis", 12.4f);
        //TODOstartActivity(startNewActivityIntent);

        Sensor mySensor = sensorEvent.sensor;

        if(mySensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
            float x = sensorEvent.values[0];
            float y = sensorEvent.values[1];
            float z = sensorEvent.values[2];

            long curTime = System.currentTimeMillis();

            if ((curTime - lastUpdate) > 100 ) {
                lastUpdate = curTime;

                xAxisText.setText("X: " + x);
                yAxisText.setText("Y: " + y);
                zAxisText.setText("Z: " + z);

                lastX = x;
                lastY = y;
                lastZ = z;
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }


    public void measureWithoutBook(View view) {
        TextView measurement1 = (TextView) findViewById(R.id.measure_without_book);
        measurement1.setText("Measured: " + lastX + " | " + lastY + " | " + lastZ);
    }

    public void measureWithBookClosed(View view) {
        TextView measurement2 = (TextView) findViewById(R.id.measure_with_book_closed);
        measurement2.setText("Measured: " + lastX + " | " + lastY + " | " + lastZ);
    }

}
