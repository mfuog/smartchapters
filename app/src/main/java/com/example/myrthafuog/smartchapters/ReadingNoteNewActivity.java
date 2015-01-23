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
import android.widget.EditText;
import android.widget.Toast;


public class ReadingNoteNewActivity extends Activity implements SensorEventListener {

    private Book mBook;
    private EditText mEdit;
    private Sensor mSensor;
    private SensorManager mSensorManager;
    private long mLastSenorUpdate;
    private float mLastXMeasured;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading_note_new);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        mSensorManager.registerListener(this, mSensor, mSensorManager.SENSOR_DELAY_NORMAL);

        String bookId = getIntent().getStringExtra("bookId");
        mBook = Book.getBooks().get(bookId);
        mEdit = (EditText)findViewById(R.id.edit_new_note);

    }

    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mSensor, mSensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create_reading_note_actvity, menu);
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

    public void saveNewReadingNote(View view){
        ReadingNote newNote = new ReadingNote(mBook);
        String noteText = mEdit.getText().toString();
        newNote.setText(noteText);
        newNote.setXAxisOpened(mLastXMeasured);

        Toast.makeText(getApplicationContext(), "Your note " + newNote.getText()
                                                + " was saved!", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Sensor mySensor = sensorEvent.sensor;

        if(mySensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
            float x = sensorEvent.values[0];
            //float y = sensorEvent.values[1];
            //float z = sensorEvent.values[2];

            long curTime = System.currentTimeMillis();

            if ((curTime - mLastSenorUpdate) > 100 ) {
                mLastSenorUpdate = curTime;

                mLastXMeasured = x;
                //lastY = y;
                //lastZ = z;
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
