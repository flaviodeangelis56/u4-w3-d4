package flaviodeangelis.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class EventoDAO {

    private final EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento e) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(e);
        transaction.commit();
        System.out.println("L'evento" + e + "salvato nel DB in modo corretto");
    }

    public Evento getById(long id) {
        return em.find(Evento.class, id);
    }

    public void delate(long id) {
        Evento eventoById = em.find(Evento.class, id);
        if (eventoById != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(eventoById);
            transaction.commit();
        } else {
            System.err.println("Evento con id" + id + "non esistente");
        }
    }

    public void refresh(Evento e) {
        em.refresh(e);
    }


    public List<Concerto> getConcertiInStreaming(boolean streaming) {
        TypedQuery<Concerto> getConcertiStreaming = em.createQuery("SELECT c FROM Concerto c WHERE c.inStreaming = :streaming", Concerto.class);
        getConcertiStreaming.setParameter("streaming", streaming);
        return getConcertiStreaming.getResultList();
    }

    public List<Concerto> getConcertiPerGenere(GenereConcerto genere) {
        TypedQuery<Concerto> getConcertiGenere = em.createQuery("SELECT c FROM Concerto c WHERE c.genere = :genere", Concerto.class);
        getConcertiGenere.setParameter("genere", genere);
        return getConcertiGenere.getResultList();
    }

    public List<PartitaDiCalcio> getPartiteVinteInCasa(List<PartitaDiCalcio> partite) {
        TypedQuery<PartitaDiCalcio> getCasaVince = em.createNamedQuery("Evento.getPartiteVinteInCasa", PartitaDiCalcio.class);
        partite.forEach(squadracasa -> getCasaVince.setParameter("squadracasa", squadracasa.getSquadraDiCasa()));
        return getCasaVince.getResultList();
    }
}

