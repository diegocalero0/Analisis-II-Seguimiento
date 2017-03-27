package entidadestest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import entidades.Cliente;
import entidades.Empleado;
import entidades.Servicio;

/**
 * Test para la clase Empleado
 * @author Diego Calero
 *
 */
@RunWith(Arquillian.class)
public class EmpleadoTest {
	
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
		return ShrinkWrap.create(WebArchive.class, "test.war").addPackage(Empleado.class.getPackage())
				.addAsResource("persistenceForTest.xml", "META-INF/persistence.xml").addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
	}
	
	/**
	 * Metodo de prueba para la funcion Find
	 * Encuentra un Empleado y compara su nombre con uno conocido.
	 */
	@Test
	@Transactional(value=TransactionMode.ROLLBACK)
	@UsingDataSet({"tipocliente.json", "administrador.json", "servicio.json", "turno.json", "cliente.json","empleado.json", "empleado_servicio.json"})
	public void findTest(){
		Empleado EmpleadoTest = (Empleado)em.find(Empleado.class, "123456789");
		Assert.assertEquals(EmpleadoTest.getNombre(), "jorge");
	}
	
	/**
	 * Metodo de prueba para la funcion Persist
	 * Crea un nuevo Empleado y lo inserta a la BD se verifica que se haya
	 * ingresado correctamente, comparando el correo con el ingresado previamente
	 */
	@Test
	@Transactional(value=TransactionMode.ROLLBACK)
	@UsingDataSet({"tipocliente.json", "administrador.json", "servicio.json", "turno.json", "cliente.json","empleado.json", "empleado_servicio.json"})
	public void persistTest(){
		Empleado EmpleadoTest = new Empleado();
		EmpleadoTest.setNombre("Dayana");
		EmpleadoTest.setApellido("Giraldo");
		EmpleadoTest.setCedula("121212");
		EmpleadoTest.setCorreoElectronico("dayanagiraldo@gmail.com");
		Date fecha = new Date();
		EmpleadoTest.setCliente_actual(em.find(Cliente.class, "1094964052"));
		em.persist(EmpleadoTest);
		Empleado temp = (Empleado)em.find(Empleado.class, "121212");
		Assert.assertEquals(temp.getCorreoElectronico(), "dayanagiraldo@gmail.com");
	}
	
	/**
	 * Metodo de prueba para la funcion Remove
	 * Elimina el Empleado, se consulta y se verifica que esta consulta retorna null
	 */
	@Test
	@Transactional(value=TransactionMode.ROLLBACK)
	@UsingDataSet({"tipocliente.json", "administrador.json", "servicio.json", "turno.json", "cliente.json","empleado.json", "empleado_servicio.json"})
	public void removeTest(){
		Empleado EmpleadoTest = (Empleado)em.find(Empleado.class, "97091724522");
		Assert.assertNotNull(EmpleadoTest);
		em.remove(EmpleadoTest);
		Assert.assertNull(em.find(Empleado.class, "97091724522"));
	}
	
	/**
	 * Metodo de prueba para la funcion Update
	 * Se consulta un Empleado se le modifica la fecha de nacimiento, se vuelve a consutlar
	 * y se verifica que el cambio haya sido exitoso
	 */
	@Test
	@Transactional(value=TransactionMode.ROLLBACK)
	@UsingDataSet({"tipocliente.json", "administrador.json", "servicio.json", "turno.json", "cliente.json","empleado.json", "empleado_servicio.json"})
	public void updateTest(){
		Empleado EmpleadoTest = (Empleado)em.find(Empleado.class, "123456789");
		String fecha = "2015-01-14";
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaDate = null;
		try {
			fechaDate = formatter.parse(fecha);
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		java.sql.Date fecha_nacimiento = new java.sql.Date(fechaDate.getTime());
		EmpleadoTest.setFechaNacimiento(fecha_nacimiento);
		Empleado temp = (Empleado)em.find(Empleado.class, "123456789");
		Assert.assertEquals(2015, temp.getFechaNacimiento().getYear() + 1900);
		Assert.assertEquals(0, temp.getFechaNacimiento().getMonth());
		Assert.assertEquals(14, temp.getFechaNacimiento().getDate());
	}
	
	/**
	 * Metodo test para la consulta de todos los Empleados
	 * Se realiza la consulta, y se verifica que el numero de elementos coincida con los que sabemos
	 * que existen en la base de datos
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"tipocliente.json", "administrador.json", "servicio.json", "turno.json", "cliente.json","empleado.json", "empleado_servicio.json"})
	public void consultaTest(){
		TypedQuery<Empleado> q = em.createNamedQuery(Empleado.get_all, Empleado.class);
		List<Empleado> l = q.getResultList();
		Assert.assertEquals(2, l.size());
		Assert.assertTrue(l.get(0).getNombre().equals("maria") || l.get(0).getNombre().equals("jorge"));
	}
	
	/**
	 * Metodo test para la consulta de todos los servicios que puede cumplir un empleado
	 * Se realiza la consulta, y se verifica que el numero de elementos coincida con los que sabemos
	 * que existen en la base de datos
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"tipocliente.json", "administrador.json", "servicio.json", "turno.json", "cliente.json","empleado.json", "empleado_servicio.json"})
	public void consultaServicios(){
		TypedQuery<Servicio> q = em.createNamedQuery(Empleado.get_all_services, Servicio.class);
		q.setParameter("x", "123456789");
		List<Servicio> l = q.getResultList();
		Assert.assertEquals(2, l.size());
		
	}
	
}
