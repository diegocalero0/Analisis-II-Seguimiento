package entidades;
import entidades.Operador;
import java.io.Serializable;
import javax.persistence.*;

/**
 * Clase de la entidad: Administrador
 *
 */
@Entity
public class Administrador extends Operador implements Serializable {
	
	/**
	 * Serial que representa la clase serializable
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor vacio para la entidad Adminsitrador
	 */
	public Administrador() {
		super();
	}    
	
}
