package model;

public class Progetto {

	private String nomeProgetto;
	private Double costo;
	private String descrizione;
	private String linkImg;
	
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
	@Override
	public String toString() {
		return "Progetto [nomeProgetto=" + nomeProgetto + ", costo=" + costo + ", descrizione=" + descrizione
				+ ", linkImg=" + linkImg + "]";
	}
	public Progetto(String nomeProgetto, Double costo, String descrizione, String linkImg) {
		super();
		this.nomeProgetto = nomeProgetto;
		this.costo = costo;
		this.descrizione = descrizione;
		this.linkImg = linkImg;
	}
	
	
	public Progetto() {
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
