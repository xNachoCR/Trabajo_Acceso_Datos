package proyecto;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<Empleados> emp = new ArrayList<Empleados>();
		
		ProcesaFich pf = new ProcesaFich();
		
		String rutaFicherdat = "E:" + File.separator + "Documentos" 
				+ File.separator + "DAM" + File.separator + "Segundo Curso" 
				+ File.separator + "Acceso a Datos" + File.separator + "trabajoAcceso"
				+ File.separator + "01102022.dat"; //Ruta local del fichero binario en mi PC
		
		emp = pf.procesaFichero(rutaFicherdat);
		
		for (int i = 0; i < emp.size(); i++) {
			System.out.println(emp.get(i));
		}
	}
	
	

}
