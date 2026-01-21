package KevinQuarta.entities;
//se voglio che venga mappata devo definirla come entity @Entity
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
// Annotazione obbligatoria. Ci serve per definire che questa classe dovrà venir mappata ad una specifica tabella nel DB
// Sarà Hibernate a creare in automatico la tabella in questione (oppure se già esistente proverà a modificarla secondo quanto trova in questa classe)
// se utilizziamo l'impostazione <property name="hibernate.hbm2ddl.auto" value="update"/> nel persistence.xml
// N.B. Non dobbiamo inoltre dimenticare di dichiarare questa classe dentro il persistence.xml <class>KevinQuarta.entities.Evento</class>
@Table(name="events")
public class Evento {

    //    1 ID
    @Id //Dichiaro che questo attributo dovrà corrispondere alla colonna PRIMARY KEY della tabella events
    @GeneratedValue (strategy = GenerationType.IDENTITY) // Annotazione OPZIONALE però molto consigliata. Serve per chiedere al DB di generare lui
    // i valori per la PK. IDENTITY significa che invece di biginteger vogliamo usare un bigserial
    private long id;


    //   2 TITOLO
    @Column(name="nome_evento", nullable=false,length = 30)
    private String nome;


    //   3 DATA EVENTO
    @Column(name="data_evento", nullable=false)
    private LocalDate dataEvento;


    //   4 DESCRIZIONE
    @Column(name="descrizione_evento", nullable=false,columnDefinition = "TEXT")
    private String descrizione;


    //   5 TIPO EVENTO
    @Column(name="type",nullable = false)
    @Enumerated(EnumType.STRING)  // serve a rendere i valori enum in stringhe e non numeri,Gli ENUM di default vengono "convertiti" in smallint (che non è quello che probabilmente vogliamo)
    // Tramite @Enumerated(EnumType.STRING) specifico che la colonna dovrà essere di tipo varchar
    private EventType tipoEvento;


    //   6 NUMERO MASSIMO PARTECIPANTI
    @Column(name="partecipanti_evento_max",nullable = false)
    private int numMaxParticipanti;



    public Evento() {
        // OBBLIGATORIO PER TUTTE LE ENTITIES AVERE UN COSTRUTTORE VUOTO! Viene usato da JPA per costruire degli oggetti quando
        // leggeremo delle righe dalla tabella
    }


    public Evento(String name, LocalDate dataEvento, String descrizione, EventType tipoEvento, int numMaxParticipanti) {
        this.nome = name;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numMaxParticipanti = numMaxParticipanti;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public EventType getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(EventType tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public int getNumMaxParticipanti() {
        return numMaxParticipanti;
    }

    public void setNumMaxParticipanti(int numMaxParticipanti) {
        this.numMaxParticipanti = numMaxParticipanti;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataEvento=" + dataEvento +
                ", descrizione='" + descrizione + '\'' +
                ", tipoEvento=" + tipoEvento +
                ", numMaxParticipanti=" + numMaxParticipanti +
                '}';
    }
}