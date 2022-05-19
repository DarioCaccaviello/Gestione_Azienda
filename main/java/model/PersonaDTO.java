package model;

import java.sql.Date;

public class PersonaDTO {
	//Permesso
	private String nome;
	private String cognome;
	private String sesso;
	private Date dataNascita;
	private String cf;
	private String luogoDiNascita;

	//Dipendente
	private Double stipendio;
	private int idPersona;
	//Tipo
	private int id;
	private String tipo;
	
	//Account
	private String username;
	private String email;
	private String password;
	

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public Double getStipendio() {
		return stipendio;
	}
	public void setStipendio(Double stipendio) {
		this.stipendio = stipendio;
	}
	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
	
	public PersonaDTO(String nome, String cognome, String sesso, Date dataNascita, String cf, String luogoDiNascita,
			Double stipendio, int idPersona, int id, String tipo, String username, String email, String password) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = sesso;
		this.dataNascita = dataNascita;
		this.cf = cf;
		this.luogoDiNascita = luogoDiNascita;
		this.stipendio = stipendio;
		this.idPersona = idPersona;
		this.id = id;
		this.tipo = tipo;
		this.username = username;
		this.email = email;
		this.password = password;
	}
	@Override
	public String toString() {
		return "PersonaDTO [nome=" + nome + ", cognome=" + cognome + ", sesso=" + sesso + ", dataNascita=" + dataNascita
				+ ", cf=" + cf + ", luogoDiNascita=" + luogoDiNascita + ", stipendio=" + stipendio + ", idPersona="
				+ idPersona + ", id=" + id + ", tipo=" + tipo + ", username=" + username + ", email=" + email
				+ ", password=" + password + "]";
	}
	public PersonaDTO() {
		
	}

	
}
