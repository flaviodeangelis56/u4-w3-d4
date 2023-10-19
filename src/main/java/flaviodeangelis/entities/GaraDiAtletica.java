package flaviodeangelis.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class GaraDiAtletica extends Evento {
    @ManyToMany
    @JoinTable(name = "gara_persona",
            joinColumns = @JoinColumn(name = "gara_id"),
            inverseJoinColumns = @JoinColumn(name = "persona_id"))
    Set<Persona> atleti;
    @ManyToOne
    @JoinColumn(name = "persona_id", nullable = false)
    Persona vincitore;

    public GaraDiAtletica() {

    }

    public GaraDiAtletica(String titolo, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location, Set<Persona> atleti, Persona vincitore) {
        super(titolo, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.atleti = atleti;
        this.vincitore = vincitore;
    }

    public Set<Persona> getAtleti() {
        return atleti;
    }

    public void setAtleti(Set<Persona> atleti) {
        this.atleti = atleti;
    }

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }
}
