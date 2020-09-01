package com.bogdan.domain;

import javax.persistence.*;

@Entity
@Table(name = "recipes", schema = "spring_recipe")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String time;
    private String ingredients;
    private String cookPlan;
    private int kcal;
    private int fat;
    private int sugars;
    private String email;

    public Recipe() {
    }

    public Recipe(String name, String time, String ingredients, String cookPlan,
                  int kcal, int fat, int sugars, String email) {

        this.name = name;
        this.time = time;
        this.ingredients = ingredients;
        this.cookPlan = cookPlan;
        this.kcal = kcal;
        this.fat = fat;
        this.sugars = sugars;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getCookPlan() {
        return cookPlan;
    }

    public void setCookPlan(String cookPlan) {
        this.cookPlan = cookPlan;
    }

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getSugars() {
        return sugars;
    }

    public void setSugars(int sugars) {
        this.sugars = sugars;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
