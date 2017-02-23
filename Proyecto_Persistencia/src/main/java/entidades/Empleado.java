package entidades;

import entidades.Cliente;
import entidades.Operador;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Empleado
 *
 */
@Entity

public class Empleado extends Operador implements Serializable {

	@OneToOne	
	private Cliente cliente_actual;
	@ManyToMany
	private List<Servicio> servicios;
	private static final long serialVersionUID = 1L;

	public Empleado() {
		super();
	}   
	public Cliente getCliente_actual() {
		return this.cliente_actual;
	}

	public void setCliente_actual(Cliente cliente_actual) {
		this.cliente_actual = cliente_actual;
	}   
	public List getServicios() {
		return this.servicios;
	}

	public void setServicios(List servicios) {
		this.servicios = servicios;
	}
   
}
