package entidades;

import entidades.Persona;
import entidades.TipoCliente;
import entidades.Turno;
import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Clase de la entidad: Cliente
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name = Cliente.get_all, query = "SELECT cliente FROM Cliente cliente"),
	@NamedQuery(name = Cliente.get_num_of_clientes_determined_servie, query = "SELECT COUNT(DISTINCT t.cliente) FROM Turno t WHERE t.servicio.nombre = :x"),
	@NamedQuery(name = Cliente.get_num_of_clientes_with_turno_at_time, query = "SELECT COUNT(DISTINCT t.cliente) FROM Turno t WHERE t.fecha = :x"),
	@NamedQuery(name = Cliente.get_clientes_with_turno_unattended, query = "SELECT t.cliente From Turno t WHERE t.atendido = FALSE GROUP BY t.cliente")
})
public class Cliente extends Persona implements Serializable {
	public static final String get_all = "Cliente_getall";
	public static final String get_num_of_clientes_determined_servie = "Cliente_get_num_cliente_servicio";
	public static final String get_num_of_clientes_with_turno_at_time = "Cliente_get_num_cliente_at_turno_time";
	public static final String get_clientes_with_turno_unattended = "Cliente_get_all_with_turno_unattended";
	
	/**
	 * Turnos que tiene asignados una persona
	 */
	@OneToMany(mappedBy = "cliente")
	private List<Turno> turnos;
	/**
	 * Categoria a la que pertenece un cliente
	 */
	@ManyToOne
	private TipoCliente tipo;
	/**
	 * Serial que representa la clase serializable
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Constructor vacio para la entidad Cliente
	 */
	public Cliente() {
		super();
	}   
	/**
	 * Metodo get del atributo turno
	 * @return el turno actual
	 */
	public List<Turno> getTurnos() {
		return this.turnos;
	}
	/**
	 * Metodo set dek atributo turno
	 * @param turno el turno a asignar
	 */
	public void setTurnos(List<Turno> turnos) {
		this.turnos = turnos;
	}   
	/**
	 * Metodo get del atributo tipo
	 * @return el tipo del cliente
	 */
	public TipoCliente getTipo() {
		return this.tipo;
	}
	/**
	 * Metodo set del atributo tipo
	 * @param tipo el nuevo tipo a ser asignado
	 */
	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo;
	}
   
}
