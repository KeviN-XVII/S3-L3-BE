package KevinQuarta;

import KevinQuarta.dao.EventsDAO;
import KevinQuarta.entities.EventType;
import KevinQuarta.entities.Evento;
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






             
        em.close();
        emf.close();
    }
}