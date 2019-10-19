package com.example.praktikumpbm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ContentResolver cr = getContentResolver();
        Cursor c = cr.query(Settings.System.CONTENT_URI,null, null, null, null);
        startManagingCursor(c);
        ListView daftar = (ListView) findViewById(R.id.listView1);
        String[] from = { Settings.System.NAME, Settings.System.VALUE };
        int[] to = { android.R.id.text1, android.R.id.text2 };
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,android.R.layout.simple_list_item_2, c, from, to);
        daftar.setAdapter(adapter);
    }
}
