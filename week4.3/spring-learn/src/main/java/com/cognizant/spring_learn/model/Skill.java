package com.cognizant.spring_learn.model;

public class Skill {

    private int id;
    private String name;

    // Default constructor
    public Skill() {
    }

    // Parameterized constructor (optional)
    public Skill(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter for id
    public int getId() {
        return id;
    }

    // Setter for id
    public void setId(int id) {
        this.id = id;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // toString() (optional, for debugging)
    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
