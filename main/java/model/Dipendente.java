package model;

import java.sql.Date;

public class Dipendente extends Persona{

	private Double stipendio;
	private int id;
	private int idPersona;
	
	
	public Double getStipendio() {
		return stipendio;
	}
	public void setStipendio(Double stipendio) {
		this.stipendio = stipendio;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdPersona() {
		return idPersona;
	}
	
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	
	
	
	@Override
	public String toString() {
		return "Dipendente [stipendio=" + stipendio + ", id=" + id + ", idPersona=" + idPersona + "]";
	}
	public Dipendente(String nome, String cognome, String sesso, Date dataNascita, String cf, String luogoDiNascita,
			Double stipendio, int id, int idPersona) {
		super(nome, cognome, sesso, dataNascita, cf, luogoDiNascita);
		this.stipendio = stipendio;
		this.id = id;
		this.idPersona = idPersona;
	}
	
	public Dipendente() {
		
	}
	
	
	
	
}
