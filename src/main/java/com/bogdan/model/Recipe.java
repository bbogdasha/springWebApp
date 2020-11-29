package com.bogdan.model;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalTime;

@Entity
@Table(name = "recipes", schema = "spring_recipe")
public class Recipe {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Size(min = 2, max = 30)
    @Pattern(regexp = "[A-Z][a-z]+", message = "Must start with a capital letter followed by one or more lowercase letters!")
    @Column(name = "name", nullable = false)
    private String name;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime time;

    @Size(min = 5, max = 1000, message = "This field must contain at least one ingredient!")
    @Column(columnDefinition = "text", length = 1024)
    private String ingredients;

    @Size(min = 5, max = 1000, message = "This field should contain cooking steps (instructions)!")
    @Column(columnDefinition = "text", length = 1024)
    private String steps;

    @Range(min = 1, max = 999)
    private int kcal;

    @Range(min = 1, max = 99)
    private int fat;

    @Range(min = 1, max = 99)
    private int sugars;

    @Pattern(regexp = "[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}", message = "Must be a valid e-mail address!")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    private String filename;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    public Recipe() {
    }

    public Recipe(String name, LocalTime time, String ingredients, String steps,
                  int kcal, int fat, int sugars, String email, User author) {
        this.name = name;
        this.time = time;
        this.ingredients = ingredients;
        this.steps = steps;
        this.kcal = kcal;
        this.fat = fat;
        this.sugars = sugars;
        this.email = email;
        this.author = author;
    }

    public String getAuthorName() {
        return author != null ? author.getUsername() : "<none>";
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

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
