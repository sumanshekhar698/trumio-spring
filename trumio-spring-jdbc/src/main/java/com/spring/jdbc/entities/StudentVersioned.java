package com.spring.jdbc.entities;

public class StudentVersioned {// POJO

    private int id;
    private String name;
    private String city;
    private int version;

    public StudentVersioned(int id, String name, String city, int version) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.version = version;
    }

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "StudentVersioned{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", version=" + version +
                '}';
    }
}