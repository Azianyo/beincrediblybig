package com.dreamteam.model;

public class User {

    private long id_uzytkownik;
    private int isAdmin;
    private String haslo;
    private String email;

    public long getId_uzytkownik() {
        return id_uzytkownik;
    }
    public void setId_uzytkownik(long id_uzytkownik) {
        this.id_uzytkownik = id_uzytkownik;
    }
    public int getIsAdmin() {
        return isAdmin;
    }
    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }
    public String getHaslo() {
        return haslo;
    }
    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
