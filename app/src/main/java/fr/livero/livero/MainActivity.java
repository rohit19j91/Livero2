package fr.livero.livero;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * Created by Rohit on 4/28/2018.
 */
public class MainActivity extends AppCompatActivity {
    public static LiveroDatabase liveroDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        liveroDatabase = Room.databaseBuilder(getApplicationContext(),LiveroDatabase.class,"customerdb").allowMainThreadQueries().build();
    }
}
