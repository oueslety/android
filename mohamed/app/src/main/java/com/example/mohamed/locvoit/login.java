package com.example.mohamed.locvoit;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.widget.Toast;

public class login extends AppCompatActivity {
    TextView bytes,sup,lin,logiin;
    EditText usr,pswd;
    public ProgressDialog	progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usr = (EditText) findViewById(R.id.usrusr);
        pswd = (EditText)findViewById(R.id.passwrd);
        lin = (TextView)findViewById(R.id.logiin);
        sup = (TextView)findViewById(R.id.sup);
        logiin = (TextView)findViewById(R.id.logiin);
        bytes = (TextView)findViewById(R.id.bytes);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),"fonts/Lato-Light.ttf");
        bytes.setTypeface(custom_font);
        pswd.setTypeface(custom_font);
        sup.setTypeface(custom_font);
        lin.setTypeface(custom_font);
        usr.setTypeface(custom_font);
        sup.setOnClickListener(new View.OnClickListener()
        {


            @Override
            public void onClick(View v)
            {
                String user = usr.getText().toString();
                String psw = pswd.getText().toString();
                Intent it = new Intent(login.this,signup.class);
                it.putExtra("user",user);
                it.putExtra("pswd",psw);
                startActivity(it);

            }
        });
        logiin.setOnClickListener(new View.OnClickListener()
        {

            public void onClick(View v)
            {


                if(usr.getText().toString().equals("")||pswd.getText().toString().equals(""))
                {Toast.makeText(login.this,"Vous devez remplir tous les champs", Toast.LENGTH_LONG).show();
                }
else{
                Intent it = new Intent(login.this,ChoixActivity.class);
                startActivity(it);}

            }

        });

    }
}
