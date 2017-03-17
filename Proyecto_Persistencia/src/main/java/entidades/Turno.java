package entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Clase de la entidad: Turno
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name = Turno.get_all, query = "select turno from Turno turno"),
	@NamedQuery(name = Turno.get_all_wihtout_general, query = "select turno from Turno turno where turno.servicio.nombre != 'general'")
})
public class Turno implements Serializable {
	public static final String get_all = "Turno_getall";
	public static final String get_all_wihtout_general = "Turno_getall_wihtout_general";
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
   
}
