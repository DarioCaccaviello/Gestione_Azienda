package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DaoAccount {

	Connection conn = Crud.getIstanze();

	//INSERIMENTO ACCOUNT
	public boolean InserisciAccount(Account a) {
		PreparedStatement ps = null;
		System.out.println("Entrato Inserimento acc");

		try {
			String sql="INSERT INTO account(username,email,password,idPermesso,idPersona) VALUES(?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, a.getUsername());
			ps.setString(2, a.getEmail());
			ps.setString(3, a.getPassword());
			ps.setInt(4, a.getIdPermesso());
			ps.setInt(5, a.getIdPersona());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	//RICERCA PERMESSO ACCOUNT
	public int ricercaIdPermesso() {
		int id=0;
		String sql=null;
		PreparedStatement ps;
		try {
			sql="SELECT id FROM permessi WHERE tipo= '?' ";
			ps=conn.prepareStatement(sql);
			ps.executeQuery(sql);

		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return id;
	}

	//controllo Account se presente in DB
	public boolean controlloAccount(String username, String password)
	{
		String sql="Select id from account where (username=? or email=?) and password=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, username);
			ps.setString(3, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//MODIFICA ACCOUNT
	public void modificaAccount(PersonaDTO dto,int idPersona) {
		PreparedStatement ps = null;
		System.out.println("sono in modifica3 " + idPersona);
		String sql="UPDATE Account SET username=?,email=?,password=?,idPermesso=? WHERE idPersona=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getUsername());
			ps.setString(2,dto.getEmail());
			ps.setString(3, dto.getPassword());
			ps.setInt(4, dto.getId());
			ps.setInt(5, idPersona);			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	 //Elimina ACCOUNT
	 public void eliminaACCOUNT(int id) {
		    Statement ps;
			ResultSet rs = null;            
			try {
				String sql="DELETE FROM account WHERE idPersona='"+id+"'";				 ps=conn.createStatement();
		         ps.executeUpdate(sql);
			} catch (Exception e) {
				e.printStackTrace();
			}
		 
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
