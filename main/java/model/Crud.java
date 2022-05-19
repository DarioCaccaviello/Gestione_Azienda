package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Crud {

	//JDBC CONNECTOR

	public final static String JDBC_DRIVER ="com.mysql.cj.jdbc.Driver";
	public final static String DB_URL="jdbc:mysql://localhost:3306/db_utenti";
	public final static String UserDb ="root";
	public final static String PasswordDb ="";
	
	private static Connection conn=null;
	private static Crud istance= null;

	public static synchronized Connection getIstanze() {

		if(istance==null) {
			istance =  new Crud();
		}
		return conn;
	}

	 private Crud(){ //
		try {
			Class.forName(JDBC_DRIVER); //Caricamento del Driver con il metodo forName() dell’oggetto Class;
			conn=DriverManager.getConnection(DB_URL,UserDb,PasswordDb);
			//Apertura della connessione al db tramite un oggetto di tipo Connection, tramite la classe DriverManager;
		
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	











}
