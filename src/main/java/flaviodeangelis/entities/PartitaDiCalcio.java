package flaviodeangelis.entities;

import javax.persistence.Entity;

@Entity
public class PartitaDiCalcio extends Evento{
   private String squadraDiCasa;
    private String squadraOspite;
    private String squadraVincente;
    private int numeroGolSquadraCasa;
    private int numeroGolSquadraOspite;

    public  PartitaDiCalcio (){

    }

    public PartitaDiCalcio(String titolo, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location,String squadraDiCasa,String squadraOspite,int numeroGolSquadraCasa,int numeroGolSquadraOspite) {
        super(titolo, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.squadraDiCasa = squadraDiCasa;
        this.squadraOspite = squadraOspite;
        this.numeroGolSquadraCasa = numeroGolSquadraCasa;
        this.numeroGolSquadraOspite = numeroGolSquadraOspite;
        if (numeroGolSquadraCasa > numeroGolSquadraOspite) {
            this.squadraVincente = squadraDiCasa;
        } else if (numeroGolSquadraCasa < numeroGolSquadraOspite) {
            this.squadraVincente = squadraOspite;
        } else {
            this.squadraVincente = null;
        }
    }

    public String getSquadraDiCasa() {
        return squadraDiCasa;
    }

    public void setSquadraDiCasa(String squadraDiCasa) {
        this.squadraDiCasa = squadraDiCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public String getSquadraVincente() {
        return squadraVincente;
    }

    public void setSquadraVincente(String squadraVincente) {
        this.squadraVincente = squadraVincente;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public int getNumeroGolSquadraCasa() {
        return numeroGolSquadraCasa;
    }

    public void setNumeroGolSquadraCasa(int numeroGolSquadraCasa) {
        this.numeroGolSquadraCasa = numeroGolSquadraCasa;
    }

    public int getNumeroGolSquadraOspite() {
        return numeroGolSquadraOspite;
    }

    public void setNumeroGolSquadraOspite(int numeroGolSquadraOspite) {
        this.numeroGolSquadraOspite = numeroGolSquadraOspite;
    }
}
