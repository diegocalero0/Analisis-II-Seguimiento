package dto;

import java.io.Serializable;
import java.util.List;

import entidades.Empleado;

/**
 * Este DTO almacena el nombre del servicio y los empleados que pueden atender dicho servicio
 * @author Diego Calero
 *
 */
public class ServiciosEmpleadosDTO implements Serializable{
	/**
	 * Codigo de serializacion
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * El nombre del servicio
	 */
	private String nombreServicio;
	/**
	 * Los empleados que atienden dicho servicio
	 */
	private List<Empleado> empleados;
	private Empleado empleado;
	
	/**
	 * Metodo constructor del DTO
	 * @param nombreServicio el nombre del servicio
	 * @param empleados empleados que atienden el servicio
	 */
	public ServiciosEmpleadosDTO(String nombreServicio, List<Empleado> empleados){
		this.empleados = empleados;
		this.nombreServicio = nombreServicio;
	}
	public ServiciosEmpleadosDTO(String nombreServicio, Empleado empleado){
		this.empleado = empleado;
		this.nombreServicio = nombreServicio;
	}

	/**
	 * @return the nombreServicio
	 */
	public String getNombreServicio() {
		return nombreServicio;
	}

	/**
	 * @param nombreServicio the nombreServicio to set
	 */
	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}

	/**
	 * @return the empleados
	 */
	public List<Empleado> getempleados() {
		return empleados;
	}

	/**
	 * @param empleados the empleados to set
	 */
	public void setempleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}
	
	
	
}
