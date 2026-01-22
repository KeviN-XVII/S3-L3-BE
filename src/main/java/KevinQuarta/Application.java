package KevinQuarta;

import KevinQuarta.dao.EventsDAO;
import KevinQuarta.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("s3l3bepu");
    // Per connetterci al DB dobbiamo aggiungere al main un attributo statico di tipo EntityManagerFactory che sfrutterà
    // la Persistence Unit definita in persistence.xml per connettersi al DB (dobbiamo quindi passargli come parametro il nome della PU)

    public static void main(String[] args) {
//         Oggetto speciale che gestisce tutte le interazioni con il
        EntityManager em = emf.createEntityManager();
        EventsDAO dao = new EventsDAO(em);

//        PARTITE DI CALCIO
        PartitaDiCalcio JuveVSNapoli = new PartitaDiCalcio("Juventus vs Napoli",LocalDate.of(2026,01,25),"Partita di Serie A",EventType.PUBBLICO,10200,"Juventus","Napoli",4,1);
        PartitaDiCalcio RomaVSMilan = new PartitaDiCalcio("Roma vs Milan",LocalDate.of(2026,01,25),"Partita di Serie A",EventType.PUBBLICO,15200,"Roma","Milan",2,2);


//        CONCERTO
        Concerto pupo = new Concerto("Pupo a San Siro",LocalDate.of(2026,07,17),"Pupo concerto",EventType.PUBBLICO,43000, ConcertoType.ROCK,true);

//        dao.save(JuveVSNapoli);
//        dao.save(RomaVSMilan);
//        dao.save(pupo);




        em.close();
        emf.close();
    }
}