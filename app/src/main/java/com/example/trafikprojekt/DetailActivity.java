package com.example.trafikprojekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getDetails();
    }

    public void getDetails (){
        //Hämtar först "id" fån förra intent och sedan hämtar objekt m.h.a. index, från personlistan
        String objektID = getIntent().getStringExtra("id");
        int id = Integer.parseInt(objektID);
        Person getObjektOfId = MainActivity.personList.get(id);
        int objektIndex = MainActivity.personList.indexOf(getObjektOfId);
        Person personDetalier = MainActivity.personList.get(objektIndex);
        //kopplar vyn till objektattributer
        TextView textView1 =(TextView)findViewById(R.id.fornamnTextView);
        textView1.setText(personDetalier.getFornamn());
        TextView textView2 =(TextView)findViewById(R.id.efternamnTextView);
        textView2.setText(personDetalier.getEfternamn());
        TextView textView3 =(TextView)findViewById(R.id.pnummerTextView);
        textView3.setText(""+ personDetalier.getPnummer());
        TextView textView5 =(TextView)findViewById(R.id.adressTextView);
        textView5.setText(personDetalier.getAdress());
        TextView textView4 =(TextView)findViewById(R.id.telefonnummerTextView);
        textView4.setText(""+ personDetalier.getTelefonnummer());
        TextView textView6 =(TextView)findViewById(R.id.emailTextView);
        textView6.setText(personDetalier.getEmail());
    }
    public void btnDelete_onClick(View view) {
        //hämtar id från förra intent och raderar objekt
        String objektID = getIntent().getStringExtra("id");
        //converterar till int och tar bort från listan
        int id = Integer.parseInt(objektID);
        MainActivity.personList.remove(id);
        //uppdaterar processen som har hand om listview
        MainActivity.listView.deferNotifyDataSetChanged();
        //går tillbaka  till mainactivity
        Intent nextIntent = new Intent(this, MainActivity.class);
        startActivity(nextIntent);
    }
}