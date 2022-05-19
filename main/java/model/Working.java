package model;

public class Working {

	private int idWorking;
	private int idDipendente;
	private int idProgetto;
	public int getIdWorking() {
		return idWorking;
	}
	public void setIdWorking(int idWorking) {
		this.idWorking = idWorking;
	}
	public int getIdDipendente() {
		return idDipendente;
	}
	public void setIdDipendente(int idDipendente) {
		this.idDipendente = idDipendente;
	}
	public int getIdProgetto() {
		return idProgetto;
	}
	public void setIdProgetto(int idProgetto) {
		this.idProgetto = idProgetto;
	}
	@Override
	public String toString() {
		return "Working [idWorking=" + idWorking + ", idDipendente=" + idDipendente + ", idProgetto=" + idProgetto
				+ "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
