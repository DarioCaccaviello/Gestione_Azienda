package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DaoPermesso {

	Connection conn = Crud.getIstanze();


	//LOGIN
	public String login(String username) {
		boolean flag=false;
		String permesso = null;
		PreparedStatement ps = null;
		try {
			//String sql="SELECT * FROM account WHERE username= ? OR email= ? AND password=? AND idPermesso=? ";
			//SELECT tipo from permessi INNER JOIN account ON (permessi.id=account.idPermesso) where account.username=? or account.email=?"
			String sql="SELECT tipo from permessi INNER JOIN account ON (permessi.id=account.idPermesso) WHERE username= ? OR email= ?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, username);

			ResultSet rs= ps.executeQuery();

			if(rs.next()) 
			{
				permesso = rs.getString("tipo");
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return permesso;

	}
/*
	//Controllo Permessi account
	public int ControlloPermessi(String app1, String app2) 
	{
		int id=0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT idPermesso FROM account WHERE (username='"+app1+"' or email='"+app1+"') and password='"+app2+"'";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next())
			{
				id=((Number) rs.getObject(1)).intValue();
			}
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return id;
	}*/

	
	
	
	
	
	
	
	
	
	

}
