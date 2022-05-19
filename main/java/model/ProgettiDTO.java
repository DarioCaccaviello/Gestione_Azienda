package model;

public class ProgettiDTO {
	
	private String nomeProgetto;
	private Double costo;
	private String descrizione;
	private String linkImg;
	
	private int idWorking;
	private int idDipendente;
	private int idProgetto;
	
	public String getNomeProgetto() {
		return nomeProgetto;
	}
	public void setNomeProgetto(String nomeProgetto) {
		this.nomeProgetto = nomeProgetto;
	}
	public Double getCosto() {
		return costo;
	}
	public void setCosto(Double costo) {
		this.costo = costo;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getLinkImg() {
		return linkImg;
	}
	public void setLinkImg(String linkImg) {
		this.linkImg = linkImg;
	}
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
	public ProgettiDTO(String nomeProgetto, Double costo, String descrizione, String linkImg, int idWorking,
			int idDipendente, int idProgetto) {
		super();
		this.nomeProgetto = nomeProgetto;
		this.costo = costo;
		this.descrizione = descrizione;
		this.linkImg = linkImg;
		this.idWorking = idWorking;
		this.idDipendente = idDipendente;
		this.idProgetto = idProgetto;
	}
	public ProgettiDTO() {
		
	}
	
	
	
	
	
	
}
