package proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
	 	
	 	
		
		return emp;
	}
	/*
	public ArrayList<Empleados> procesaVentas(ArrayList<Empleados> emp) throws SQLException{
		ArrayList<Empleados> emp2 = new ArrayList<Empleados>();
		
		Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/db1eva","root","nacho");
	 	Statement sent = conn.createStatement();
	 	
	 	String query = "SELECT * FROM rrhhventas";
	 	ResultSet rs = sent.executeQuery(query);
	 	
	 	while(rs.next()) {
	 		double ventasT = 0;
	 		for (int i = 0; i < emp.size(); i++) {
	 			if (emp.get(i).getMatricula().equalsIgnoreCase(rs.getString(1)) && 
	 					emp.get(i).getDepartamento().equalsIgnoreCase(rs.getString(i))) {
	 				ventasT += emp.get(i).getVentasSem();
	 			}
	 		}
	 	}
	 	
	 	
		
		return emp2;
	}
	*/
}
