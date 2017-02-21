package entidades;

import entidades.Operador;
import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Administrador
 *
 */
@Entity

public class Administrador extends Operador implements Serializable {

	
	private List<TipoCliente> tipo_clientes;
	private List<Empleado> empleados;
	private static final long serialVersionUID = 1L;

	public Administrador() {
		super();
	}   
	public List<TipoCliente> getTipo_clientes() {
		return this.tipo_clientes;
	}

	public void setTipo_clientes(List<TipoCliente> tipo_clientes) {
		this.tipo_clientes = tipo_clientes;
	}   
	public List<Empleado> getEmpleados() {
		return this.empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}
   
}
