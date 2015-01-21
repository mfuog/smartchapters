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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        content = (TextView)findViewById(R.id.output);

        //listView = (ListView) findViewById(R.id.list);
        //String[] values = new String[] { "Android Example ListActivity", "Adapter implementation", "Simple List View With ListActivity",
        //        "ListActivity Android", "Android Example", "ListActivity Source Code", "ListView ListActivity Array Adapter", "Android Example ListActivity" };

        ArrayList<ReadingNote> notes = new ArrayList<ReadingNote>();
        Book book = new Book("Alice in Wonderland", 5);
        notes.add(new ReadingNote(book));
        notes.add(new ReadingNote(book));
        notes.add(new ReadingNote(book));

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third - the Array of data
        ArrayAdapter<ReadingNote> adapter = new ArrayAdapter<ReadingNote>(this,
                android.R.layout.simple_list_item_1, notes);


        // Assign adapter to ListActivity
        setListAdapter(adapter);

        /*setListAdapter(new ArrayAdapter<ReadingNote>(this, android.R.layout.simple_list_item_1, readingNotes){

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                if((convertView == null) || !(convertView instanceof AppointmentListItem)){

                    convertView = new AppointmentListItem(AppointmentListActivity.this, this);
                }

                ((AppointmentListItem)convertView).setData(getItem(position));

                return convertView;
            }
        });*/

    }

    @Override
    protected void onListItemClick(ListView listView, View view, int position, long id) {

        super.onListItemClick(listView, view, position, id);

        // Value of clicked ListView item
        ReadingNote item    = (ReadingNote) listView.getItemAtPosition(position);

        //content.setText("Clicked item " + position + ": " + itemValue);
        //Toast.makeText(getApplicationContext(), itemValue + " Clicked!", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, ReadingNoteViewActivity.class);
        intent.putExtra("noteId", item.getId());
        startActivity(intent);
    }
}
