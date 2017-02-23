package entidades;

import entidades.Operador;
import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Administrador
 *
 */
@Entity

public class Administrador extends Operador implements Serializable {

	private static final long serialVersionUID = 1L;

	public Administrador() {
		super();
	}    
  
}
