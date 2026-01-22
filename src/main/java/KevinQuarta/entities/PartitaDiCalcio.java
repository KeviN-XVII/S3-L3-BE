package KevinQuarta.entities;


import jakarta.persistence.*;

@Entity
@Table(name="partite_di_calcio")
@PrimaryKeyJoinColumn(name="evento_id")
public class PartitaDiCalcio extends Evento{
//    @Column(name="")
//    @Column(name="")
//    @Column(name="")
//    @Column(name="")
//    @Column(name="")
}
