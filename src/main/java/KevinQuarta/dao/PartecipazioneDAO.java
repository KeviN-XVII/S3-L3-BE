package KevinQuarta.dao;

import KevinQuarta.entities.Partecipazione;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;


public class PartecipazioneDAO {
	private EntityManager em;

	public PartecipazioneDAO(EntityManager em) {
		this.em = em;
	}
	public void save(Partecipazione attendance) {
		try {
			EntityTransaction t = em.getTransaction();
			t.begin();
			em.persist(attendance);
			t.commit();
			System.out.println("Partecipazione all'evento " + attendance.getEvent() + " per la persona " + attendance.getPartecipante().getCognome() + ", creata");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public Partecipazione findById(UUID id) {
		return em.find(Partecipazione.class, id);
	}

	public void findByIdAndDelete(UUID id) {
		try {
			EntityTransaction t = em.getTransaction();
			t.begin();
			Partecipazione found = em.find(Partecipazione.class, id);
			if (found != null) {
				em.remove(found);
				t.commit();
				System.out.println("Partecipazione cancellata");
			} else System.out.println("Partecipazione non trovata");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
