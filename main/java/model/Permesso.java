package model;

public class Permesso {

	private int id;
	private String tipo;
	
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
	public Permesso(int id, String tipo) {
		this.id = id;
		this.tipo = tipo;
	}

	public Permesso() {

	}
	@Override
	public String toString() {
		return "Permesso [id=" + id + ", tipo=" + tipo + "]";
	}








}
