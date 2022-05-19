package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoDipendente {
	Connection conn = Crud.getIstanze();
	
	//INSERIMENTO DIPENDENTE
	
	public boolean inserisciDip(Dipendente d) {
		PreparedStatement ps = null;
		System.out.println("Entrato Inserimento DIp");
		try {
			String sql="INSERT INTO dipendenti(stipendio,idPersona) VALUES (?,?)";
			ps=conn.prepareStatement(sql);
			ps.setDouble(1, d.getStipendio());
			ps.setInt(2, d.getIdPersona());
			
			System.out.println(ps);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
			return false;
	}
	
	
	public void modificaPersona(PersonaDTO dto,int idPersona) {
		PreparedStatement ps = null;
		System.out.println("sono in modifica2 " + idPersona);
		String sql=("Update dipendenti SET stipendio=? where idPersona=?");
		try {
			ps = conn.prepareStatement(sql);
			ps.setDouble(1, dto.getStipendio());
			ps.setInt(2, idPersona);			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	 //Daoprogetto prende id
	 public int getId(int idPersona)
	 {
		 int id = 0;
		 String sql="SELECT id FROM dipendenti WHERE idPersona=?";
				 try {
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setInt(1,idPersona);
					ResultSet rs = ps.executeQuery();
					if(rs.next()) {
						id=rs.getInt("id");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				 return id;
	 }
	
	 //Elimina dipendnete
	 public void eliminaDipendente(int id) {
		    Statement ps;
			ResultSet rs = null;            
			try {
				String sql="DELETE FROM dipendenti WHERE idPersona='"+id+"'";
				 ps=conn.createStatement();
		         ps.executeUpdate(sql);
			} catch (Exception e) {
				e.printStackTrace();
			}
		 
	 }
	
	
}
