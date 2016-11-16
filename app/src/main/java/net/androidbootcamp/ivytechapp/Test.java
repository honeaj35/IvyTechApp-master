package net.androidbootcamp.ivytechapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Test extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        TextView latitude = (TextView)findViewById(R.id.textView6);
        TextView longitude = (TextView)findViewById(R.id.textView7);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        String roomNum = sharedPref.getString("key1","");

        DBHandler db = new DBHandler(this);

        Classroom classrooms = db.getClassroom(roomNum);

        latitude.setText(String.valueOf(classrooms.getLatitude()));
        longitude.setText(String.valueOf(classrooms.getLongitude()));
    }

}
