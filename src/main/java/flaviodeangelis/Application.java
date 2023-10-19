package flaviodeangelis;

import flaviodeangelis.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.*;

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
            Persona persona2 = new Persona("elena", "deangelis", "email@gmail.com", flavioDate, Genere.F);
            Persona p1 = persDAO.getById(34);
            Persona p2 = persDAO.getById(34);
            Persona p3 = persDAO.getById(34);
            Set<Persona> partecipantiGara = new HashSet<>();
            partecipantiGara.add(p1);
            partecipantiGara.add(p2);
            partecipantiGara.add(p3);
            Concerto concerto6 = new Concerto("concerto6", "descrizione concerto6", TipoEvento.PRIVATO, 10, l, GenereConcerto.CLASSICO, true);
            GaraDiAtletica gara1 = new GaraDiAtletica("gara1", "descrizione gara 1", TipoEvento.PUBBLICO, 5, l, partecipantiGara, p1);
            //eDAO.save(gara1);
            //PartitaDiCalcio partita4 = new PartitaDiCalcio("Partita4", "descrizione partita4", TipoEvento.PUBBLICO, 2000, l, "roma", "lazio", 1, 1);
            // eDAO.save(partita4);
            //persDAO.save(persona2);

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
            PartitaDiCalcio partita4 = (PartitaDiCalcio) eDAO.getById(33);
            List<PartitaDiCalcio> partite = new ArrayList<>();
            partite.add(partita1);
            partite.add(partita2);
            partite.add(partita3);
            partite.add(partita4);
            //List<PartitaDiCalcio> casaVince = eDAO.getPartiteVinteInCasa(partite);
            //casaVince.forEach(System.out::println);
            //---------------------------------- getPartiteVinteInTrasferta----------------------------------
            //List<PartitaDiCalcio> trasfertaVince = eDAO.getPartiteVinteInTrasferta(partite);
            //trasfertaVince.forEach(System.out::println);
            //---------------------------------- getPartitePareggiate----------------------------------
            // List<PartitaDiCalcio> pareggio = eDAO.getPartitePareggiate();
            // pareggio.forEach(System.out::println);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            em.close();
            emf.close();
        }

    }
}
