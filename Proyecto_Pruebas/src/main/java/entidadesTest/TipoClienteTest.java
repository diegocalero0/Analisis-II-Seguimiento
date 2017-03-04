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

import entidades.TipoCliente;

/**
 * Test para la clase TipoCliente
 * @author Diego Calero
 *
 */
@RunWith(Arquillian.class)
public class TipoClienteTest {
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
		return ShrinkWrap.create(WebArchive.class, "test.war").addPackage(TipoCliente.class.getPackage())
				.addAsResource("persistenceForTest.xml", "META-INF/persistence.xml").addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
	}
	
	/**
	 * Metodo de prueba para la funcion Find
	 * Encuentra un TipoCliente y compara su descripcion con uno conocido.
	 */
	@Test
	@Transactional(value=TransactionMode.ROLLBACK)
	@UsingDataSet({"tipocliente.json", "administrador.json", "servicio.json", "turno.json", "cliente.json","empleado.json", "empleado_servicio.json"})
	public void findTest(){
		TipoCliente TipoClienteTest = (TipoCliente)em.find(TipoCliente.class, "estandar");
		Assert.assertEquals(TipoClienteTest.getPrioridad(), 2);
	}
	
	/**
	 * Metodo de prueba para la funcion Persist
	 * Crea un nuevo TipoCliente y lo inserta a la BD se verifica que se haya
	 * ingresado correctamente, comparando el correo con el ingresado previamente
	 */
	@Test
	@Transactional(value=TransactionMode.ROLLBACK)
	@UsingDataSet({"tipocliente.json", "administrador.json", "servicio.json", "turno.json", "cliente.json","empleado.json", "empleado_servicio.json"})
	public void persistTest(){
		TipoCliente TipoClienteTest = new TipoCliente();
		TipoClienteTest.setNombre("prueba");
		TipoClienteTest.setPrioridad(5);
		em.persist(TipoClienteTest);
		TipoCliente temp = (TipoCliente)em.find(TipoCliente.class, "prueba");
		Assert.assertEquals(temp.getPrioridad(), 5);
	}
	
	/**
	 * Metodo de prueba para la funcion Remove
	 * Elimina el TipoCliente, se consulta y se verifica que esta consulta retorna null
	 */
	@Test
	@Transactional(value=TransactionMode.ROLLBACK)
	@UsingDataSet({"tipocliente.json", "administrador.json", "servicio.json", "turno.json", "cliente.json","empleado.json", "empleado_servicio.json"})
	public void removeTest(){
		TipoCliente TipoClienteTest = (TipoCliente)em.find(TipoCliente.class, "estandar");
		Assert.assertNotNull(TipoClienteTest);
		em.remove(TipoClienteTest);
		Assert.assertNull(em.find(TipoCliente.class, "estandar"));
	}
	
	/**
	 * Metodo de prueba para la funcion Update
	 * Se consulta un TipoCliente se le modifica la prioridad, se vuelve a consutlar
	 * y se verifica que el cambio haya sido exitoso
	 */
	@Test
	@Transactional(value=TransactionMode.ROLLBACK)
	@UsingDataSet({"tipocliente.json", "administrador.json", "servicio.json", "turno.json", "cliente.json","empleado.json", "empleado_servicio.json"})
	public void updateTest(){
		TipoCliente TipoClienteTest = (TipoCliente)em.find(TipoCliente.class, "enfermo");
		TipoClienteTest.setPrioridad(5);
		TipoCliente temp = (TipoCliente)em.find(TipoCliente.class, "enfermo");
		
		Assert.assertEquals(5, temp.getPrioridad());
	}
	
}
