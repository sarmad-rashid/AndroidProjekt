package com.example.trafikprojekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Person> personList = new ArrayList<>();
    public static ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fillList();
        setAdapter();
        setListener();
    }
    private void fillList(){
        if (personList.isEmpty()){
        Person person0 = new Person(0,"Peter","Stormare", "Birger Jarlsgatan, Stockholm");
        personList.add(person0);
        Person person1 = new Person (1,"Alaxander","Skarsgård","Brantingsgatan, Göteborg");
        personList.add(person1);
        Person person2 = new Person(2,"Joel","Kinneman","Drottninggatan, Uddevalla");
        personList.add(person2);
        Person person3 = new Person(3,"Dolph","Lundgren","Melodivägen, Uddevalla");
        personList.add(person3);
        Person person4 = new Person(4,"Zlatan","Ibrahimovic","Friisgatan, Malmö");
        personList.add(person4);
        }
    }
    private void setAdapter(){
        listView = (ListView)findViewById(R.id.listView);
        PersonAdapter personAdapter = new PersonAdapter(MainActivity.this, personList);
        listView.setAdapter(personAdapter);
    }
    private void setListener(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Två sätt att hämta personobjekt
                //Person valdPerson = (Person)(listView.getItemAtPosition(position)); eller -->
                Person valdPerson = personList.get(position);

                //Skapar Toast meddelande
                String namn = valdPerson.getId()+", "+valdPerson.getFornamn()+" "+valdPerson.getEfternamn();
                Toast.makeText(MainActivity.this,"Du klickade på id: "+namn, Toast.LENGTH_SHORT).show();

                //Startar en ny sida med och skickar med valda personens id
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("id", ""+valdPerson.getId());
                startActivity(intent);
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                //Startar en ny sida med och skickar med valda personens id
                Intent intent = new Intent(MainActivity.this, UpdateActivity.class);
                Person valdPerson = personList.get(position);
                intent.putExtra("id", ""+valdPerson.getId());
                startActivity(intent);
                return true;
            }
        });
    }
    public void btnCreate_onClick(View view) {
        //till create sidan
        Intent createIntent = new Intent(this, CreateActivity.class);
        startActivity(createIntent);
    }

    /*private void readFromDatabase(){
        //Hämtar alla personer från databas
        List<Person> list = db.getAllPersons();
        //Sätter ihop alla värden till en string
        String allValues = "";
        for (Person person : list){
            allValues += person.getFornamn() + System.getProperty("line.separator");
        }
        //kopplar strängen till sidans vy
        TextView text = (TextView)findViewById(R.id.lblWelcome);
        text.setText(allValues);
    }*/

    /*//Skapar objekt med värden
    Person person = new Person();
        person.setFornamn(fornamn);
        person.setEfternamn(efternamn);
        db.addPerson(person);*/

    /*public void btnRadera_Click(View view) {
        SQLiteDatabase db1 = this.db.getWritableDatabase();
        db1.delete("Persons",null,null);
        db1.close();
        readFromDatabase();
    }*/
}