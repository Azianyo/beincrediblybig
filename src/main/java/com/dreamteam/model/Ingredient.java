package com.dreamteam.model;

/**
 * Created by macie_000 on 2015-06-27.
 */
import java.io.File;
import java.io.FileInputStream;
public class Ingredient {

    private long id_skladnik;
    private String nazwa;

    public long getId_skladnik() {
        return id_skladnik;
    }

    public void setId_skladnik(long id_skladnik) {
        this.id_skladnik = id_skladnik;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
}

