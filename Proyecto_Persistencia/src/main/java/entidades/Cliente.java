package entidades;

import entidades.Persona;
import entidades.TipoCliente;
import entidades.Turno;
import java.io.Serializable;
import javax.persistence.*;

/**
 * Clase de la entidad: Cliente
 *
 */
@Entity
public class Cliente extends Persona implements Serializable {

	/**
	 * Turno asignado a la persona
	 */
	@OneToOne
	private Turno turno;
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
	public Turno getTurno() {
		return this.turno;
	}
	/**
	 * Metodo set dek atributo turno
	 * @param turno el turno a asignar
	 */
	public void setTurno(Turno turno) {
		this.turno = turno;
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
