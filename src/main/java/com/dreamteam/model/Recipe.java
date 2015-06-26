package com.dreamteam.model;
import java.io.File;
import java.io.FileInputStream;
public class Recipe {

    private long id_przepis;
    private String nazwa;
    private String opis;
    private int ocena;
    private int typ;
    private File zdjecie;

    public long getId_przepis() {
        return id_przepis;
    }
    public void setId_przepis(long id_przepis) {
        this.id_przepis = id_przepis;
    }
    public String getNazwa() {
        return nazwa;
    }
    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
    public String getOpis() {
        return opis;
    }
    public void setOpis(String opis) {
        this.opis = opis;
    }
    public int getOcena() {
        return ocena;
    }
    public void setOcena(int ocena) {
        this.ocena = ocena;
    }
    public File getZdjecie() {
        return this.zdjecie;
    }
    public void setZdjecie(File zdjecie) {
        this.zdjecie = zdjecie;
    }
    public int PhotoLen(){
        return (int)this.zdjecie.length();
    }
    public FileInputStream getPhotoStream(){
        FileInputStream photo=null;
        try {
            photo = new FileInputStream(this.zdjecie);
        }
        catch (java.io.FileNotFoundException ignored){}
        return photo;
    }
    public int getTyp() {
        return typ;
    }
    public void setTyp(int typ) {
        this.typ = typ;
    }
}

