package org.example.data.model;

import jakarta.persistence.*;

@Entity
@Table(name = "flats")
public class Flat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "number")
    private int number;

    @Column(name = "sqr")
    private int sqr;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getSqr() {
        return sqr;
    }

    public void setSqr(int sqr) {
        this.sqr = sqr;
    }
}
