package entidades;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Clase de la entidad: Persona
 *
 */
@MappedSuperclass
public class Persona implements Serializable {

	/**
	 * Cedula de la persona
	 */
	@Id
	@Column(length = 20)
	protected String cedula;
	/**
	 * Nombre de la persona
	 */
	@Column(length = 15)
	protected String nombre;
	/**
	 * Apellido de la persona
	 */
	@Column(length = 15)
	protected String apellido;
	/**
	 * Correo electronico de la persona
	 */
	@Column(length = 50, name = "EMAIL")
	protected String correoElectronico;
	/**
	 * Fecha de nacimiento de la persona
	 */
	@Temporal(TemporalType.TIMESTAMP)
	protected Date fechaNacimiento;
	/**
	 * Serial que representa la clase serializable
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Constructor vacio para la clase Persona
	 */
	public Persona() {
		super();
	} 
	/**
	 * Metodo get del atributo cedula
	 * @return la cedula de la persona
	 */
	public String getCedula() {
		return this.cedula;
	}
	/**
	 * Metodo set del atributo cedula (Este metodo en el presente proyecto no debe ser usado)
	 * @param cedula la cedula nueva de la persona
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}   
	/**
	 * Metodo get del atributo nombre
	 * @return el nombre de la persona
	 */
	public String getNombre() {
		return this.nombre;
	}
	/**
	 * Metodo set del atributo nombre
	 * @param nombre el nuevo nombre de la persona
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}   
	/**
	 * Metodo get del atributo apellido
	 * @return el apellido de la persona
	 */
	public String getApellido() {
		return this.apellido;
	}
	/**
	 * Metodo set del atributo persona
	 * @param apellido el nuevo apellido de la persona
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}   
	/**
	 * Metodo get del atributo correo_electronico
	 * @return el correo actual de la persona
	 */
	public String getCorreoElectronico() {
		return this.correoElectronico;
	}
	/**
	 * Metodo set del atributo correo_electronico
	 * @param correo_electronico el nuevo correo electronico
	 */
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	/**
	 * Metodo get del atributo fecha_nacimiento
	 * @return la fecha de nacimiento de la persona
	 */
	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}
	/**
	 * Metodo set del atributo fecha de nacimiento
	 * @param fecha_nacimiento la nueva fecha de nacimiento
	 */
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	/**
	 * Metodo equals sobreescrito para comparar dos entidades
	 * @param p el objeto con el cual se va a comparar la persona
	 */
	@Override
	public boolean equals(Object p){
		Persona per = (Persona)p;
		if(cedula == per.getCedula())
			return true;
		return false;
	}
}
