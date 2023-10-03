package org.example.data.model;

import jakarta.persistence.*;

@Entity
@Table(name = "rights_of_ownership")
public class RightOfOwnership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "form")
    private Form form;

    @ManyToOne
    @JoinColumn(name = "id_osbb")
    private Osbb osbb;

    @OneToOne
    @JoinColumn(name = "id_building_flat")
    private BuildingFlat buildingFlat;

    @ManyToOne
    @JoinColumn(name = "id_right")
    private RightToEntry rightToEntry;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public Osbb getOsbb() {
        return osbb;
    }

    public void setOsbb(Osbb osbb) {
        this.osbb = osbb;
    }

    public BuildingFlat getBuildingFlat() {
        return buildingFlat;
    }

    public void setBuildingFlat(BuildingFlat buildingFlat) {
        this.buildingFlat = buildingFlat;
    }

    public RightToEntry getRightToEntry() {
        return rightToEntry;
    }

    public void setRightToEntry(RightToEntry rightToEntry) {
        this.rightToEntry = rightToEntry;
    }
}
