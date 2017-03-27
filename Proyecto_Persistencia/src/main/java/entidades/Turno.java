package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * Clase de la entidad: Turno
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name = Turno.get_all, query = "select turno from Turno turno"),
	@NamedQuery(name = Turno.get_all_wihtout_general, query = "select turno from Turno turno where turno.servicio.nombre != 'general'"),
	@NamedQuery(name = Turno.get_cliente, query = "select turno.cliente from Turno turno where turno.numero = :num"),
	@NamedQuery(name = Turno.get_turnos_fecha, query = "select new dto.TurnoFechaDTO(t.numero, t.servicio.nombre, t.cliente.cedula, t.cliente.nombre, t.cliente.correoElectronico) from Turno t where t.fecha = :fecha")
})
public class Turno implements Serializable {
	public static final String get_all = "Turno_getall";
	public static final String get_all_wihtout_general = "Turno_getall_wihtout_general";
	public static final String get_cliente = "Turno_get_cliente";
	public static final String get_turnos_fecha = "Turno_getall_fecha";
	/**
	 * Numero asignado al turno
	 */
	@Id
	private int numero;
	/**
	 * Servicio asignado al turno
	 */
	@ManyToOne
	private Servicio servicio;
	/**
	 * Cliente que contiene el turno
	 */
	@OneToOne
	private Cliente cliente;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	/**
	 * Fecha en la que se asignó el turno
	 */
	private Date fecha;
	/**
	 * Serial que representa la clase serializable
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Constructor vacio para la clase Turno
	 */
	public Turno() {
		super();
	}   
	/**
	 * Metodo get del atributo numero
	 * @return el numero del turno
	 */
	public int getNumero() {
		return this.numero;
	}
	/**
	 * Metodo set del atributo numero
	 * @param numero el nuevo numero del turno
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}   
	/**
	 * Metodo get del atributo servicio
	 * @return el servicio del turno
	 */
	public Servicio getServicio() {
		return this.servicio;
	}
	/**
	 * Metodo set del atributo servicio
	 * @param servicio el nuevo servicio
	 */
	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
	/**
	 * Metodo get del atributo cliente
	 * @return el cliente del turno
	 */
	public Cliente getCliente() {
		return cliente;
	}
	/**
	 * Metodo set del atributo cliente
	 * @param cliente el nuevo cliente
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}
	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
   
	
	
}
