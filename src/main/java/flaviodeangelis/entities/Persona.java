package flaviodeangelis.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "persone")
public class Persona {
    @Id
    @GeneratedValue
    long id;
    String nome;
    String cognome;
    String email;
    Date dataDiNascita;
    @Enumerated(EnumType.STRING)
    Genere sesso;
    @OneToMany(mappedBy = "persona")
    List<Partecipazione> ListaPartecipazioni;
    @ManyToMany
    @JoinTable(name = "gara_persona",
            joinColumns = @JoinColumn(name = "persona_id"),
            inverseJoinColumns = @JoinColumn(name = "gara_id"))
    Set<GaraDiAtletica> garaDiAtletica;
    @OneToMany(mappedBy = "vincitore")
    Set<GaraDiAtletica> vincitore;

    public Persona() {
    }

    public Persona(String nome, String cognome, String email, Date dataDiNascita, Genere sesso) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataDiNascita = dataDiNascita;
        this.sesso = sesso;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(Date dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public Genere getSesso() {
        return sesso;
    }

    public List<Partecipazione> getListaPartecipazioni() {
        return ListaPartecipazioni;
    }

    public void setListaPartecipazioni(List<Partecipazione> listaPartecipazioni) {
        ListaPartecipazioni = listaPartecipazioni;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                ", sesso=" + sesso +
                '}';
    }
}
