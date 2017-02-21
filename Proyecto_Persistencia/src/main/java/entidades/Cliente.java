package entidades;

import entidades.Persona;
import entidades.TipoCliente;
import entidades.Turno;
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Max;

/**
 * Entity implementation class for Entity: Cliente
 *
 */
@Entity

public class Cliente extends Persona implements Serializable {

	
	private Turno turno;
	private TipoCliente tipo;
	private static final long serialVersionUID = 1L;

	public Cliente() {
		super();
	}   
	public Turno getTurno() {
		return this.turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}   
	
	public TipoCliente getTipo() {
		return this.tipo;
	}

	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo;
	}
   
}
