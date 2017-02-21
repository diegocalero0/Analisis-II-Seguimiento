package entidades;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import javax.validation.constraints.Max;

/**
 * Entity implementation class for Entity: TipoCliente
 *
 */
@Entity

public class TipoCliente implements Serializable {

	   
	@Id
	private String nombre;
	@Max(15)
	private int prioridad;
	private static final long serialVersionUID = 1L;

	public TipoCliente() {
		super();
	}   
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}   
	public int getPrioridad() {
		return this.prioridad;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}
   
}
