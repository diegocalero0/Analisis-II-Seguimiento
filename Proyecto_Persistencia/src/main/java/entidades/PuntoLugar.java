package entidades;

import java.io.Serializable;
import java.lang.Double;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: PuntoLugar
 *
 */
@Entity

@IdClass(PuntoLugarPK.class)
public class PuntoLugar implements Serializable {

	   
	@Id
	private Double longitud;   
	@Id
	private Double latitud;
	private String nombre;
	private static final long serialVersionUID = 1L;

	public PuntoLugar() {
		super();
	}   
	public Double getLongitud() {
		return this.longitud;
	}

	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}   
	public Double getLatitud() {
		return this.latitud;
	}

	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}   
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
   
}
