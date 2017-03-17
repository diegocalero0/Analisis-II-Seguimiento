package entidadestest;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
import entidades.Cliente;
import entidades.TipoCliente;
import entidades.Turno;

/**
 * Test para la clase Cliente
 * @author Diego Calero
 *
 */
@RunWith(Arquillian.class)
public class ClienteTest {
	
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
		return ShrinkWrap.create(WebArchive.class, "test.war").addPackage(Cliente.class.getPackage())
				.addAsResource("persistenceForTest.xml", "META-INF/persistence.xml").addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
	}
	
	/**
	 * Metodo de prueba para la funcion Find
	 * Encuentra un cliente y compara su nombre con uno conocido.
	 */
	@Test
	@Transactional(value=TransactionMode.ROLLBACK)
	@UsingDataSet({"tipocliente.json", "administrador.json", "servicio.json", "turno.json", "cliente.json","empleado.json", "empleado_servicio.json"})
	public void findTest(){
		Cliente clienteTest = (Cliente)em.find(Cliente.class, "1094964052");
		Assert.assertEquals(clienteTest.getNombre(), "diego");
	}
	
	/**
	 * Metodo de prueba para la funcion Persist
	 * Crea un nuevo cliente y lo inserta a la BD se verifica que se haya
	 * ingresado correctamente, comparando el correo con el ingresado previamente
	 */
	@Test
	@Transactional(value=TransactionMode.ROLLBACK)
	@UsingDataSet({"tipocliente.json", "administrador.json", "servicio.json", "turno.json", "cliente.json","empleado.json", "empleado_servicio.json"})
	public void persistTest(){
		Cliente clienteTest = new Cliente();
		clienteTest.setNombre("Marcela");
		clienteTest.setApellido("Castaño");
		clienteTest.setCedula("555555");
		clienteTest.setCorreoElectronico("marce@gmail.com");
		TipoCliente tc = (TipoCliente)em.find(TipoCliente.class, "enfermo");
		clienteTest.setTipo(tc);
		Turno t = (Turno)em.find(Turno.class, 3);
		clienteTest.setTurno(t);
		em.persist(clienteTest);
		Cliente temp = (Cliente)em.find(Cliente.class, "555555");
		Assert.assertEquals(temp.getCorreoElectronico(), "marce@gmail.com");
	}
	
	/**
	 * Metodo de prueba para la funcion Remove
	 * Elimina el cliente, se consulta y se verifica que esta consulta retorn null
	 */
	@Test
	@Transactional(value=TransactionMode.ROLLBACK)
	@UsingDataSet({"tipocliente.json", "administrador.json", "servicio.json", "turno.json", "cliente.json","empleado.json", "empleado_servicio.json"})
	public void removeTest(){
		Cliente clienteTest = (Cliente)em.find(Cliente.class, "1094964052");
		Assert.assertNotNull(clienteTest);
		em.remove(clienteTest);
		Assert.assertNull(em.find(Cliente.class, "1094964052"));
	}
	
	/**
	 * Metodo de prueba para la funcion Update
	 * Se consulta un cliente se le modifica el apellido, se vuelve a consutlar
	 * y se verifica que el cambio haya sido exitoso
	 */
	@Test
	@Transactional(value=TransactionMode.ROLLBACK)
	@UsingDataSet({"tipocliente.json", "administrador.json", "servicio.json", "turno.json", "cliente.json","empleado.json", "empleado_servicio.json"})
	public void updateTest(){
		Cliente clienteTest = (Cliente)em.find(Cliente.class, "41890975");
		clienteTest.setApellido("hurtado");
		Cliente temp = (Cliente)em.find(Cliente.class, "41890975");
		Assert.assertEquals("hurtado", temp.getApellido());
	}
	
	/**
	 * Metodo test para la consulta de todos los clientes
	 * Se realiza la consulta, y se verifica que el numero de elementos coincida con los que sabemos
	 * que existen en la base de datos
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"tipocliente.json", "administrador.json", "servicio.json", "turno.json", "cliente.json","empleado.json", "empleado_servicio.json"})
	public void consultaTest(){
		TypedQuery<Cliente> q = em.createNamedQuery(Cliente.get_all, Cliente.class);
		List<Cliente> l = q.getResultList();
		Assert.assertEquals(2, l.size());
		Assert.assertTrue(l.get(0).getNombre().equals("diego") || l.get(0).getNombre().equals("lucero"));
	}
	
}
