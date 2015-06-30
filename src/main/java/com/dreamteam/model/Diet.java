package com.dreamteam.model;

import com.dreamteam.dao.recipeDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Mateusz on 2015-06-30.
 */
public class Diet {
    private List<Recipe> FirstMeal;
    private List<Recipe> SecondMeal;
    private List<Recipe> ThirdMeal;
    private List<Recipe> FourthMeal;
    private List<Recipe> FifthMeal;
    private List<List<Recipe>> Days;

    public void set_Days(List<List<Recipe>> Days){
        this.Days = Days;
    }

    public void set_FirstMeal(List<Recipe> Meal){
       this.FirstMeal = Meal;
   }
    public void set_SecondMeal(List<Recipe> Meal){
        this.SecondMeal = Meal;
    }
    public void set_ThirdMeal(List<Recipe> Meal){
        this.ThirdMeal = Meal;
    }
    public void set_FourthMeal(List<Recipe> Meal){
        this.FourthMeal = Meal;
    }
    public void set_FifthMeal(List<Recipe> Meal){
        this.FifthMeal = Meal;
    }
    public List<Recipe> get_FirstMeal(){
        return this.FirstMeal;
    }
    public List<Recipe> get_SecondMeal(){
        return this.SecondMeal;
    }
    public List<Recipe> get_ThirdMeal(){
        return this.ThirdMeal;
    }
    public List<Recipe> get_FourthMeal(){
        return this.FourthMeal;
    }
    public List<Recipe> get_FifthMeal(){
        return this.FifthMeal;
    }
    public List<List<Recipe>> get_Days() {
       return this.Days;
    }

    public Diet(){
        set_FirstMeal(new ArrayList<Recipe>());
        set_SecondMeal(new ArrayList<Recipe>());
        set_ThirdMeal(new ArrayList<Recipe>());
        set_FourthMeal(new ArrayList<Recipe>());
        set_FifthMeal(new ArrayList<Recipe>());
        set_Days(new ArrayList<List<Recipe>>());
        this.Days.add(this.FirstMeal);
        this.Days.add(this.SecondMeal);
        this.Days.add(this.ThirdMeal);
        this.Days.add(this.FourthMeal);
        this.Days.add(this.FifthMeal);

    }

}
