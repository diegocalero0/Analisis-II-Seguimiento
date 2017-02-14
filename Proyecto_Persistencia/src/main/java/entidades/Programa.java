package entidades;

import java.io.Serializable;
import java.lang.Double;
import java.lang.Long;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Programa
 *
 */
@Entity

public class Programa implements Serializable {

	
	private String nombre;
	private String Descripcion;
	private Double version;   
	@Id
	@GeneratedValue
	private Long id;
	private static final long serialVersionUID = 1L;

	public Programa() {
		super();
	}   
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}   
	public String getDescripcion() {
		return this.Descripcion;
	}

	public void setDescripcion(String Descripcion) {
		this.Descripcion = Descripcion;
	}   
	public Double getVersion() {
		return this.version;
	}

	public void setVersion(Double version) {
		this.version = version;
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
   
}
