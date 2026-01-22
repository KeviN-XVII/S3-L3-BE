package KevinQuarta;

import KevinQuarta.dao.EventsDAO;
import KevinQuarta.entities.EventType;
import KevinQuarta.entities.Evento;
import KevinQuarta.entities.PartitaDiCalcio;
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

        PartitaDiCalcio JuveVSNapoli = new PartitaDiCalcio("Juventus vs Napoli",LocalDate.of(2026,01,25),"Partita di Serie A",EventType.PUBBLICO,10200,"Juventus","Napoli",4,1);
        PartitaDiCalcio RomaVSMilan = new PartitaDiCalcio("Roma vs Milan",LocalDate.of(2026,01,25),"Partita di Serie A",EventType.PUBBLICO,15200,"Roma","Milan",2,2);

//        dao.save(JuveVSNapoli);
//        dao.save(RomaVSMilan);



        em.close();
        emf.close();
    }
}