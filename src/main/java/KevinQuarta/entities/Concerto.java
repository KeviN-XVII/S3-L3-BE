package KevinQuarta.entities;
import jakarta.persistence.*;

import java.beans.ConstructorProperties;
import java.time.LocalDate;

@Entity
@Table(name="concerto")
public class Concerto extends Evento {
    @Column(name="type_concerto",nullable = false)
    @Enumerated(EnumType.STRING)
    private ConcertoType tipoConcerto;

    @Column(name="streaming",nullable = false)
    private boolean streaming;

    public Concerto() {
    }

    public Concerto(String nome, LocalDate dataEvento, String descrizione, EventType type, int numMaxFan,ConcertoType tipoConcerto, boolean streaming) {
        super(nome,dataEvento,descrizione,type,numMaxFan);
        this.tipoConcerto = tipoConcerto;
        this.streaming = streaming;
    }

    public ConcertoType getTipoConcerto() {
        return tipoConcerto;
    }

    public void setTipoConcerto(ConcertoType tipoConcerto) {
        this.tipoConcerto = tipoConcerto;
    }

    public boolean isStreaming() {
        return streaming;
    }

    public void setStreaming(boolean streaming) {
        this.streaming = streaming;
    }

    @Override
    public String toString() {
        return "Concerto{" +
                "tipoConcerto=" + tipoConcerto +
                ", streaming=" + streaming +
                '}'+ super.toString();
    }
}
