package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

public class DaoPersona {

	Connection conn = Crud.getIstanze();

	//Inserimento Persona
	public boolean inserisciPersona(Persona p) {
		System.out.println("Persona");

		PreparedStatement ps=null;
		try {
			String sql="INSERT INTO persone(nome,cognome,sesso,dataNascita,codiceFiscale,luogoDiNascita) VALUES(?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, p.getNome());
			ps.setString(2, p.getCognome());
			ps.setString(3, p.getSesso());
			ps.setDate(4, p.getDataNascita());
			ps.setString(5, p.getCf());
			ps.setString(6, p.getLuogoDiNascita());
			ps.executeUpdate();
			return true;	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}


	//Metodo per recuperare ID persone
	public int recuperoIDP (String cf) {
		Statement ps;
		ResultSet rs=null;
		int id=0;
		try {
			String sql="SELECT id FROM persone WHERE codiceFiscale='"+cf+"'";
			ps=conn.createStatement();
			rs=ps.executeQuery(sql);
			if (rs.next()) {
				id=rs.getInt("id");
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	//Recuper GETIDCF
	public int getIdCF(String codiceFiscale){
		String sql="SELECT id from persone where codiceFiscale=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, codiceFiscale);
			ResultSet rs=ps.executeQuery();
			if (rs.next()) {
				return rs.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
 

	//Arraylist per mostrare persone nella page di conferma 
	public ArrayList<Persona> stampaPersone()
	{
		ArrayList<Persona> array=new ArrayList<Persona>();
		PreparedStatement ps = null;
		String sql="Select * from persone";
		try {
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Persona p=new Persona();
				p.setNome(rs.getString("nome"));
				p.setCognome(rs.getString("cognome"));
				p.setCf(rs.getString("codiceFiscale"));
				array.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return array;
	}

	//Arraylist per mostrare persone nella page di conferma 
		public ArrayList<PersonaDTO> stampaPersone2()
		{
			ArrayList<PersonaDTO> array=new ArrayList<PersonaDTO>();
			PreparedStatement ps = null;
			String sql="Select * from persone";
			try {
				ps=conn.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					PersonaDTO p=new PersonaDTO();
					p.setNome(rs.getString("nome"));
					p.setCognome(rs.getString("cognome"));
					p.setCf(rs.getString("codiceFiscale"));
					array.add(p);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return array;
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

/*	//Stampare tutte le persone presenti a DB
	public ArrayList<PersonaDTO> paginazioneDB()
	{
		ArrayList<PersonaDTO> array=new ArrayList<PersonaDTO>();
		PreparedStatement ps = null;
		PersonaDTO dto;
		String sql="Select DISTINCT nome,cognome,codiceFiscale,stipendio,idPermesso,tipo FROM persone p Inner JOIN dipendenti d ON P.id = d.idPersona INNER JOIN account a ON p.id = a.idPersona INNER JOIN permessi pp ON a.idPermesso= pp.id limit ? offset ?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, limit);
			ps.setInt(2, offset);

			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				dto= new PersonaDTO();
				dto.setNome(rs.getString("nome"));
				dto.setCognome(rs.getString("cognome"));
				dto.setCf(rs.getString("codiceFiscale"));
				dto.setStipendio(rs.getDouble("stipendio"));	
				dto.setTipo(rs.getString("tipo"));
				dto.setId(rs.getInt("idPermesso"));
				array.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return array;
	}
	*/
	

	 /* RICERCA PERSONA */
	public ArrayList<PersonaDTO>  ricercaNC(String nome, String cognome) {
		PersonaDTO dto = new PersonaDTO();
		ResultSet rs = null;
		PreparedStatement ps = null;
		ArrayList<PersonaDTO> array=new ArrayList<PersonaDTO>();
		String sql = "Select DISTINCT nome,cognome,codiceFiscale,stipendio,idPermesso,tipo FROM persone p Inner JOIN dipendenti d ON P.id = d.idPersona INNER JOIN account a ON p.id = a.idPersona INNER JOIN permessi pp ON a.idPermesso= pp.id where nome='"+nome+"'and cognome='"+cognome+"'";
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()) {
				dto.setNome(rs.getString("nome"));
				dto.setCognome(rs.getString("cognome"));
				dto.setCf(rs.getString("codiceFiscale"));
				dto.setStipendio(rs.getDouble("stipendio"));
				dto.setTipo(rs.getString("tipo"));
				array.add(dto);

			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return array;
	}
	
	/*RICERCA PER CODICE FISCALE */
	public ArrayList<PersonaDTO>ricercaCF(String codiceFiscale) {
		PersonaDTO dto = new PersonaDTO();
		ResultSet rs = null;
		PreparedStatement ps = null;
		ArrayList<PersonaDTO> array=new ArrayList<PersonaDTO>();
		System.out.println("entrato nella query di ricerca");
		String sql = "Select DISTINCT nome,cognome,codiceFiscale,stipendio,idPermesso,tipo FROM persone p Inner JOIN dipendenti d ON P.id = d.idPersona INNER JOIN account a ON p.id = a.idPersona INNER JOIN permessi pp ON a.idPermesso= pp.id where codiceFiscale='"+codiceFiscale+"'";
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()) {
				dto.setNome(rs.getString("nome"));
				dto.setCognome(rs.getString("cognome"));
				dto.setCf(rs.getString("codiceFiscale"));
				dto.setStipendio(rs.getDouble("stipendio"));
				dto.setTipo(rs.getString("tipo"));
				array.add(dto);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return array;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Stampare tutte le persone presenti a DB
	public ArrayList<PersonaDTO> stampaDB()
	{
		ArrayList<PersonaDTO> array=new ArrayList<PersonaDTO>();
		PreparedStatement ps = null;
		PersonaDTO dto;
		String sql="Select DISTINCT nome,cognome,codiceFiscale,stipendio,idPermesso,tipo FROM persone p Inner JOIN dipendenti d ON P.id = d.idPersona INNER JOIN account a ON p.id = a.idPersona INNER JOIN permessi pp ON a.idPermesso= pp.id";
		try {
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				dto= new PersonaDTO();
				dto.setNome(rs.getString("nome"));
				dto.setCognome(rs.getString("cognome"));
				dto.setCf(rs.getString("codiceFiscale"));
				dto.setStipendio(rs.getDouble("stipendio"));	
				dto.setTipo(rs.getString("tipo"));
				dto.setId(rs.getInt("idPermesso"));
				array.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return array;
	}

	//Recuperate dati per una singola persona per il Guest
		public PersonaDTO stampaSingolaPersona(String username) {
			
			System.out.println("prova2");
			System.out.println(username);

			PreparedStatement ps =null;
			PersonaDTO dto = null;
			String sql="SELECT nome,cognome,sesso,dataNascita,codiceFiscale,luogoDiNascita,stipendio,username,email,password,tipo From persone p inner join dipendenti d on p.id = d.idPersona Inner Join account a ON p.id=a.idPersona INNER JOIN permessi pp ON a.idPermesso = pp.id WHERE username=?";
			try {
				ps=conn.prepareStatement(sql);
				System.out.println(ps);
				ps.setString(1,username);
				ResultSet rs=ps.executeQuery();

				while(rs.next()) {
					dto = new PersonaDTO();
					dto.setNome(rs.getString("nome"));
					dto.setCognome(rs.getString("cognome"));
					dto.setCf(rs.getString("codiceFiscale"));
					dto.setLuogoDiNascita("luogoDiNacita");
					dto.setStipendio(rs.getDouble("stipendio"));	
					dto.setUsername(rs.getString("username"));
					dto.setEmail(rs.getString("email"));
					dto.setTipo(rs.getString("tipo"));

				}

			} catch (Exception e) {
				e.printStackTrace();
			}		
			System.out.println(dto);
			return dto;
			
			
		}
	//Query per modifica Persona in Database
	public boolean modificaPersona (PersonaDTO dto,String cfv) {
		System.out.println("sono in modifica");
		PreparedStatement ps = null;
		String sql =("Update persone SET nome=?, cognome=?, sesso=?, dataNascita=?, codiceFiscale=?, luogoDiNascita=?  where codiceFiscale=?");
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getNome());
			ps.setString(2, dto.getCognome());
			ps.setString(3, dto.getSesso());
			System.out.println(dto.getSesso());
			ps.setDate(4, dto.getDataNascita());
			ps.setString(5, dto.getCf());
			ps.setString(6,dto.getLuogoDiNascita());
			ps.setString(7, cfv);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	
	
	//METODO RICERCA PERSONA TRAMITE CODICE FISCALE
	public PersonaDTO ricercaPersona(String cf) {
		System.out.println("sono in ricerca");
		String sql="SELECT nome,cognome,sesso,dataNascita,codiceFiscale,luogoDiNascita,stipendio,tipo,username,email,password From persone p inner join dipendenti d on p.id = d.idPersona Inner Join account a ON p.id=a.idPersona INNER JOIN permessi pp ON a.idPermesso = pp.id WHERE codiceFiscale='"+cf+"'";
		PersonaDTO dto = new PersonaDTO();
		try {
			Statement ps = conn.createStatement();
			ResultSet  rs = ps.executeQuery(sql);
			while (rs.next()) {									/* Manca la gestione del id e del sesso dalla jsp*/
				dto.setNome(rs.getString("nome"));
				dto.setCognome(rs.getString("cognome"));
				dto.setSesso(rs.getString("sesso"));
				dto.setDataNascita(rs.getDate("dataNascita"));
				dto.setCf(rs.getString("codiceFiscale"));
				dto.setLuogoDiNascita(rs.getString("luogoDiNascita"));
				dto.setStipendio(rs.getDouble("stipendio"));
				dto.setTipo(rs.getString("tipo"));
				dto.setUsername(rs.getString("username"));
				dto.setPassword(rs.getString("password"));
				dto.setEmail(rs.getString("email"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	//METEODO CHE CONTROLLA SE A DB E' PRESENTE GIA' IL CF
	public boolean controlloCf(String cf) {

		PreparedStatement ps = null;
		ResultSet rs=null;

		String sql = "Select cf from persone where cf= ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cf);

			rs = ps.executeQuery();

			if(rs.next()) {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("codice fiscale presente");
		return true;


	}
	
	//Elimina 
	public void eliminaPersona(String cf) {
		int id=0;
		System.out.println("metodo elimina");
		Statement ps;
		ResultSet rs = null;
		try {
			String sql="DELETE FROM persone  WHERE codiceFiscale='"+cf+"'";
			System.out.println(sql);
			ps=conn.createStatement();
	         ps.executeUpdate(sql);
			System.out.println(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	



}
