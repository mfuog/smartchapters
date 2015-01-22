package com.example.myrthafuog.smartchapters;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class ReadingNoteEditActivity extends Activity {

    private ReadingNote mNote;
    private EditText mEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading_note_edit);

        String noteId = getIntent().getStringExtra("noteId");
        mNote = ReadingNote.getReadingNotes().get(noteId);

        mEdit = (EditText)findViewById(R.id.edit_note);
    }

    @Override
    public void onResume(){
        super.onResume();

        mEdit.setText(mNote.getText());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_reading_note_edit, menu);
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

    public void saveReadingNote(View view){
        String noteText = mEdit.getText().toString();
        mNote.setText(noteText);

        Toast.makeText(getApplicationContext(),
                "Your note " + mNote.getText() + " was saved!",
                Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, ReadingNoteListActivity.class);
        intent.putExtra("bookId", mNote.getBook().getId()); //TODO: workaround
        startActivity(intent);
    }

}
