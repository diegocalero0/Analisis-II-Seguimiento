package entidadestest;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.Cleanup;
import org.jboss.arquillian.persistence.CleanupStrategy;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.arquillian.transaction.api.annotation.TransactionMode;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import dto.ServicioEmpleadosDTO;
import dto.ServicioNumClientesDTO;
import entidades.Empleado;
import entidades.Servicio;

/**
 * Test para la clase Servicio
 * @author Diego Calero
 *
 */
@RunWith(Arquillian.class)
public class ServicioTest {
	
	
	/**
	 * manejador de entidades, permite trabajar con las instancia de las entidades
	 * en la base de datos
	 */
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * Crea el archivo empaquetado que ejecuta las pruebas (test.war)
	 * @return el archivo empaquetado
	 */
	@Deployment
	public static Archive<?> createTestArchive() {
		return ShrinkWrap.create(WebArchive.class, "test.war").addPackage(Servicio.class.getPackage())
				.addAsResource("persistenceForTest.xml", "META-INF/persistence.xml").addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
	}
	
	/**
	 * Metodo de prueba para la funcion Find.
	 * Encuentra un Servicio y compara su descripcion con uno conocido.
	 */
	@Test
	@Transactional(value=TransactionMode.ROLLBACK)
	@UsingDataSet({"tipocliente.json", "administrador.json", "servicio.json", "turno.json", "cliente.json","empleado.json", "empleado_servicio.json"})
	public void findTest(){
		Servicio ServicioTest = (Servicio)em.find(Servicio.class, "general");
		Assert.assertEquals(ServicioTest.getDescripcion(), "Atencion general al usuario");
	}
	
	/**
	 * Metodo de prueba para la funcion Persist
	 * Crea un nuevo Servicio y lo inserta a la BD se verifica que se haya
	 * ingresado correctamente, comparando el correo con el ingresado previamente
	 */
	@Test
	@Transactional(value=TransactionMode.ROLLBACK)
	@UsingDataSet({"tipocliente.json", "administrador.json", "servicio.json", "turno.json", "cliente.json","empleado.json", "empleado_servicio.json"})
	public void persistTest(){
		Servicio ServicioTest = new Servicio();
		ServicioTest.setNombre("Pagos");
		ServicioTest.setDescripcion("Atencion de pagos");
		em.persist(ServicioTest);
		Servicio temp = (Servicio)em.find(Servicio.class, "Pagos");
		Assert.assertEquals(temp.getDescripcion(), "Atencion de pagos");
	}
	
	/**
	 * Metodo de prueba para la funcion Remove
	 * Elimina el Servicio, se consulta y se verifica que esta consulta retorna null
	 */
	@Test
	@Transactional(value=TransactionMode.ROLLBACK)
	@UsingDataSet({"tipocliente.json", "administrador.json", "servicio.json", "turno.json", "cliente.json","empleado.json", "empleado_servicio.json"})
	public void removeTest(){
		Servicio ServicioTest = (Servicio)em.find(Servicio.class, "general");
		Assert.assertNotNull(ServicioTest);
		em.remove(ServicioTest);
		Assert.assertNull(em.find(Servicio.class, "general"));
	}
	
	/**
	 * Metodo de prueba para la funcion Update
	 * Se consulta un Servicio se le modifica la descripcion, se vuelve a consutlar
	 * y se verifica que el cambio haya sido exitoso
	 */
	@Test
	@Transactional(value=TransactionMode.ROLLBACK)
	@UsingDataSet({"tipocliente.json", "administrador.json", "servicio.json", "turno.json", "cliente.json","empleado.json", "empleado_servicio.json"})
	public void updateTest(){
		Servicio ServicioTest = (Servicio)em.find(Servicio.class, "general");
		ServicioTest.setDescripcion("servicios normales");
		Servicio temp = (Servicio)em.find(Servicio.class, "general");
		
		Assert.assertEquals("servicios normales", temp.getDescripcion());
	}

	/**
	 * Metodo test para la consulta de todos los servicios
	 * Se realiza la consulta, y se verifica que el numero de elementos coincida con los que sabemos
	 * que existen en la base de datos
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"tipocliente.json", "administrador.json", "servicio.json", "turno.json", "cliente.json","empleado.json", "empleado_servicio.json"})
	public void consultaTest(){
		TypedQuery<Servicio> q = em.createNamedQuery(Servicio.get_all, Servicio.class);
		List<Servicio> l = q.getResultList();
		Assert.assertTrue(!l.isEmpty());
	}
	
	/**
	 * Metodo test para la consulta de todos los empleados que pueden atender un determinado servicio
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"tipocliente.json", "administrador.json", "servicio.json", "turno.json", "cliente.json","empleado.json", "empleado_servicio.json"})
	@Cleanup(strategy=CleanupStrategy.USED_ROWS_ONLY)
	public void consultaEmpleadosTest(){
		
		TypedQuery<Empleado> q = em.createNamedQuery(Servicio.get_empleados, Empleado.class);
		q.setParameter("nom", "general");
		List<Empleado> l = q.getResultList();
		Assert.assertEquals(2, l.size());
	}
	
	/**
	 * Metodo test para la consulta de todos los empleados que pueden atender todos los servicios
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"tipocliente.json", "administrador.json", "servicio.json", "turno.json", "cliente.json","empleado.json", "empleado_servicio.json"})
	@Cleanup(strategy=CleanupStrategy.USED_ROWS_ONLY)
	public void consultaServiciosYEmpleados(){
		
		TypedQuery<ServicioEmpleadosDTO> q = em.createNamedQuery(Servicio.get_services_and_employees, ServicioEmpleadosDTO.class);
		List<ServicioEmpleadosDTO> l = q.getResultList();
		int i;
		for(i = 0; i < l.size(); i++)
			if(l.get(i).getNombreServicio().equals("general"))
				break;
		Assert.assertEquals(3, l.size());
		/*
		PREGUNTAR EN ASESORIA!!!
		Assert.assertEquals(l.get(i).getempleados().size(), 1);
		*/
	}
	/**
	 * Metodo Test para la consulta de los servicios y el numero de clientes que solicitaron dicho servicio
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"tipocliente.json", "administrador.json", "servicio.json", "turno.json", "cliente.json","empleado.json", "empleado_servicio.json"})
	@Cleanup(strategy=CleanupStrategy.USED_ROWS_ONLY)
	public void consultaServiciosYNumClientes(){
		
		TypedQuery<ServicioNumClientesDTO> q = em.createNamedQuery(Servicio.get_services_and_num_clientes, ServicioNumClientesDTO.class);
		List<ServicioNumClientesDTO> l = q.getResultList();
		for(int i = 0; i < l.size(); i++)
			System.out.println(l.get(i).getServicio().getDescripcion()+ " " + l.get(i).getNumClientes());
		Assert.assertEquals(2, l.size());
		/*
		PREGUNTAR EN ASESORIA!!!
		Assert.assertEquals(l.get(i).getempleados().size(), 1);
		*/
	}
}
