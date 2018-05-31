package fr.livero.livero;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

/**
 * Created by Rohit on 4/28/2018.
 */

    public class Splashscreen extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            Thread thread=new Thread() {
                @Override
                public void run() {
                    try {
                        sleep(2000);
                        Intent intent = new Intent(getApplicationContext(), ApplicationSelection.class);
                        startActivity(intent);
                        //context.display_fragment(0);
                        finish();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            };
            thread.start();
            // return view;
        }
    }
