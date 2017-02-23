package entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Turno
 *
 */
@Entity

public class Turno implements Serializable {

	   
	@Id
	private int numero;
	@ManyToOne
	private Servicio servicio;
	private static final long serialVersionUID = 1L;

	public Turno() {
		super();
	}   
	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}   
	public Servicio getServicio() {
		return this.servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
   
}
