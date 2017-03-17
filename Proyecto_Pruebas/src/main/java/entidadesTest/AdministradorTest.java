package entidadestest;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
import entidades.Administrador;

/**
 * Test para la clase Administrador
 * @author Diego Calero
 *
 */
@RunWith(Arquillian.class)
public class AdministradorTest {
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
		return ShrinkWrap.create(WebArchive.class, "test.war").addPackage(Administrador.class.getPackage())
				.addAsResource("persistenceForTest.xml", "META-INF/persistence.xml").addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
	}
	
	/**
	 * Metodo de prueba para la funcion Find
	 * Encuentra un administrador y compara su apellido con uno conocido.
	 */
	@Test
	@Transactional(value=TransactionMode.ROLLBACK)
	@UsingDataSet({"tipocliente.json", "administrador.json", "servicio.json", "turno.json", "cliente.json","empleado.json", "empleado_servicio.json"})
	public void findTest(){
		Administrador adminTest = (Administrador)em.find(Administrador.class, "987654321");
		Assert.assertEquals(adminTest.getApellido(), "Candela");
	}
	
	/**
	 * Metodo de prueba para la funcion Persist
	 * Crea un nuevo administrador y lo inserta a la BD se verifica que se haya
	 * ingresado correctamente, comparando la cedula con la ingresada previamente
	 */
	@Test
	@Transactional(value=TransactionMode.ROLLBACK)
	@UsingDataSet({"tipocliente.json", "administrador.json", "servicio.json", "turno.json", "cliente.json","empleado.json", "empleado_servicio.json"})
	public void persistTest(){
		Administrador adminTest = new Administrador();
		adminTest.setNombre("Diego");
		adminTest.setApellido("Calero");
		adminTest.setCedula("88888");
		adminTest.setContrasenia("1111");
		adminTest.setCorreoElectronico("diegoacalero0@gmail.com");
		em.persist(adminTest);
		Administrador temp = (Administrador)em.find(Administrador.class, "88888");
		Assert.assertEquals(temp.getContrasenia(), "1111");
	}
	
	/**
	 * Metodo de prueba para la funcion Remove
	 * Elimina el Administrador, se consulta y se verifica que esta consulta retorna null
	 */
	@Test
	@Transactional(value=TransactionMode.ROLLBACK)
	@UsingDataSet({"tipocliente.json", "administrador.json", "servicio.json", "turno.json", "cliente.json","empleado.json", "empleado_servicio.json"})
	public void removeTest(){
		Administrador adminTest = (Administrador)em.find(Administrador.class, "987654321");
		Assert.assertNotNull(adminTest);
		em.remove(adminTest);
		Assert.assertNull(em.find(Administrador.class, "987654321"));
	}
	
	/**
	 * Metodo de prueba para la funcion Update
	 * Se consulta un Administrador se le modifica el apellido, se vuelve a consutlar
	 * y se verifica que el cambio haya sido exitoso
	 */
	@Test
	@Transactional(value=TransactionMode.ROLLBACK)
	@UsingDataSet({"tipocliente.json", "administrador.json", "servicio.json", "turno.json", "cliente.json","empleado.json", "empleado_servicio.json"})
	public void updateTest(){
		Administrador adminTest = (Administrador)em.find(Administrador.class, "987654321");
		adminTest.setApellido("Galvis");
		Administrador temp = (Administrador)em.find(Administrador.class, "987654321");
		Assert.assertEquals("Galvis", temp.getApellido());
	}
	
	/**
	 * Metodo test para la consulta de todos los administradores
	 * Se realiza la consulta, y se verifica que el numero de elementos coincida con los que sabemos
	 * que existen en la base de datos
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"tipocliente.json", "administrador.json", "servicio.json", "turno.json", "cliente.json","empleado.json", "empleado_servicio.json"})
	public void consultaTest(){
		TypedQuery<Administrador> q = em.createNamedQuery(Administrador.get_all, Administrador.class);
		List<Administrador> l = q.getResultList();
		Assert.assertEquals(1, l.size());
	}
	
}
