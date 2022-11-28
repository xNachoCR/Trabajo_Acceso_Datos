package proyecto;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

/*
 * Clase que procesa fichero CSV y lo mete en el ArrayList "totalMes" donde 
 * 
 * se meterán al final todos los registros de ventas totales para introducir ala base
 * 
 * datos de MySQL
 * 
 */

public class ProcesaFich {
	
	private DecimalFormat df = new DecimalFormat("#.00");
	
	//Constructor base
	public ProcesaFich () {
		
	}
	
	//Método que devuelve un ArrayList con los datos del fichero CSV cuya ruta se pasa
	//por parámetro 
	public ArrayList<Empleados> procesaFichero(String ruta) throws IOException{
		
		ArrayList<Empleados> emp = new ArrayList<Empleados>();
		
		File ficheroB = new File(ruta);
		FileInputStream fis = new FileInputStream(ficheroB);
		DataInputStream dis = new DataInputStream (fis);
		
		while(fis.available() > 0) {
			String matricula = dis.readUTF();
			double gastos = dis.readDouble();
			double salarioMen = dis.readDouble();
			double aux = gastos + salarioMen;
			double gastoTotal = Double.parseDouble(df.format(aux));
			Empleados e = new Empleados(matricula, salarioMen, gastoTotal);
			emp.add(e);
			
		}
		
		fis.close();
		dis.close();
		
		return emp;
	}
	

}
