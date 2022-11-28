package proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/*
 * Clase que extrae todos los datos de la base de datos MariaDB y los alamcena
 * 
 * en el ArrayList desgloseMes para manipularlos posteriormente con el otro ArrayList
 */
public class ProcesaBD {

	
	public ProcesaBD() {
		
	}
	
	public ArrayList<Empleados> procesaDatos() throws SQLException{
		
		ArrayList<Empleados> emp = new ArrayList<Empleados>();
		
		Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/db1eva","root","nacho");
	 	Statement sent = conn.createStatement();
	 	
	 	String query = "SELECT * FROM rrhhventas";
	 	ResultSet rs = sent.executeQuery(query);
	 	
	 	while(rs.next()) {
	 		Empleados e = new Empleados(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getDate(5));
	 		emp.add(e);
	 	}
	 	
	 	conn.close();
	 	sent.close();
	 	rs.close();
		
		return emp;
	}
}
