package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controller.Progetti;

public class DaoProgetti {


	Connection conn = Crud.getIstanze();

	
	//Query per inserire progetti a DB 
	public boolean inserisciProgetto(Progetto p) {

		PreparedStatement ps = null;

		try {
			String sql="INSERT INTO progetti(nomeProgetto,descrizione,costo,linkImg) VALUES (?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, p.getNomeProgetto());
			ps.setString(2, p.getDescrizione());
			ps.setDouble(3,p.getCosto() );
			ps.setString(4, p.getLinkImg());

			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//Query per visualizzare progetti
	public ArrayList<Progetto> visualizzaProgetti() 
	{
		ArrayList<Progetto> progetto=new ArrayList<Progetto>();

		PreparedStatement ps = null;
		String sql="Select * from progetti";
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Progetto prog = new Progetto(); //Passavo ProgettoDTO come tipo e non com generic Progetto che è arraylist<generic> in questo caso. 
				prog.setNomeProgetto(rs.getString("nomeProgetto"));
				prog.setDescrizione(rs.getString("descrizione"));
				prog.setCosto(rs.getDouble("costo"));
				prog.setLinkImg(rs.getString("linkImg"));
				
				progetto.add(prog);				
				System.out.println(prog);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return progetto;
	}
	//MODIFICA PROGETTO
	public void ModificaProg(ProgettiDTO dto,String nomeVecchioProgetti) {
		
		System.out.println("query di moficia");
		String sql="UPDATE progetti SET nomeProgetto=?,descrizione=?,costo=?,linkImg=? where nomeProgetto=?";	
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			System.out.println(sql);
			ps.setString(1, dto.getNomeProgetto());
			ps.setString(2, dto.getDescrizione());
			ps.setDouble(3, dto.getCosto());
			ps.setString(4, dto.getLinkImg());
			ps.setString(5, nomeVecchioProgetti);
			ps.executeUpdate();
		}catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	//Ricerca progetto 
	
	public ProgettiDTO ricercaProgetto(String nomeProgetto){
		System.out.println("Sono in ricerca progetto");
		Statement ps;
		ResultSet rs=null;
		ProgettiDTO dtoProgetto = new ProgettiDTO();
		try {
			String sql="SELECT * FROM progetti WHERE nomeProgetto='"+nomeProgetto+"'";
			ps=conn.createStatement();
			rs=ps.executeQuery(sql);
		
			while(rs.next()){
				
				dtoProgetto.setNomeProgetto(rs.getString("nomeProgetto"));
				dtoProgetto.setDescrizione(rs.getString("descrizione"));
				dtoProgetto.setCosto(rs.getDouble("costo"));
				dtoProgetto.setLinkImg(rs.getString("linkImg"));
			}

		} catch (Exception e) {
		e.printStackTrace();
		
		}
		return dtoProgetto;
		
		
	}
	
	//Elimina Progetto
	public void eliminaProgetto(String nomeProgetto) {
		
		System.out.println("entrato nel metodo elimina");
		PreparedStatement ps = null;
		try {
			String sql="DELETE FROM progetti WHERE nomeProgetto='"+nomeProgetto+"'";
			ps=conn.prepareStatement(sql);
			ps.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	/****************************************************************************************************/
	/********ASSOCCIA E DISSOCCIA******************************/
	public ArrayList<PersonaDTO> getutentiAssociati(String nomeProgetto) {
		ArrayList <PersonaDTO> persone = new ArrayList <PersonaDTO>();		 
		System.out.println("sei entrato nella query che carica tutti i dipendneti");
		String sql="SELECT DISTINCT nome, cognome,email,codiceFiscale FROM persone JOIN dipendenti ON (persone.id=dipendenti.idPersona) JOIN account ON (persone.id=account.idPersona) WHERE dipendenti.id IN (SELECT working.idDipendente FROM working JOIN progetti ON (working.idProgetto=progetti.id) WHERE progetti.nomeProgetto =?)";		 

		try {
			            PreparedStatement ps= conn.prepareStatement(sql);
			            ps.setString(1, nomeProgetto);
			            ResultSet rs = ps.executeQuery();
			            while(rs.next()) {
			                PersonaDTO dto = new PersonaDTO();
			                dto.setNome(rs.getString("Nome"));
			                dto.setCognome(rs.getString("Cognome"));
			                dto.setEmail(rs.getString("Email"));
			                dto.setCf(rs.getString("codiceFiscale"));
			                persone.add(dto);
			            }
			        } catch (SQLException e) {
			            e.printStackTrace();
			        }
			        return persone;
			    }
	
	 public ArrayList<PersonaDTO> getutentiNonAssociati(String nomeProgetto) {
			ArrayList <PersonaDTO> persone = new ArrayList <PersonaDTO>();		 
		   String sql="SELECT DISTINCT nome,cognome,email,codiceFiscale FROM persone JOIN dipendenti ON (persone.id=dipendenti.idPersona) JOIN account ON (persone.id=account.idPersona) WHERE dipendenti.id NOT IN (SELECT working.idDipendente FROM working JOIN progetti ON (working.idProgetto=progetti.id) WHERE progetti.nomeProgetto =?)";		 
		 		 try {
		 	            PreparedStatement ps= conn.prepareStatement(sql);
		 	            ps.setString(1, nomeProgetto);
		 	            ResultSet rs = ps.executeQuery();
		 	            while(rs.next()) {
			                PersonaDTO dto = new PersonaDTO();
			                dto.setNome(rs.getString("nome"));
			                dto.setCognome(rs.getString("cognome"));
			                dto.setEmail(rs.getString("email"));
			                dto.setCf(rs.getString("codiceFiscale"));

			                persone.add(dto);
		 	            }
		 	        } catch (SQLException e) {
		 	            e.printStackTrace();
		 	        }
		 	        return persone;
		 	 }
		 	    
	 
	 //ASSOCCIA
	 public void associa(int idDipendente,int idProgetto) {
		 String sql="INSERT INTO working (idDipendente,idProgetto) VALUES(?,?)";
		 try {
			 PreparedStatement ps = conn.prepareStatement(sql);
			 ps.setInt(1, idDipendente);
			 ps.setInt(2, idProgetto);
			 System.out.println(ps);
			 ps.executeUpdate();
		} catch (SQLException e) 
		 {
			e.printStackTrace();
		}
	 }
		 
	 
	 //DISSOCCIA
		 public void dissoccia(int idDipendente) {
			 System.out.println("query dissociamento");
			 String sql="DELETE FROM working WHERE working.idDipendente=?";
			 try {
				 PreparedStatement ps = conn.prepareStatement(sql);
				 ps.setInt(1, idDipendente);
				 System.out.println(ps);
				 ps.executeUpdate();
			} catch (SQLException e) 
			 {
				e.printStackTrace();
			}
			 
		 
	 }
	 
		 
		
	 //***********************************************************************//
		 public int getIdProgetto(String nomeProgetto) {
			 String sql="SELECT id from progetti where nomeProgetto=?";
			 try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, nomeProgetto);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					return rs.getInt("id");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			 return 0;
		 }
		 
		 
	 
	 
	 
	 
	 
	 
	


}
