package com.example.myrthafuog.smartchapters;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class ReadingNoteViewActivity extends Activity {
    private ReadingNote note;
    private static final String TAG = ReadingNoteViewActivity.class.getSimpleName();

    TextView content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading_note_view);
        Log.d(TAG, "craaaaaaash!");

        String noteId = getIntent().getStringExtra("noteId");
        this.note = ReadingNote.getReadingNote(noteId);
        //do stuff w/ note here

        content = (TextView)findViewById(R.id.note_text);
        content.setText("Note: " + this.note.getText());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_reading_note_view, menu);
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
