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

    private Book mBook;
    private final ArrayList<ReadingNote> mReadingNotes = new ArrayList<ReadingNote>();
    private ArrayAdapter<ReadingNote> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading_notes_list);

        //listView = (ListView) findViewById(R.id.list);

        // Set book that's associated with the list of notes
        if(getIntent().hasExtra("bookId")) {
            String bookId = getIntent().getStringExtra("bookId");
            mBook = Book.getBooks().get(bookId);
        }

        TextView titleBar = (TextView) findViewById(R.id.book_title_list);
        titleBar.setText("Book: " + mBook.getTitle() + ", " + mBook.getNumbChapters() + " chapters");

        // Define a new Adapter
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

        //mText.setText("Clicked item " + position + ": " + itemValue);
        //Toast.makeText(getApplicationContext(), itemValue + " Clicked!", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, ReadingNoteShowActivity.class);
        intent.putExtra("noteId", item.getId());
        startActivity(intent);
    }

    public void newReadingNote(View view) {
        Intent intent = new Intent(this, ReadingNoteNewActivity.class);
        intent.putExtra("bookId", mBook.getId());
        startActivity(intent);
    }
}
