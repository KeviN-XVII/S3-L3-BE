package KevinQuarta.entities;


import jakarta.persistence.*;

import jakarta.persistence.Entity;

import java.util.UUID;

@Entity
@Table(name="locations")
public class Location {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name="nome_location")
    private String nameLocation;

    @Column(name="citta")
    private String citta;

    public Location() {}

    public String getNome() {
        return nameLocation;
    }

    public void setNome(String nome) {
        this.nameLocation = nome;
    }

    public String getCitta() {
        return  citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    @Override
    public String toString() {
        return "Location [id=" + id + ", nome=" + getNome() + ", citta=" + citta + "]";
    }
}
