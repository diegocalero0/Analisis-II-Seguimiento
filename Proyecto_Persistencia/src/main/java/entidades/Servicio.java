package entidades;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Clase de la entidad: Servicio
 *
 */
@Entity
public class Servicio implements Serializable {

	/**
	 * nombre del servicio
	 */
	@Id
	@Column(length = 20)
	private String nombre;
	/**
	 * Breve descripcion del servicio
	 */
	@Column(length = 250)
	private String descripcion;
	/**
	 * Lista de empleados que pueden manejar este servicio
	 */
	@ManyToMany(mappedBy = "servicios")
	private List<Empleado> empleados;
	/**
	 * Serial que representa la clase serializable
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Constructor vacio para la clase Servicio
	 */
	public Servicio() {
		super();
	}   
	/**
	 * Metodo get del atributo nombre
	 * @return el nombre del servicio
	 */
	public String getNombre() {
		return this.nombre;
	}
	/**
	 * Metodo set del atributo nombre
	 * @param nombre el nuevo nombre del servicio
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}   
	/**
	 * Metodo get del atributo descripcion
	 * @return la descripcion del servicio
	 */
	public String getDescripcion() {
		return this.descripcion;
	}
	/**
	 * Metodo set del atributo descripcion
	 * @param descripcion la nueva descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
   
}
