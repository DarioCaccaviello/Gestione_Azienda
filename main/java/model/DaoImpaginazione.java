package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoImpaginazione {

	Connection conn = Crud.getIstanze();
	
	//impaginazione
	
	 public ArrayList<PersonaDTO> getutentiPag(int limit,int offset) {
		 ArrayList<PersonaDTO> array = new ArrayList<PersonaDTO>();
	        String sql="SELECT nome, cognome, codiceFiscale, stipendio, idPermesso, sesso, dataNascita, luogoDiNascita, username, email, password from persone join dipendenti on persone.id=dipendenti.idPersona join account on account.idPersona=persone.id limit ? offset ?" ;
	        try {
	        	PreparedStatement ps= conn.prepareStatement(sql);
	            ps.setInt(1, limit);
	            ps.setInt(2, offset);
	            ResultSet rs = ps.executeQuery();
	            while(rs.next()) {
	            	PersonaDTO dto = new PersonaDTO();
	            	dto.setNome(rs.getString("nome"));
	            	dto.setCognome(rs.getString("cognome"));
	            	dto.setCf(rs.getString("codiceFiscale"));
	            	dto.setStipendio(rs.getDouble("stipendio"));
	                if(rs.getInt("idPermesso")==2) {
	                	dto.setTipo("Admin");	
	                }else {
	                	dto.setTipo("Guest");
	                }
	                dto.setSesso(rs.getString("sesso"));
	                dto.setDataNascita(rs.getDate("dataNascita"));
	                dto.setLuogoDiNascita(rs.getString("luogoDiNascita"));
	                dto.setUsername(rs.getString("username"));
	                dto.setEmail(rs.getString("email"));
	                dto.setPassword(rs.getString("password"));
	                
	                array.add(dto);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return array;
	    }
	
	
	
	
	
	
	
	
}
