package com.cognizant.spring_learn.model;

public class Skill {
    private int id;
    private String name;

    // Constructors
    public Skill() {
    }

    public Skill(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // toString method
    @Override
    public String toString() {
        return "Skill [id=" + id + ", name=" + name + "]";
    }
}

