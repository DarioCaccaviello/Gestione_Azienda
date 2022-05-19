package model;

import java.sql.Date;

public class Persona {

	private String nome;
	private String cognome;
	private String sesso;
	private Date dataNascita;
	private String cf;
	private String luogoDiNascita;
	private int id;
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getSesso() {
		return sesso;
	}
	public void setSesso(String sesso) {
		this.sesso = sesso;
	}
	public Date getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}
	public String getCf() {
		return cf;
	}
	public void setCf(String cf) {
		this.cf = cf;
	}
	public String getLuogoDiNascita() {
		return luogoDiNascita;
	}
	public void setLuogoDiNascita(String luogoDiNascita) {
		this.luogoDiNascita = luogoDiNascita;
	}
	@Override
	public String toString() {
		return "Persona [nome=" + nome + ", cognome=" + cognome + ", sesso=" + sesso + ", dataNascita=" + dataNascita
				+ ", cf=" + cf + ", luogoDiNascita=" + luogoDiNascita + "]";
	}
	public Persona(String nome, String cognome, String sesso, Date dataNascita, String cf, String luogoDiNascita) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = sesso;
		this.dataNascita = dataNascita;
		this.cf = cf;
		this.luogoDiNascita = luogoDiNascita;
	}
	
public Persona() {
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
