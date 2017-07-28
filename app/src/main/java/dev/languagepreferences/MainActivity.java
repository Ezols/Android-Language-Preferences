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
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    SharedPreferences sharedPreferences;

    TextView textView;

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
//
//        if(item.getItemId() == R.id.english)
//        {
//            setLanguage("English");
//        } else if (item.getItemId() == R.id.spanish)
//        {
//            setLanguage("Spanish");
//        }
//        return true;


        switch (item.getItemId())
        {
            case R.id.english:
                Toast.makeText(this, "Settings selected", Toast.LENGTH_SHORT).show();
                setLanguage("English");
                return true;
            case R.id.spanish:
                Toast.makeText(this, "Help selected", Toast.LENGTH_SHORT).show();
                setLanguage("Spanish");
                return true;

            default:

                return false;
        }


    }

    public void setLanguage(String language)
    {
        sharedPreferences.edit().putString("language", language).apply();

        textView.setText(language);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = this.getSharedPreferences("dev.languagepreferences", Context.MODE_PRIVATE);

        textView = (TextView) findViewById(R.id.textView);

        String language = sharedPreferences.getString("language", "");

        if (language == "") {

            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_btn_speak_now)
                    .setTitle("Choose a language")
                    .setMessage("Which languange would you like?")
                    .setPositiveButton("English", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            setLanguage("English");


                        }
                    })
                    .setNegativeButton("Spanish", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            setLanguage("Spanish");

                        }
                    })
                    .show();
        }
        else
        {
            textView.setText(language);
        }

    }



}
