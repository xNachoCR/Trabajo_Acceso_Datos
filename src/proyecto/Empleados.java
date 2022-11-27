package proyecto;

import java.util.Date;
import java.util.Objects;

public class Empleados {
	
	private String matricula;
	private String nombre;
	private String departamento;
	private double ventasSem;
	private Date semana;
	private double salario;
	private double gastos;
	
	public Empleados(String matricula, double salario, double gasto) {
		this.matricula = matricula;
		this.salario = salario;
		this.gastos = gasto;
	}
	
	public Empleados(String matricula, String dpto, String nombre, double gastos, double ventas, Date semana) {
		this.matricula = matricula;
		this.departamento = dpto;
		this.nombre = nombre;
		this.gastos = gastos;
		this.ventasSem = ventas;
		this.semana = semana;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public double getVentasSem() {
		return ventasSem;
	}

	public void setVentasSem(double ventasSem) {
		this.ventasSem = ventasSem;
	}

	public Date getSemana() {
		return semana;
	}

	public void setSemana(Date semana) {
		this.semana = semana;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public double getGastos() {
		return gastos;
	}

	public void setGastos(double gastos) {
		this.gastos = gastos;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hashCode(matricula);
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Empleado [MATRICULA=" + matricula + ", APELLIDOS, NOMBRE=" + nombre + ", DEPARTAMENTO=" + departamento
				+ ", VENTAS=" + ventasSem + ", SALARIO=" + salario + ", GASTOS=" + gastos + ", MES= "+ semana +"]";
	}
	
	

}
