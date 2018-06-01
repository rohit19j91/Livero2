package fr.livero.livero;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Rohit on 4/28/2018.
 */

public class ApplicationSelection extends AppCompatActivity{
    Button btncustlogin,btndellogin;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appselection);

        btncustlogin=(Button)findViewById(R.id.customer_login);
        btndellogin=(Button)findViewById(R.id.deliverer_login);

        btncustlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent int1= new Intent(ApplicationSelection.this,Login.class);
                startActivity(int1);
            }
        });

        btndellogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent int1= new Intent(ApplicationSelection.this,Test.class);
                startActivity(int1);
            }
        });
    }
}
