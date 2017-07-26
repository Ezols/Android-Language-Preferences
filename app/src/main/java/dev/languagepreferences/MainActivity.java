package dev.languagepreferences;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

     ArrayList<String> list;

    @Override
    public boolean onCreateOptionsMenu(Menu menuHere) {
        // Link to xml menu
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menuHere);

        return super.onCreateOptionsMenu(menuHere);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        super.onOptionsItemSelected(item);

        switch (item.getItemId())
        {
            case R.id.settings:
                Toast.makeText(this, "Settings selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.help:
                Toast.makeText(this, "Help selected", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);

        list = new ArrayList<>();

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(arrayAdapter);

        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_menu_compass)
                .setTitle("Choose a language")
                .setMessage("Which languange would you like?")
                .setPositiveButton("English", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String language = "English";
                        Toast.makeText(MainActivity.this, language, Toast.LENGTH_SHORT).show();
                        list.add(language);
                        arrayAdapter.notifyDataSetChanged();

                        Log.i("Countries", list.toString());

                    }
                })
                .setNegativeButton("Spanish", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String language = "Spanish";
                        Toast.makeText(MainActivity.this, language, Toast.LENGTH_SHORT).show();
                        list.add(language);
                        arrayAdapter.notifyDataSetChanged();

                        Log.i("Countries", list.toString());

                    }
                })
                .show();







        SharedPreferences sharedPreferences = this.getSharedPreferences("dev.languagepreferences", Context.MODE_PRIVATE);


    }

}
