package com.example.myapplication;

public class Employee {
    private final String name;   // name of the employee
    private final String email;  // email of the employee

    private final String invite;
    private final String km;
    private final String type;
    private final String about;
    private final int imageResource;

    public Employee(String name, String email , String invite, String km, String type, String about, int imageResource) {
        this.name = name;
        this.email = email;
        this.invite = invite;
        this.km=km;
        this.type=type;
        this.about=about;
        this.imageResource=imageResource;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getInvite() {
        return invite;
    }

    public String getKm() {
        return km;
    }

    public String getType() {
        return type;
    }

    public String getAbout() {
        return about;
    }

    public int getImageResource() {
        return imageResource;
    }
}
