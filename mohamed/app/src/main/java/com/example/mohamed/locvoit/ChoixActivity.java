package com.example.mohamed.locvoit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ChoixActivity extends AppCompatActivity {
AutoCompleteTextView acText ;
Spinner sp ;
    TextView vid;
    String val ;
    String val1 ;
    ArrayAdapter<String> adapter ;
    ArrayAdapter<String> adapter1 ;
    static final String[] COUNTRIES= new String[]{ "Tunis","Algerie","Libye","Maroc"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choix);



        acText =(AutoCompleteTextView)findViewById(R.id.acText);
        adapter =  new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,COUNTRIES);
        acText.setAdapter(adapter);

       acText.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent,
                                    View view, int pos, long id) {
                val = acText.getText().toString() ;

                Toast.makeText(getApplicationContext(),"Localisation : "+val, Toast.LENGTH_SHORT).show();
                Intent it = new Intent(ChoixActivity.this,MapsActivity.class);

                it.putExtra("pays",val);
                startActivity(it);


            }

            });



    }
public void vider (View view){

acText.setText("");
    adapter1=null;
    sp.setAdapter(adapter1);
}

}
