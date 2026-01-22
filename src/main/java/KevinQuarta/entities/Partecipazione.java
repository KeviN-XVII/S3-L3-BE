package KevinQuarta.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="partecipazioni")
public class Partecipazione {

    @Id
    @GeneratedValue
    @Column(name="partecipazione_id")
    private UUID Id;

    @Column(name="stato")
    @Enumerated(EnumType.STRING)
    private Stato stato;


//    manyToOne persona
    @ManyToOne
    @JoinColumn(name="persona_id",nullable = false)
    private Persona partecipante;


// manyToOne evento
    @ManyToOne
    @JoinColumn(name="evento_id",nullable = false)
    private Evento event;


    public Partecipazione() {
    }

    public Partecipazione(Persona partecipante,Evento event,Stato stato) {

    }

    public UUID getId() {
        return Id;
    }

    public Stato getStato() {
        return stato;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }

    public Persona getPartecipante() {
        return partecipante;
    }

    public Evento getEvent() {
        return event;
    }

    @Override
    public String toString() {
        return "Partecipazione{" +
                "Id=" + Id +
                ", stato=" + stato +
                ", partecipante=" + partecipante +
                ", event=" + event +
                '}';
    }
}
