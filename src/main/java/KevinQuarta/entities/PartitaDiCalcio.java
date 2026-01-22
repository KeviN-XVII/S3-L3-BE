package KevinQuarta.entities;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="partite_di_calcio")
public class PartitaDiCalcio extends Evento{
    @Column(name="squadra_casa",nullable=false)
    private String sqCasa;
    @Column(name="squadra_ospite",nullable=false)
    private String sqOspite;
    @Column(name="squadra_vincente",nullable=true)
    private String sqVincente;
    @Column(name="gol_casa",nullable=false)
    private int golCasa;
    @Column(name="gol_ospite",nullable=false)
    private int golOspite;

    public PartitaDiCalcio() {
    }

    public PartitaDiCalcio(String nome, LocalDate dataEvento,String descrizione,EventType type, int numMaxTifosi,String sqCasa, String sqOspite, int golCasa, int golOspite){
        super(nome,dataEvento,descrizione,type,numMaxTifosi);
       this.sqCasa = sqCasa;
       this.sqOspite = sqOspite;
       this.golCasa = golCasa;
       this.golOspite = golOspite;

       if (golCasa > golOspite){
           this.sqVincente = sqCasa;
       } else if (golOspite > golCasa) {
           this.sqVincente = sqOspite;
       } else  {
           this.sqVincente = null;
       }
    }

    public String getSqCasa() {
        return sqCasa;
    }

    public void setSqCasa(String sqCasa) {
        this.sqCasa = sqCasa;
    }

    public String getSqOspite() {
        return sqOspite;
    }

    public void setSqOspite(String sqOspite) {
        this.sqOspite = sqOspite;
    }

    public String getSqVincente() {
        return sqVincente;
    }

    public void setSqVincente(String sqVincente) {
        this.sqVincente = sqVincente;
    }

    public int getGolCasa() {
        return golCasa;
    }

    public void setGolCasa(int golCasa) {
        this.golCasa = golCasa;
    }

    public int getGolOspite() {
        return golOspite;
    }

    public void setGolOspite(int golOspite) {
        this.golOspite = golOspite;
    }

    @Override
    public String toString() {
        return "PartitaDiCalcio{" +
                "sqCasa='" + sqCasa + '\'' +
                ", sqOspite='" + sqOspite + '\'' +
                ", sqVincente='" + sqVincente + '\'' +
                ", golCasa=" + golCasa +
                ", golOspite=" + golOspite +
                '}'+ super.toString();
    }
}
