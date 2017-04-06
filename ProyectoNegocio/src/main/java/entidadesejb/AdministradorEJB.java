package entidadesejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entidades.Servicio;

/**
 * Session Bean implementation class AdministradorEJB
 */
@Stateless
@LocalBean
public class AdministradorEJB implements AdministradorEJBRemote {

	@PersistenceContext
	EntityManager em;
	
	/**
	 * Método que crea un servicio.
	 * @param servicio el servicio a crear.
	 * @return el servicio creado.
	 */
	public Servicio crearServicio(Servicio servicio){
		if(servicio == null || servicio.getNombre().trim().equals("") || servicio.getDescripcion().trim().equals(""))
			throw new RuntimeException("Los datos no pueden estar vacios");
		if(buscarServicio(servicio.getNombre(), true) != null)
			throw new RuntimeException("El servicio no se encuentra");
		em.persist(servicio);
		return servicio;
	}
	
	/**
	 * Método que busca un servicio.
	 * @param parametro el parametro por el cual buscar
	 * @param opcion si opcion es true busca por nombre, de lo contrario busca por descripcion
	 * @return el servicio, null si no existe.
	 */
	public Servicio buscarServicio(String parametro, boolean opcion){
		if(opcion){
			return em.find(Servicio.class, parametro);
		}else{
			TypedQuery<Servicio> query = em.createQuery(Servicio.get_service_with_def_description, Servicio.class);
			query.setParameter("description", parametro);
			List<Servicio> result = query.getResultList();
			return result.size() > 0 ? result.get(0) : null;
		}
	}
	
	/**
	 * Modifica la descripcion del servicio dado
	 * @param servicio el servicio con los nuevos datos
	 * @return el servicio modificado
	 */
	public Servicio modificarServicio(Servicio servicio){
		if(servicio == null || servicio.getNombre().trim().equals("") || servicio.getDescripcion().trim().equals(""))
			throw new RuntimeException("Los datos no pueden estar vacios");
		if(buscarServicio(servicio.getNombre(), true) == null)
			throw new RuntimeException("El servicio no se encuentra");
		Servicio s = buscarServicio(servicio.getDescripcion(), false);
		if(s.getNombre() != servicio.getNombre())
			throw new RuntimeException("Ya se encuentra un servicio con esa descripion");
		em.merge(servicio);
		return servicio;
	}

}
