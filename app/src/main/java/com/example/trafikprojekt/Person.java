package com.example.trafikprojekt;

public class Person {
    private int id;
    private String fornamn;
    private String efternamn;
    private long pnummer = 190011019999L;
    private String adress;
    private int telefonnummer = 0702223344;
    private String email = "example@gmail.com";

    public Person(){}
    public Person(int id, String fornamn, String efternamn, String adress){
        this.id = id;
        this.fornamn = fornamn;
        this.efternamn = efternamn;
        this.adress = adress;
    }
    public Person(String fornamn, String efternamn, long pnummer, int telefonnummer, String adress, String email){
        this.fornamn = fornamn;
        this.efternamn = efternamn;
        this.pnummer = pnummer;
        this.telefonnummer = telefonnummer;
        this.adress = adress;
        this.email = email;
    }
    public Person(int id, String fornamn, String efternamn, long pnummer, int telefonnummer, String adress, String email){
        this.id = id;
        this.fornamn = fornamn;
        this.efternamn = efternamn;
        this.pnummer = pnummer;
        this.telefonnummer = telefonnummer;
        this.adress = adress;
        this.email = email;
    }

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFornamn() {
        return this.fornamn;
    }
    public void setFornamn(String fornamn) {
        this.fornamn = fornamn;
    }
    public String getEfternamn() {
        return this.efternamn;
    }
    public void setEfternamn(String efternamn) {
        this.efternamn = efternamn;
    }
    public long getPnummer() {
        return pnummer;
    }
    public void setPnummer(long pnummer) {
        this.pnummer = pnummer;
    }
    public long getTelefonnummer() {
        return telefonnummer;
    }
    public void setTelefonnummer(int telefonnummer) {
        this.telefonnummer = telefonnummer;
    }
    public String getAdress() {
        return adress;
    }
    public void setAdress(String adress) {
        this.adress = adress;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Id: "+id+"Namn: '"+fornamn+"''"+efternamn+"'\nPersonnummer: "+pnummer+"\ntelefonnummer"+telefonnummer+"\nAddress"+adress+"\nEmail: "+email;
    }
}
