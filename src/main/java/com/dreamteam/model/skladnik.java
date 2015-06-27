package com.dreamteam.model;
import java.io.File;
import java.io.FileInputStream;
public class skladnik {

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
