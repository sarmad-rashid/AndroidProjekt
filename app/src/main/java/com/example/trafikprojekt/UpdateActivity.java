package com.example.trafikprojekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class UpdateActivity extends AppCompatActivity {

    private Person updatePerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        getData();
    }

    public void btnUpdate_onClick(View view) {
        updateData();
        //öppnar ny sida
        Intent nySida = new Intent( this, MainActivity.class);
        startActivity(nySida);
    }
    private void getData(){
        //Hämtar först "id" fån förra intent och sedan hämtar objekt m.h.a. id, från personlistan
        String objektID = getIntent().getStringExtra("id");
        //Get id
        int id = Integer.parseInt(objektID);
        Person getObjektOfId = MainActivity.personList.get(id);
        int objektIndex = MainActivity.personList.indexOf(getObjektOfId);
        updatePerson = MainActivity.personList.get(objektIndex);

        //kopplar vyn till objektattributer
        EditText textView1 =(EditText)findViewById(R.id.updateFornamn);
        textView1.setText(updatePerson.getFornamn());
        EditText textView2 =(EditText)findViewById(R.id.updateEfternamn);
        textView2.setText(updatePerson.getEfternamn());
        EditText textView3 =(EditText)findViewById(R.id.updatePnummer);
        textView3.setText(""+updatePerson.getPnummer());
        EditText textView5 =(EditText)findViewById(R.id.updateAdress);
        textView5.setText(updatePerson.getAdress());
        EditText textView4 =(EditText)findViewById(R.id.updateTelefonnummer);
        textView4.setText(""+updatePerson.getTelefonnummer());
        EditText textView6 =(EditText)findViewById(R.id.updateEmail);
        textView6.setText(updatePerson.getEmail());
    }
    private void updateData(){
        //hämtar värden från vyn
        EditText editFornamn = (EditText)findViewById(R.id.updateFornamn);
        EditText editEfternamn = (EditText)findViewById(R.id.updateEfternamn);
        EditText editPnummer = (EditText)findViewById(R.id.updatePnummer);
        EditText editAdress = (EditText)findViewById(R.id.updateAdress);
        EditText editTelefonnummer = (EditText)findViewById(R.id.updateTelefonnummer);
        EditText editEmail = (EditText)findViewById(R.id.updateEmail);
        //omvandlar värden till String
        String fornamn = editFornamn.getText().toString();
        String efternamn = editEfternamn.getText().toString();
        long pnummer = Long.parseLong(editPnummer.getText().toString());
        String adress = editAdress.getText().toString();
        int telefonnummer = Integer.parseInt(editTelefonnummer.getText().toString());
        String email = editEmail.getText().toString();
        //Skapar objekt med önskade värden
        updatePerson.setFornamn(fornamn);
        updatePerson.setEfternamn(efternamn);
        updatePerson.setPnummer(pnummer);
        updatePerson.setAdress(adress);
        updatePerson.setTelefonnummer(telefonnummer);
        updatePerson.setEmail(email);
        //Hämtar värde(id) från förra intent för att sedan hämta objektets index i personlistan
        String objektID = getIntent().getStringExtra("id");
        int id = Integer.parseInt(objektID);
        Person getObjektOfId = MainActivity.personList.get(id);
        int objektIndex = MainActivity.personList.indexOf(getObjektOfId);
        //Uppdaterar objekt i listan och listview
        MainActivity.personList.set(objektIndex, updatePerson);
        MainActivity.listView.deferNotifyDataSetChanged();
    }
}