package com.dreamteam.model;
public class RecipeToIngredient {
	
	private long id_przepis_skladnik;
	private int id_przepis;
	private int id_skladnik;
	private int ilosc;

	public int getId_przepis() {
		return id_przepis;
	}

	public void setId_przepis(int id_przepis) {
		this.id_przepis = id_przepis;
	}

	public int getId_skladnik() {
		return id_skladnik;
	}

	public void setId_skladnik(int id_skladnik) {
		this.id_skladnik = id_skladnik;
	}

	public long getId_przepis_skladnik() {
		return id_przepis_skladnik;
	}

	public void setId_przepis_skladnik(long id_przepis_skladnik) {
		this.id_przepis_skladnik = id_przepis_skladnik;
	}

	public int getIlosc() {
		return ilosc;
	}

	public void setIlosc(int ilosc) {
		this.ilosc = ilosc;
	}

}
