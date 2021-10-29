package com.example.trafikprojekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreateActivity extends AppCompatActivity {

    static int newId = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
    }

    public void btnSave_onClick(View view) {
        createPerson();
        //Skapar & öppnar en ny sida
        Intent nySida = new Intent( this, MainActivity.class);
        startActivity(nySida);
    }
    public void createPerson(){
        //hämtar värden från vyn
        EditText editFornamn = (EditText)findViewById(R.id.fornamnEditText);
        EditText editEfternamn = (EditText)findViewById(R.id.efternamnEditText);
        EditText editPnummer = (EditText)findViewById(R.id.pnummerEditText);
        EditText editAdress = (EditText)findViewById(R.id.adressEditText);
        EditText editTelefonnummer = (EditText)findViewById(R.id.telefonnummerEditText);
        EditText editEmail = (EditText)findViewById(R.id.emailEditText);
        //omvandlar till text
        String fornamn = editFornamn.getText().toString();
        String efternamn = editEfternamn.getText().toString();
        long pnummer = Long.parseLong(editPnummer.getText().toString());
        String adress = editAdress.getText().toString();
        int telefonnummer = Integer.parseInt(editTelefonnummer.getText().toString());
        String email = editEmail.getText().toString();
        //Skapar objekt med värden
        Person person = new Person();
        newId+=1;
        person.setId(newId);
        person.setFornamn(fornamn);
        person.setEfternamn(efternamn);
        person.setPnummer(pnummer);
        person.setAdress(adress);
        person.setTelefonnummer(telefonnummer);
        person.setEmail(email);
        //sparar objektet i listan och uppdaterar listview
        MainActivity.personList.add(person);
        MainActivity.listView.deferNotifyDataSetChanged();
    }
}