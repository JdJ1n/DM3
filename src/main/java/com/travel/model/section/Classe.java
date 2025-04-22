package com.travel.model.section;

import java.util.Objects;

public class Classe {
    protected char id;
    protected String name;
    protected double rate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Classe classe)) return false;
        return id == classe.id && Double.compare(rate, classe.rate) == 0 && Objects.equals(name, classe.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, rate);
    }

    public Classe(char id, String name, double rate) {
        this.id = id;
        this.name = name;
        this.rate = rate;
    }

    public char getId() {
        return id;
    }

    public void setId(char id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Classe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rate=" + rate +
                '}';
    }
}
