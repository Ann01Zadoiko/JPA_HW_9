package org.example.data.model;

import jakarta.persistence.*;

@Entity
@Table(name = "buildings_flats")
public class BuildingFlat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_building")
    private Building building;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_flat")
    private Flat flat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Flat getFlat() {
        return flat;
    }

    public void setFlat(Flat flat) {
        this.flat = flat;
    }
}

