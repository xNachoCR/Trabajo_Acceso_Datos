package proyecto;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException, SQLException {
		// TODO Auto-generated method stub
		ArrayList<Empleados> totalMes = new ArrayList<Empleados>();
		ArrayList<Empleados> desgloseMes = new ArrayList<Empleados>();
		
		ProcesaFich pf = new ProcesaFich();
		ProcesaBD pb = new ProcesaBD();
		
		String rutaFicherdat = "E:" + File.separator + "Documentos" 
				+ File.separator + "DAM" + File.separator + "Segundo Curso" 
				+ File.separator + "Acceso a Datos" + File.separator + "trabajoAcceso"
				+ File.separator + "01102022.dat"; //Ruta local del fichero binario en mi PC
		
		totalMes = pf.procesaFichero(rutaFicherdat);
		desgloseMes = pb.procesaDatos();
		
		actualizaDatos(totalMes, desgloseMes);
		
		
		for (int i = 0; i < totalMes.size(); i++) {
			System.out.println(totalMes.get(i));
		}
	}
	
	private static void actualizaDatos(ArrayList<Empleados> totalMes, ArrayList<Empleados> desgloseMes) {
		DecimalFormat df = new DecimalFormat("#.00");
		
		for (int i = 0; i < totalMes.size(); i++) {
			double gastoT = 0;
			for (int j = 0; j < desgloseMes.size(); j++) {
				if (totalMes.get(i).getMatricula().equalsIgnoreCase(desgloseMes.get(j).getMatricula())) {
					gastoT += desgloseMes.get(j).getVentasSem();
				}
				totalMes.get(i).setVentasSem(Double.parseDouble(df.format(gastoT)));
				totalMes.get(i).setNombre(desgloseMes.get(i).getNombre());
				totalMes.get(i).setDepartamento(desgloseMes.get(i).getDepartamento());
			}
		}
	}
	
	
	
	

}
