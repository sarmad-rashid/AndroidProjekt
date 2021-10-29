package com.example.trafikprojekt;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.LinkedList;
import java.util.List;

public class MySQLite extends SQLiteOpenHelper {

    public MySQLite(Context context){ super(context, "PersonDB", null, 1); }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //SQL kod för att skapa tabell i databas
        String CREATE_TABLE_PERSON = "CREATE TABLE Persons ( "+
                "Id INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "Fornamn TEXT, "+
                "Efternamn TEXT)";
        //Skapar tabellen
        db.execSQL(CREATE_TABLE_PERSON);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Ta bort gammal tabell om databasen uppgraderas
        db.execSQL("DROP TABLE IF EXISTS Persons");
        //Startar om onCreate metoden och skapar ny tabell om den gamla är raderad
        this.onCreate(db);
    }

    //Funktion som hämtar en lista av objektet Person
    public List<Person> getAllPersons(){
        List<Person> personList = new LinkedList<Person>();
        //SQL query
        String query = "SELECT * FROM Persons";
        //Hämtar databas
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        //Läs varje rad i databasen och skapa objekt från dem
        Person person = null;
        if (cursor.moveToFirst()){
            do {
                person = new Person();
                person.setId(Integer.parseInt(cursor.getString(0)));
                person.setFornamn(cursor.getString(1));
                person.setEfternamn(cursor.getString(2));
                personList.add(person);
            } while (cursor.moveToNext());
        }
        return personList;
    }
    public void addPerson(Person person){
        //Hämtar databasen
        SQLiteDatabase db = this.getWritableDatabase();
        //Skapar ContentValues som skrivs som "column" värden
        ContentValues values = new ContentValues();
        values.put("Fornamn", person.getFornamn());
        values.put("Efternamn", person.getEfternamn());
        //Lägg till i tabellen
        db.insert("Persons",null, values);
        //Stänger databasen
        db.close();
    }
}
