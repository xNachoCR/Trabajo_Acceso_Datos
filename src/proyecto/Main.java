package proyecto;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import reverse.Listaempleados;
import reverse.ListaempleadosId;

public class Main {
	
	private static SessionFactory hbsf;

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
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce fecha para generar registro(yyyy-MM-dd): ");
		String fecha = sc.nextLine();
		
		actualizaDatos(totalMes, desgloseMes);
		
		introduceFecha(totalMes, fecha);
		
		System.out.println("Datos que se introducirán en la base de datos...");
		
		for (int i = 0; i < totalMes.size(); i++) {
			System.out.println(totalMes.get(i));
		}
		
		Configuration config = new Configuration();
		config.configure();
		SessionFactory session = config.buildSessionFactory();
		Session ss = session.openSession();
		Transaction transaction = ss.beginTransaction();
		
		for(int i = 0; i < totalMes.size(); i++) {
			ListaempleadosId empList = new ListaempleadosId();
			Listaempleados list = new Listaempleados();
			
			empList.setMatricula(totalMes.get(i).getMatricula());
			empList.setDepartamento(totalMes.get(i).getDepartamento());
			empList.setApenom(totalMes.get(i).getNombre());
			empList.setTotventas(totalMes.get(i).getVentasSem());
			empList.setTotgastos(totalMes.get(i).getGastos());
			String dt = totalMes.get(i).getSemana().toString();
			empList.setFecha(java.sql.Date.valueOf(dt));
			
			list.setId(empList);
			ss.save(list);
		}
		
		transaction.commit();
		session.close();
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
	
	private static void introduceFecha(ArrayList<Empleados> totalMes, String fecha) {
		for (int i = 0; i < totalMes.size(); i++) {
			totalMes.get(i).setSemana(java.sql.Date.valueOf(fecha));
		}
	}
	
	
	
	

}
