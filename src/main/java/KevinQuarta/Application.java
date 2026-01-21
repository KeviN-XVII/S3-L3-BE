package KevinQuarta;

import KevinQuarta.dao.EventsDAO;
import KevinQuarta.entities.EventType;
import KevinQuarta.entities.Evento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("S3L2BE");
    // Per connetterci al DB dobbiamo aggiungere al main un attributo statico di tipo EntityManagerFactory che sfrutterà
    // la Persistence Unit definita in persistence.xml per connettersi al DB (dobbiamo quindi passargli come parametro il nome della PU)

    public static void main(String[] args) {
        // Oggetto speciale che gestisce tutte le interazioni con il DB
        EntityManager entityManager = emf.createEntityManager();
        EventsDAO eventsDAO = new EventsDAO(entityManager);

        Evento concerto = new Evento("Pupo", LocalDate.of(2026, 7, 17),"pupo a sansiro quest'estate", EventType.PUBBLICO,20000);
        Evento fiera = new Evento("Fiera moto", LocalDate.of(2026, 7, 28),"Tutte le moto in uscita 2027", EventType.PUBBLICO,20000);
        Evento riunione = new Evento("riunione", LocalDate.of(2026, 5, 13),"Riunione privata", EventType.PRIVATO,20);



        eventsDAO.save(concerto);
        Evento eventoById = eventsDAO.getById(1);
        System.out.println(eventoById);

        // Best Practice. Quando finisco di utilizzare delle risorse come Scanner, EntityManager, EntityManagerFactory, ecc è sempre consigliato chiuderle
        // (nel nostro caso è irrilevante perché l'applicazione si avvia e poi si chiude rilasciando tutte le risorse automaticamente)
        entityManager.close();
        emf.close();
    }
}