package entidadesTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
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

import entidades.Servicio;
import entidades.Turno;

/**
 * Test para la clase Turno
 * @author Diego Calero
 *
 */
@RunWith(Arquillian.class)
public class TurnoTest {
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
		return ShrinkWrap.create(WebArchive.class, "test.war").addPackage(Turno.class.getPackage())
				.addAsResource("persistenceForTest.xml", "META-INF/persistence.xml").addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
	}
	
	/**
	 * Metodo de prueba para la funcion Find
	 * Encuentra un Turno y compara su descripcion con uno conocido.
	 */
	@Test
	@Transactional(value=TransactionMode.ROLLBACK)
	@UsingDataSet({"tipocliente.json", "administrador.json", "servicio.json", "turno.json", "cliente.json","empleado.json", "empleado_servicio.json"})
	public void findTest(){
		Turno TurnoTest = (Turno)em.find(Turno.class, 2);
		Assert.assertEquals(TurnoTest.getServicio().getNombre(), "general");
	}
	
	/**
	 * Metodo de prueba para la funcion Persist
	 * Crea un nuevo Turno y lo inserta a la BD se verifica que se haya
	 * ingresado correctamente, comparando el correo con el ingresado previamente
	 */
	@Test
	@Transactional(value=TransactionMode.ROLLBACK)
	@UsingDataSet({"tipocliente.json", "administrador.json", "servicio.json", "turno.json", "cliente.json","empleado.json", "empleado_servicio.json"})
	public void persistTest(){
		Turno TurnoTest = new Turno();
		TurnoTest.setNumero(4);
		Servicio servicio = new Servicio();
		servicio.setNombre("temporal");
		servicio.setDescripcion("atencion temporal");
		TurnoTest.setServicio(servicio);
		em.persist(TurnoTest);
		Turno temp = (Turno)em.find(Turno.class, 4);
		Assert.assertEquals(temp.getServicio().getNombre(), "temporal");
	}
	
	/**
	 * Metodo de prueba para la funcion Remove
	 * Elimina el Turno, se consulta y se verifica que esta consulta retorna null
	 */
	@Test
	@Transactional(value=TransactionMode.ROLLBACK)
	@UsingDataSet({"tipocliente.json", "administrador.json", "servicio.json", "turno.json", "cliente.json","empleado.json", "empleado_servicio.json"})
	public void removeTest(){
		Turno TurnoTest = (Turno)em.find(Turno.class, 3);
		Assert.assertNotNull(TurnoTest);
		em.remove(TurnoTest);
		Assert.assertNull(em.find(Turno.class, 3));
	}
	
	/**
	 * Metodo de prueba para la funcion Update
	 * Se consulta un Turno se le modifica el servicio, se vuelve a consutlar
	 * y se verifica que el cambio haya sido exitoso
	 */
	@Test
	@Transactional(value=TransactionMode.ROLLBACK)
	@UsingDataSet({"tipocliente.json", "administrador.json", "servicio.json", "turno.json", "cliente.json","empleado.json", "empleado_servicio.json"})
	public void updateTest(){
		Turno TurnoTest = (Turno)em.find(Turno.class, 3);
		Servicio servicio = new Servicio();
		servicio.setNombre("temporal");
		servicio.setDescripcion("atencion temporal");
		TurnoTest.setServicio(servicio);
		Turno temp = (Turno)em.find(Turno.class, 3);
		
		Assert.assertEquals("temporal", temp.getServicio().getNombre());
	}
	
}
