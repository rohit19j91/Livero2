package fr.livero.livero;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ProgressBar;

import com.felipecsl.gifimageview.library.GifImageView;

import org.apache.commons.io.IOUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Rohit on 4/28/2018.
 */

    public class Splashscreen extends AppCompatActivity {

    private GifImageView gifImageView;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);
       /* gifImageView = findViewById(R.id.splashscreengif);

        try {
            InputStream inputStream = getAssets().open("splashscreengif.gif");
            byte[] bytes = IOUtils.toByteArray(inputStream);
            gifImageView.setBytes(bytes);
            gifImageView.startAnimation();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
new Handler().postDelayed(new Runnable() {
    @Override
    public void run() {
        Splashscreen.this.startActivity(new Intent(Splashscreen.this,ApplicationSelection.class));
        Splashscreen.this.finish();
    }
},6000);*/
/////////////////////////
        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(5000);   // set the duration of splash screen
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(Splashscreen.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        timer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
