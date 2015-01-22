package com.example.myrthafuog.smartchapters;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class ReadingNoteNewActvity extends Activity {

    private EditText mEdit;
    private Book mBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading_note_new);

        mEdit   = (EditText)findViewById(R.id.editText_new_note);

        String bookId = getIntent().getStringExtra("bookId");
        mBook = Book.getBooks().get(bookId);
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
        String noteText = mEdit.getText().toString();
        ReadingNote newNote = new ReadingNote(mBook);
        newNote.setText(noteText);
        //TODO: take care of chapter/x-axis

        Toast.makeText(getApplicationContext(), "Your note " + newNote.getText() + " was saved!", Toast.LENGTH_SHORT).show();
    }
}
