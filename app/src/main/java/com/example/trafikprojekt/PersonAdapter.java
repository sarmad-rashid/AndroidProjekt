package com.example.trafikprojekt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class PersonAdapter extends BaseAdapter {

    ArrayList<Person> personList = new ArrayList<>();
    Context mContext;

    public PersonAdapter(Context context, ArrayList<Person> personList){
        mContext = context;
        this.personList = personList;
    }

    @Override
    public int getCount() {
        return personList.size();
    }
    @Override
    public Object getItem(int position) {
        return personList.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_view,parent,false);
        }
        Person tempPerson = (Person) getItem(position);
        TextView fornamn = (TextView)convertView.findViewById(R.id.fornamnListView);
        TextView efternamn = (TextView)convertView.findViewById(R.id.efternamnListView);
        TextView adress = (TextView)convertView.findViewById(R.id.adressListView);
        fornamn.setText(tempPerson.getFornamn());
        efternamn.setText(tempPerson.getEfternamn());
        adress.setText(tempPerson.getAdress());

        return convertView;
    }
}
