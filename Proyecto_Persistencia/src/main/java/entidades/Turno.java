package entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Clase de la entidad: Turno
 *
 */
@Entity
public class Turno implements Serializable {
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
