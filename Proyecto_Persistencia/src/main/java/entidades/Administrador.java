package entidades;
import entidades.Operador;
import java.io.Serializable;
import javax.persistence.*;

/**
 * Clase de la entidad: Administrador
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name = Administrador.get_all, query = "select administrador from Administrador administrador")
})
public class Administrador extends Operador implements Serializable {
	public static final String get_all = "Administrador_getall";
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
