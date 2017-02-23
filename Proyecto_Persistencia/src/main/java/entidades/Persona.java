package entidades;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Persona
 *
 */
@MappedSuperclass

public class Persona implements Serializable {

	   
	@Id
	@Column(length = 20)
	protected String cedula;
	@Column(length = 15)
	protected String nombre;
	@Column(length = 15)
	protected String apellido;
	@Column(length = 50, name = "EMAIL")
	protected String correo_electronico;
	//protected Date fecha_nacimiento;
	private static final long serialVersionUID = 1L;

	public Persona() {
		super();
	}   
	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}   
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}   
	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}   
	public String getCorreo_electronico() {
		return this.correo_electronico;
	}

	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}
	
	@Override
	public boolean equals(Object p){
		Persona per = (Persona)p;
		if(cedula == per.getCedula())
			return true;
		return false;
	}
//	public Date getFecha_nacimiento() {
//		return this.fecha_nacimiento;
//	}
//
//	public void setFecha_nacimiento(Date fecha_nacimiento) {
//		this.fecha_nacimiento = fecha_nacimiento;
//	}
   
}
