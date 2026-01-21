package KevinQuarta.dao;

import KevinQuarta.entities.Evento;
import KevinQuarta.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EventsDAO {

    // DAO (Data Access Object) è un Design Pattern. E' una classe speciale che ci serve per interagire in maniera semplice con il DB.
    // Le operazioni normali come salvare o leggere dei record, richiedono l'uso dell'EntityManager con una certa complessità. Il DAO quindi
    // si occupa di nascondere questa complessità fornendo a chi ne avrà bisogno dei metodi semplici da usare
    private EntityManager entityManager;

    public EventsDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Evento newEvento) {
        // 1. Chiediamo all'EntityManager di creare una nuova transazione
        EntityTransaction transaction = entityManager.getTransaction();

        // 2. Facciamo partire la transazione
        transaction.begin();

        // 3. Aggiungiamo il newEvento al PersistenceContext, in quanto esso è nuovo e non ancora MANAGED. Lo possiamo
        // fare tramite metodo .persist() dell'EntityManager (a sto punto l'oggetto non è ancora parte del DB però)
        entityManager.persist(newEvento);

        // 4. Per rendere effettiva l'operazione, cioè per far si chè newStudent diventi una nuova riga nel DB, devo fare il COMMIT della transazione
        transaction.commit();

        // 5. Log di avvenuto salvataggio
        System.out.println("L'Evento " + newEvento.getNome() + " è stato salvato correttamente nel DB!");

    }

    public Evento getById (long eventId) {
        Evento found = entityManager.find(Evento.class, eventId);
        if (found == null) throw new NotFoundException(eventId);
        return found;
    }


    public void findByIdAndDelete(long eventId) {
        // 1. Cerco l'evento tramite id nel DB
        Evento found = this.getById(eventId);

        // 2. Chiediamo all'EntityManager di creare una nuova transazione
        EntityTransaction transaction = entityManager.getTransaction();

        // 3. Facciamo partire la transazione
        transaction.begin();

        // 4. Rimuoviamo dal Persistence Context l'oggetto in questione tramite metodo .remove() dell'EntityManager (l'oggetto non è però ancora
        // eliminato effettivamente dal DB)
        entityManager.remove(found);

        // 5. Per rendere effettiva l'operazione, cioè per far si chè l'evento venga cancellato dal DB, devo fare il COMMIT della transazione
        transaction.commit();

        // 6. Log di avvenuta cancellazione
        System.out.println("L'Evento con id: " + eventId + " è stato eliminato correttamente!");

    }


}