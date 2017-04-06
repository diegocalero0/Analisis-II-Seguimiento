package entidadestest;

import java.sql.Timestamp;
import java.util.List;

import javax.ejb.EJB;
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
import entidades.Servicio;
import entidadesejb.*;

/**
 * Test para la clase AdministradorEJB
 * @author Diego Calero
 *
 */
@RunWith(Arquillian.class)
public class AdministradorEJBTest {
	/**
	 * manejador de entidades, permite trabajar con las instancia de las entidades
	 * en la base de datos
	 */
	@PersistenceContext
	private EntityManager em;
	
	@EJB
	private AdministradorEJB ejb;
	/**
	 * Crea el archivo empaquetado que ejecuta las pruebas (test.war)
	 * @return el archivo empaquetado
	 */
	@Deployment
	public static Archive<?> createTestArchive() {
		return ShrinkWrap.create(WebArchive.class, "test.war").addPackage(Administrador.class.getPackage()).addPackage(AdministradorEJB.class.getPackage())
				.addAsResource("persistenceForTest.xml", "META-INF/persistence.xml").addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
	}
	
	/**
	 * Método de prueba para los metodos buscar del EJB del administrador
	 */
	@Test
	@Transactional(value=TransactionMode.ROLLBACK)
	@UsingDataSet({"tipocliente.json", "administrador.json", "empleado.json", "cliente.json", "servicio.json", "turno.json", "empleado_servicio.json"})
	public void findTest(){
		Servicio s = ejb.buscarServicio("", false);
	}
	
}
