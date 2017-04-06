package dto;

import java.io.Serializable;

import entidades.Servicio;

/**
 * Este DTO almacena los servicios y el numero de clientes que han solicitado dicho servicio
 * @author Diego Calero
 *
 */
public class ServicioNumClientesDTO implements Serializable{
	private Servicio servicio;
	private long numClientes;
	
	
	
	public ServicioNumClientesDTO(Servicio servicio, long numClientes) {
		super();
		this.servicio = servicio;
		this.numClientes = numClientes;
	}
	/**
	 * @return the servicio
	 */
	public Servicio getServicio() {
		return servicio;
	}
	/**
	 * @param servicio the servicio to set
	 */
	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
	/**
	 * @return the numClientes
	 */
	public long getNumClientes() {
		return numClientes;
	}
	/**
	 * @param numClientes the numClientes to set
	 */
	public void setNumClientes(long numClientes) {
		this.numClientes = numClientes;
	}
	
	
	
}
