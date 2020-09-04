package com.bogdan.domain;

import javax.persistence.*;

@Entity
@Table(name = "recipes", schema = "spring_recipe")
public class Recipe {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "time")
    private String time;

    @Column(name = "ingredients")
    private String ingredients;

    @Column(name = "steps")
    private String steps;

    @Column(name = "kcal")
    private int kcal;

    @Column(name = "fat")
    private int fat;

    @Column(name = "sugars")
    private int sugars;

    @Column(name = "email")
    private String email;

    public Recipe() {
    }

    public Recipe(String name, String time, String ingredients, String steps,
                  int kcal, int fat, int sugars, String email) {

        this.name = name;
        this.time = time;
        this.ingredients = ingredients;
        this.steps = steps;
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

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
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
