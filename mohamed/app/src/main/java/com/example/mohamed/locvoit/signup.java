package com.example.mohamed.locvoit;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kamran.eleganttheme.LoginDataBaseAdapter;

import org.w3c.dom.Text;

import static com.example.kamran.eleganttheme.R.drawable.password;
import static com.google.android.gms.internal.a.R;

public class signup extends AppCompatActivity {
    EditText passwordd,mobphone,mail,usrusr;
    TextView login,signup;


    Context context = this;
    LoginDataBaseAdapter loginDataBaseAdapter;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    String mobPattern = "[1-9]+[0-9]+[0-9]+[0-9]+[0-9]+[0-9]+[0-9]+[0-9]";
    String pswPattern =  "[A-Za-z\\\\d$@$!%*#?&]{8,}$";

    static final String [] COUNTRIES= new String[]{"Mohamed","mmmmm","Moi","Meee"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        usrusr = (EditText) findViewById(R.id.usrusr);
        passwordd = (EditText)findViewById(R.id.passwrd);
        mail = (EditText) findViewById(R.id.mail);
        mobphone = (EditText) findViewById(R.id.mobphone);
        login = (TextView)findViewById(R.id.logiin);
        signup = (TextView)findViewById(R.id.sup);




        Typeface custom_font = Typeface.createFromAsset(getAssets(),"fonts/Lato-Light.ttf");
        signup.setTypeface(custom_font);
        mail.setTypeface(custom_font);
        mobphone.setTypeface(custom_font);
        passwordd.setTypeface(custom_font);
        usrusr.setTypeface(custom_font);
        login.setTypeface(custom_font);




        Intent intent = getIntent();
        usrusr.setText(intent.getStringExtra("user"));
        passwordd.setText(intent.getStringExtra("pswd"));
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(signup.this,login.class);
                startActivity(it);
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = usrusr.getText().toString();
                String phone = passwordd.getText().toString();
                String userName = usrusr.getText().toString();
                String password = passwordd.getText().toString();

               if (( mail.getText().toString().trim()).matches(emailPattern)==false && !mail.getText().toString().equals("") )
                {
                    Toast.makeText(signup.this,"verifier votre email", Toast.LENGTH_SHORT).show();

                }
                if (( mobphone.getText().toString().trim()).matches(mobPattern)==false && !mobphone.getText().toString().equals("") )
                {
                    Toast.makeText(signup.this,"verifier votre telephone", Toast.LENGTH_LONG).show();

                }
               /* if (( passwordd.getText().toString().trim()).matches(pswPattern)==false && !passwordd.getText().toString().equals("") )
                {
                    Toast.makeText(signup.this,"verifier votre mot de passe", Toast.LENGTH_SHORT).show();

                }*/
                if(mail.getText().toString().equals(""))
                {Toast.makeText(signup.this,"Vous devez saisir votre E-mail", Toast.LENGTH_LONG).show();
                }
               else if(usrusr.getText().toString().equals(""))
                {Toast.makeText(signup.this,"Vous devez saisir votre user name", Toast.LENGTH_LONG).show();
                }
                else if(passwordd.getText().toString().equals(""))
                {Toast.makeText(signup.this,"Vous devez saisir votre password", Toast.LENGTH_LONG).show();
                }
                else if(mobphone.getText().toString().equals(""))
                {Toast.makeText(signup.this,"Vous devez saisir votre Telephone", Toast.LENGTH_LONG).show();
                }
                loginDataBaseAdapter.insertEntry(email,userName,password,phone);
                Toast.makeText(signup.this, "Account Successfully Created ", Toast.LENGTH_LONG).show();
                Intent i = new Intent(signup.this,
                        login.class);
                startActivity(i);
                finish();
            }


        });



        //test sur les champs
        mail.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {

                if (( mail.getText().toString().trim()).matches(emailPattern)&& s.length() > 0)
                {
                    Toast.makeText(signup.this,"email valide", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(signup.this,"email invalide", Toast.LENGTH_LONG).show();

                }
            }


            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // other stuffs
            }
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // other stuffs
            }
        });


        mobphone.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {

                if (( mobphone.getText().toString().trim()).matches(mobPattern)&& s.length() > 0)
                {
                    Toast.makeText(signup.this,"Telephone valide", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(signup.this,"Telephone invalide", Toast.LENGTH_LONG).show();

                }

            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // other stuffs
            }
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // other stuffs
            }
        });


    }
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();

        loginDataBaseAdapter.close();
    }
}