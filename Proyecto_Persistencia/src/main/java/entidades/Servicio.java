package entidades;

import java.io.Serializable;
import java.lang.String;
import java.util.List;
import javax.persistence.*;

/**
 * Clase de la entidad: Servicio
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name = Servicio.get_all, query = "select servicio from Servicio servicio"),
	@NamedQuery(name = Servicio.get_empleados, query = "select e from Empleado e, IN(e.servicios) servicio where servicio.nombre = :nom"),
	@NamedQuery(name = Servicio.get_services_and_employees, query = "select new dto.ServiciosEmpleadosDTO(s.nombre, e) from Servicio s, IN(s.empleados) e ")
})
public class Servicio implements Serializable {
	public static final String get_all = "Servicio_getall";
	public static final String get_empleados = "Servicio_get_empleados";
	public static final String get_services_and_employees = "Servicio_get_services_and_employees";
	/**
	 * nombre del servicio
	 */
	@Id
	@Column(length = 20)
	private String nombre;
	/**
	 * Breve descripcion del servicio
	 */
	@Column(length = 250)
	private String descripcion;
	/**
	 * Lista de empleados que pueden manejar este servicio
	 */
	@ManyToMany(mappedBy = "servicios")
	private List<Empleado> empleados;
	/**
	 * Serial que representa la clase serializable
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Constructor vacio para la clase Servicio
	 */
	public Servicio() {
		super();
	}   
	/**
	 * Metodo get del atributo nombre
	 * @return el nombre del servicio
	 */
	public String getNombre() {
		return this.nombre;
	}
	/**
	 * Metodo set del atributo nombre
	 * @param nombre el nuevo nombre del servicio
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}   
	/**
	 * Metodo get del atributo descripcion
	 * @return la descripcion del servicio
	 */
	public String getDescripcion() {
		return this.descripcion;
	}
	/**
	 * Metodo set del atributo descripcion
	 * @param descripcion la nueva descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
   
}
