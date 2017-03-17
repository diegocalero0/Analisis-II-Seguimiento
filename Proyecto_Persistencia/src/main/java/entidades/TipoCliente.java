package entidades;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import javax.validation.constraints.Max;

/**
 * Clase de la entidad: TipoCliente
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name = TipoCliente.get_all, query = "select tipocliente from TipoCliente tipocliente"),
	@NamedQuery(name = TipoCliente.get_priority_almost_5, query = "select tipocliente from TipoCliente tipocliente where tipocliente.prioridad <= 5")
})
public class TipoCliente implements Serializable {
	public static final String get_all = "TipoCliente_getall";
	public static final String get_priority_almost_5 = "TipoCliente_get_priority_almost_5";
	/**
	 * Nombre del tipo de cliente
	 */
	@Id
	private String nombre;
	@Max(15)
	/**
	 * prioridad del tipo de cliente
	 */
	private int prioridad;
	/**
	 * Serial que representa la clase serializable
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Constructor vacio para la clase TipoCliente
	 */
	public TipoCliente() {
		super();
	}   
	/**
	 * Metodo get del atributo nombre
	 * @return el nombre del tipo de cliente
	 */
	public String getNombre() {
		return this.nombre;
	}
	/**
	 * Metodo set del atributo nombre
	 * @param nombre el nuevo nombre para el tipo de cliente
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}   
	/**
	 * Metodo get del atributo prioridad
	 * @return la prioridad del tipo
	 */
	public int getPrioridad() {
		return this.prioridad;
	}
	/**
	 * Metodo set del atributo prioridad
	 * @param prioridad la nueva prioridad del tipo de cliente
	 */
	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}
   
}
