package KevinQuarta.dao;

import KevinQuarta.entities.Concerto;
import KevinQuarta.entities.Evento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.UUID;


public class EventsDAO {
    private EntityManager em;

    public EventsDAO(EntityManager em) {
        this.em = em;
    }


    public void save(Evento evento) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(evento);
            t.commit();
            System.out.println("Evento - " + evento.getNome() + " - creato!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Evento findById(UUID id) {
        return em.find(Evento.class, id);
    }

    public void findByIdAndDelete(UUID id) {
        try {
            EntityTransaction t = em.getTransaction();
            Evento found = em.find(Evento.class, id);
            if (found != null) {
                t.begin();
                em.remove(found);
                t.commit();
                System.out.println("Evento eliminato");
            } else System.out.println("Evento non trovato");


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
        public List<Concerto> getConcertiStreamingTrue(boolean streaming) {
            TypedQuery<Concerto> query = em.createQuery(
                    "SELECT c FROM Concerto c WHERE c.streaming = :streaming",
                    Concerto.class
            );
            query.setParameter("streaming", streaming);
        return query.getResultList();
        }
}
