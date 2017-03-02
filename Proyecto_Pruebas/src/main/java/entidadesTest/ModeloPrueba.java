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

import entidades.Administrador;
import entidades.Empleado;
import entidades.Persona;

@RunWith(Arquillian.class)
public class ModeloPrueba {
	@PersistenceContext
	private EntityManager entityManager;

	@Deployment
	public static Archive<?> createTestArchive() {
		return ShrinkWrap.create(WebArchive.class, "test.war").addPackage(Persona.class.getPackage())
				.addAsResource("persistenceForTest.xml", "META-INF/persistence.xml").addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
	}
	
	@Test
	@Transactional(value=TransactionMode.ROLLBACK)
	@UsingDataSet({"tipocliente.json", "administrador.json", "servicio.json", "turno.json", "cliente.json","empleado.json", "empleado_servicio.json"})
	public void findTest(){
		Empleado empleado = entityManager.find(Empleado.class, "123456789");
		Assert.assertEquals("jorgegarcia@gmail.com",empleado.getCorreo_electronico());
	}
	
	@Test
	@Transactional(value=TransactionMode.ROLLBACK)
	@UsingDataSet({"tipocliente.json", "administrador.json", "servicio.json", "turno.json", "cliente.json","empleado.json", "empleado_servicio.json"})
	public void insertTest(){
		Administrador admin = new Administrador();
		admin.setCedula("555555");
		admin.setNombre("Camila");
		admin.setApellido("Gallego");
		admin.setCorreo_electronico("xxxxx@gmail.com");
		admin.setContrasenia("123456789");
		entityManager.persist(admin);
		Administrador aux = entityManager.find(Administrador.class, "555555");
		Assert.assertEquals(admin, aux);
	}
	
	@Test
	@Transactional(value=TransactionMode.ROLLBACK)
	@UsingDataSet({"tipocliente.json", "administrador.json", "servicio.json", "turno.json", "cliente.json","empleado.json", "empleado_servicio.json"})
	public void removeTest(){
		Administrador admin = new Administrador();
		admin.setCedula("555555");
		admin.setNombre("Camila");
		admin.setApellido("Gallego");
		admin.setCorreo_electronico("xxxxx@gmail.com");
		admin.setContrasenia("123456789");
		entityManager.persist(admin);
		
		Administrador admin1 = entityManager.find(Administrador.class, "555555");
		boolean aux1 = admin1 != null ? true: false;
		entityManager.remove(admin1);
		
		Administrador admin2 = entityManager.find(Administrador.class, "555555");
		boolean aux2 = admin2 == null ? true: false;
		
		Assert.assertTrue(aux1 && aux2);
	}
	
	@Test
	@Transactional(value=TransactionMode.ROLLBACK)
	@UsingDataSet({"tipocliente.json", "administrador.json", "servicio.json", "turno.json", "cliente.json","empleado.json", "empleado_servicio.json"})
	public void updateTest(){
		Administrador admin = entityManager.find(Administrador.class, "987654321");
		String apellidoAnterior = admin.getApellido();
		admin.setApellido("Garcia");
		
		Administrador aux = entityManager.find(Administrador.class, "987654321");
		String apellidoNuevo = aux.getApellido();
		
		Assert.assertTrue(!apellidoAnterior.equals(apellidoNuevo));
	}

	@Test
	@Transactional(value=TransactionMode.ROLLBACK)
	@UsingDataSet({"tipocliente.json", "administrador.json", "servicio.json", "turno.json", "cliente.json","empleado.json", "empleado_servicio.json"})
	public void queryTest(){
		String nombre = entityManager.find(Administrador.class, "987654321").getNombre();
		Assert.assertTrue(nombre.equals("Christian"));
	}
	
}
