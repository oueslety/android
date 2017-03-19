package com.example.mohamed.tp_and;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
AutoCompleteTextView acText ;
Spinner sp ;
    TextView vid;
    String val ;
    String val1 ;
    ArrayAdapter<String> adapter ;
    ArrayAdapter<String> adapter1 ;
    static final String [] COUNTRIES= new String[]{ "Tunis","Algerie","Maroc","Libye"};
    static final String [] tunis= new String[]{ "Tunis","Manouba","ariana","autre"};
    static final String [] algerie= new String[]{ "Wahran","Anaba","Bjaya","autre"};
    static final String [] maroc= new String[]{ "Dar baydha","Marakech","Akadir","autre"};
    static final String [] libye= new String[]{ "Trables","Benghazie","Sert","autre"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        acText =(AutoCompleteTextView)findViewById(R.id.acText);
        adapter =  new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,COUNTRIES);
        acText.setAdapter(adapter);

       acText.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent,
                                       View view, int pos, long id) {
                val = acText.getText().toString() ;

                Toast.makeText(getApplicationContext(),"pays : "+val, Toast.LENGTH_SHORT).show();

                if (val.equals("Tunis")){
                    adapter1 =  new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_dropdown_item_1line,tunis);
                    sp =(Spinner) findViewById(R.id.sp);
                    sp.setAdapter(adapter1);
                    sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        public void onItemSelected(AdapterView<?> parent,
                                                   View view, int pos, long id) {
                            val1 = parent.getItemAtPosition(pos).toString() ;


                            Toast.makeText(getApplicationContext(), "Vous avez choisie "+val1+" de : "+ val , Toast.LENGTH_SHORT).show();
                        }

                        public void onNothingSelected(AdapterView parent) {

                        }});
                }


                if (val.equals("Maroc")){
                    adapter1 =  new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_dropdown_item_1line,maroc);
                    sp =(Spinner) findViewById(R.id.sp);
                    sp.setAdapter(adapter1);
                    sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        public void onItemSelected(AdapterView<?> parent,
                                                   View view, int pos, long id) {
                            val1 = parent.getItemAtPosition(pos).toString() ;


                            Toast.makeText(getApplicationContext(), "Vous avez choisie "+val1+" de : "+ val , Toast.LENGTH_SHORT).show();
                        }

                        public void onNothingSelected(AdapterView parent) {

                        }});
                }

                if (val.equals("Algerie")){
                    adapter1 =  new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_dropdown_item_1line,algerie);
                    sp =(Spinner) findViewById(R.id.sp);
                    sp.setAdapter(adapter1);
                    sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        public void onItemSelected(AdapterView<?> parent,
                                                   View view, int pos, long id) {
                            val1 = parent.getItemAtPosition(pos).toString() ;


                            Toast.makeText(getApplicationContext(), "Vous avez choisie "+val1+" de : "+ val , Toast.LENGTH_SHORT).show();
                        }

                        public void onNothingSelected(AdapterView parent) {

                        }});
                }




                if (val.equals("Libye")){
                    adapter1 =  new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_dropdown_item_1line,libye);
                    sp =(Spinner) findViewById(R.id.sp);
                    sp.setAdapter(adapter1);
                    sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        public void onItemSelected(AdapterView<?> parent,
                                                   View view, int pos, long id) {
                            val1 = parent.getItemAtPosition(pos).toString() ;


                            Toast.makeText(getApplicationContext(),"Vous avez choisie "+val1+" de : "+ val , Toast.LENGTH_SHORT).show();
                        }

                        public void onNothingSelected(AdapterView parent) {

                        }});
                }

            }

            });



    }
public void vider (View view){

acText.setText("");
    adapter1=null;
    sp.setAdapter(adapter1);
}

}
