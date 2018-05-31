package fr.livero.livero;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Rohit on 5/1/2018.
 */

public class Signup extends AppCompatActivity {
private EditText editemail,editname,editlogin,editpass;
private Button signupsubmitbutton;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        editemail= (EditText)findViewById(R.id.editemail);
        editname= (EditText)findViewById(R.id.editname);
        editlogin= (EditText)findViewById(R.id.editlogin);
        editpass= (EditText)findViewById(R.id.editpass);
        signupsubmitbutton = (Button)findViewById(R.id.signupsubmitbutton);

        signupsubmitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = editemail.getText().toString();
                String firstname = editname.getText().toString().substring(0,editname.getText().toString().indexOf(" "));
                String lastname = editname.getText().toString().substring(editname.getText().toString().indexOf(" "),editname.getText().toString().length());
                String password = editpass.getText().toString();
                String loginid= editlogin.getText().toString();

                //Creating an instance of the Customer class and setting all the parameters.
                CustomerDb customer = new CustomerDb();
                customer.setFirstname(firstname);
                customer.setLastname(lastname);
                customer.setEmail(email);

                //Creating the instance of the Livero database and passing the object customer to it.
                LiveroDatabase.getAppDatabase(getApplicationContext()).dataAccess().addCustomer(customer);
                Toast.makeText(getApplication(),"User Added successfully",Toast.LENGTH_SHORT).show();

                editemail.setText("");
                editname.setText("");
                editlogin.setText("");
                editpass.setText("");
            }
        });

    }
}
