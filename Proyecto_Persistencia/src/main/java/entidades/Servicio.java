package entidades;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Servicio
 *
 */
@Entity

public class Servicio implements Serializable {

	   
	@Id
	@Column(length = 20)
	private String nombre;
	@Column(length = 250)
	private String descripcion;
	@ManyToMany(mappedBy = "servicios")
	private List<Empleado> empleados;
	private static final long serialVersionUID = 1L;

	public Servicio() {
		super();
	}   
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}   
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
   
}
