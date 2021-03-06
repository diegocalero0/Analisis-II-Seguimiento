package entidades;

import entidades.Cliente;
import entidades.Operador;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 * Clase de la entidad: Empleado
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name = Empleado.get_all, query = "select empleado from Empleado empleado"),
	@NamedQuery(name = Empleado.get_all_services, query = "select s from Empleado e INNER JOIN e.servicios s where e.cedula = :x "),
	//@NamedQuery(name = Empleado.get_employee_max_client_attended, query = "SELECT MAX(COUNT(1)) FROM Turno t WHERE t.atendido = TRUE GROUP BY t.empleado")
})
public class Empleado extends Operador implements Serializable {
	public static final String get_all = "Empleado_getall";
	public static final String get_all_services = "Empleado_getall_services";
	public static final String get_employee_max_client_attended = "Empleado_max_client_attended";
	/**
	 * Cliente que est� siendo atendido
	 */
	@OneToOne	
	private Cliente cliente_actual;
	/**
	 * Lista de servicios que puede atender el empleado
	 */
	@ManyToMany
	private List<Servicio> servicios;
	/**
	 * Serial que representa la clase serializable
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Constructor vacio para la clase empleado
	 */
	public Empleado() {
		super();
	}  
	/**
	 * Metodo get para el atributo ciente_actual
	 * @return el cliente que esta siendo atendido
	 */
	public Cliente getCliente_actual() {
		return this.cliente_actual;
	}
	/**
	 * Metodo set para el atributo cliente_actual
	 * @param cliente_actual el nuevo cliente
	 */
	public void setCliente_actual(Cliente cliente_actual) {
		this.cliente_actual = cliente_actual;
	}   
	/**
	 * Metodo get para el atributo servicios
	 * @return la lista de servicios
	 */
	public List<Servicio> getServicios() {
		return this.servicios;
	}
	/**
	 * Metodo set para el atributo servicios
	 * @param servicios la nueva lista de servicios
	 */
	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}
   
}
