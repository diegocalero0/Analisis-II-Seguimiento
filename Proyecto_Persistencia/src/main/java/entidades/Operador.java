package entidades;

import entidades.Persona;
import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Operador
 *
 */
@MappedSuperclass

public class Operador extends Persona implements Serializable {

	
	protected String contrasenia;
	private static final long serialVersionUID = 1L;

	public Operador() {
		super();
	}   
	public String getContrasenia() {
		return this.contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
   
}
