package entidades;

import entidades.Persona;
import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Clase de la entidad: Operador
 *
 */
@MappedSuperclass
public class Operador extends Persona implements Serializable {

	/**
	 * Contrasenia del operador
	 */
	protected String contrasenia;
	/**
	 * Serial que representa la clase serializable
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Constructor vacio para la clase Operador
	 */
	public Operador() {
		super();
	}   
	/**
	 * Metodo get del atributo contrasenia
	 * @return la contrasenia actual
	 */
	public String getContrasenia() {
		return this.contrasenia;
	}
	/**
	 * Metodo set del atributo contrasenia
	 * @param contrasenia la nueva contrasenia
	 */
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
   
}
