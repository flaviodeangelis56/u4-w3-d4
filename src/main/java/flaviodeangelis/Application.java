package flaviodeangelis;

import flaviodeangelis.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
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
            Concerto concerto6 = new Concerto("concerto6", "descrizione concerto6", TipoEvento.PRIVATO, 10, l, GenereConcerto.CLASSICO, true);
            //PartitaDiCalcio partita3 = new PartitaDiCalcio("Partita3", "descrizione partita3", TipoEvento.PUBBLICO, 2000, l, "roma", "lazio", 1, 2);
            //eDAO.save(partita3);


            //----------------------------------getConcertiInStreaming----------------------------------
            //List<Concerto> concertiStreaming = eDAO.getConcertiInStreaming(false);
            //concertiStreaming.forEach(System.out::println);
            //----------------------------------getConcertiPerGenere----------------------------------
            // List<Concerto> concertiGenere = eDAO.getConcertiPerGenere(GenereConcerto.POP);
            // concertiGenere.forEach(System.out::println);
            //----------------------------------getPartiteVinteInCasa----------------------------------
            PartitaDiCalcio partita1 = (PartitaDiCalcio) eDAO.getById(30);
            PartitaDiCalcio partita2 = (PartitaDiCalcio) eDAO.getById(31);
            PartitaDiCalcio partita3 = (PartitaDiCalcio) eDAO.getById(32);
            List<PartitaDiCalcio> partite = new ArrayList<>();
            partite.add(partita1);
            partite.add(partita2);
            partite.add(partita3);
            List<PartitaDiCalcio> casaVince = eDAO.getPartiteVinteInCasa(partite);
            casaVince.forEach(System.out::println);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            em.close();
            emf.close();
        }

    }
}
