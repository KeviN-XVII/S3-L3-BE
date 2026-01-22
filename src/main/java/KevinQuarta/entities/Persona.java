package KevinQuarta.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "persone")
public class Persona {
//    1 ID
    @Id
    @GeneratedValue
    @Column(name = "persona_id")
    private UUID id;

//    2 NOME
    @Column(name="nome_persona")
    private String nome;


//    3 COGNOME
    @Column(name="cognome_persona")
    private String cognome;


//    4 EMAIL
    @Column(name="email_persona")
    private String email;


//    5 DATA
    @Column(name="data_di_nascita")
    private LocalDate dataDiNascita;


//    6 SESSO
    @Column(name="sesso")
    @Enumerated(EnumType.STRING)
    private Sesso sesso;


//    oneToMany partecipazioni
    @OneToMany(mappedBy = "partecipante")
    private List<Partecipazione> partecipazioni;

    public Persona() {}

    public Persona(String nome, String cognome, String email, LocalDate dataDiNascita, Sesso sesso) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataDiNascita = dataDiNascita;
        this.sesso = sesso;
    }

    public UUID getId() {
        return id;
    }


    private List<Partecipazione> getPartecipazioni() {
        return partecipazioni;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public Sesso getSesso() {
        return sesso;
    }

    public void setSesso(Sesso sesso) {
        this.sesso = sesso;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                ", sesso=" + sesso +
                ", partecipazioni=" + partecipazioni +
                '}';
    }
}
