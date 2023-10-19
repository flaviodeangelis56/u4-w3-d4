package flaviodeangelis.entities;

import javax.persistence.Entity;

@Entity
public class Concerto extends Evento {
GenereConcerto genere;
Boolean inStreaming ;

public Concerto() {

}

    public Concerto(String titolo, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location, GenereConcerto genere,Boolean inStreaming) {
        super(titolo, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.genere = genere;
        this.inStreaming = inStreaming;
    }

    public GenereConcerto getGenere() {
        return genere;
    }

    public void setGenere(GenereConcerto genere) {
        this.genere = genere;
    }

    public Boolean getInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(Boolean inStreaming) {
        this.inStreaming = inStreaming;
    }
}
