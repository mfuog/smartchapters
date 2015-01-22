package com.example.myrthafuog.smartchapters;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class ReadingNoteListActivity extends ListActivity {

    TextView content;
    private Book mBook;
    private ArrayList<ReadingNote> mReadingNotes;
    private ArrayAdapter<ReadingNote> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading_notes_list);

        content = (TextView)findViewById(R.id.output);
        //listView = (ListView) findViewById(R.id.list);

        mReadingNotes = new ArrayList<ReadingNote>();
        mBook = new Book("Alice in Wonderland", 5);
        //TODO: don't predefine the book but let user choose one
        mReadingNotes.add(new ReadingNote(mBook));
        mReadingNotes.add(new ReadingNote(mBook));
        mReadingNotes.add(new ReadingNote(mBook));

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third - the Array of data
        mAdapter = new ArrayAdapter<ReadingNote>(this,
                android.R.layout.simple_list_item_1, mReadingNotes);


        // Assign mAdapter to ListActivity
        setListAdapter(mAdapter);

    }

    @Override
    protected void onResume() {
        super.onResume();

        // Update List view by replacing mReadingNotes with array of all current ReadingNotes
        ArrayList<ReadingNote> notes =
                new ArrayList<ReadingNote>(ReadingNote.getReadingNotes().values());
        mReadingNotes.clear();
        mReadingNotes.addAll(notes);
        mAdapter.notifyDataSetChanged();
    }


    @Override
    protected void onListItemClick(ListView listView, View view, int position, long id) {

        super.onListItemClick(listView, view, position, id);

        // Value of clicked ListView item
        ReadingNote item    = (ReadingNote) listView.getItemAtPosition(position);

        //content.setText("Clicked item " + position + ": " + itemValue);
        //Toast.makeText(getApplicationContext(), itemValue + " Clicked!", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, ReadingNoteShowActivity.class);
        intent.putExtra("noteId", item.getId());
        startActivity(intent);
    }

    public void newReadingNote(View view) {
        Intent intent = new Intent(this, ReadingNoteNewActvity.class);
        intent.putExtra("bookId", mBook.getId());
        startActivity(intent);
    }
}
