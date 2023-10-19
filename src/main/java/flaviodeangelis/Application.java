package flaviodeangelis;

import flaviodeangelis.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Date;
import java.util.List;

import static flaviodeangelis.utils.JpaUtil.getEntityManagerFactory;

public class Application {
    private static final EntityManagerFactory emf = getEntityManagerFactory();


    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        try {
            EventoDAO eDAO = new EventoDAO(em);
            LocationDAO lDAO = new LocationDAO(em);
            PartecipazioneDAO pDAO = new PartecipazioneDAO(em);
            PersonaDAO persDAO = new PersonaDAO(em);
            System.out.println("Hello World!");
            Date flavioDate = new Date(2002, 10, 21);
            Location olimpico = new Location("stadio olimpico", "roma");
            //lDAO.save(olimpico);
            Location l = lDAO.getById(19);
            Persona flavio = new Persona("flavio", "deangelis", "email@gmail.com", flavioDate, Genere.M);
            Concerto concerto2 = new Concerto("concerto2", "descrizione concerto2", TipoEvento.PRIVATO, 10, l, GenereConcerto.CLASSICO, false);

            //  eDAO.save(concerto2);
            List<Concerto> concertiStreaming = eDAO.getConcertiInStreaming(false);
            concertiStreaming.forEach(System.out::println);
            // Evento e = eDAO.getById(10);
            //  Persona p = persDAO.getById(12);
            //lDAO.save(olimpico);
            // Evento test = new Evento("testOlimpico", "description of test1", TipoEvento.PRIVATO, 5, l);
            //  if (l != null) {
            //     Partecipazione test = new Partecipazione("flavio", "testOlimpico", StatoPartecipazione.CONFERMATA, e, p);
            // eDAO.save(test);
            //pDAO.save(test);
            // } else {
            //     System.out.println("location non trovata");
            //   }

            //  p.getListaPartecipazioni().forEach(partecipazione -> System.out.println(partecipazione));


        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            em.close();
            emf.close();
        }

    }
}
