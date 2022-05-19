package model;

public class Account {

	private String username;
	private String email;
	private String password;
	
	private int id;
	private int idPermesso;
	private int idPersona;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdPermesso() {
		return idPermesso;
	}
	public void setIdPermesso(int idPermesso) {
		this.idPermesso = idPermesso;
	}
	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	@Override
	public String toString() {
		return "Account [username=" + username + ", email=" + email + ", password=" + password + ", id=" + id
				+ ", idPermesso=" + idPermesso + ", idPersona=" + idPersona + "]";
	}
	public Account(String username, String email, String password, int id, int idPermesso, int idPersona) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.id = id;
		this.idPermesso = idPermesso;
		this.idPersona = idPersona;
	}
	
	public Account(){
		
	}
	
	
}
