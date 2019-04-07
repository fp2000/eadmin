package es.fpdual.eadmin.eadmin.respositorio;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import es.fpdual.eadmin.eadmin.modelo.AdministracionElectronicaException;
import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumentoEnLista;

public class RepositorioDocumentoEnListaTest {
	
	private RepositorioDocumentoEnLista repositorioDocumento;
	private Documento documento;
	
	@Before
	public void inicializarEnCadaTest() {
		this.repositorioDocumento=new RepositorioDocumentoEnLista();
		this.documento = mock(Documento.class);
	}
	
	@Test
	public void deberiaAlmacenarNuevoDocumento() {
		final Documento documento = mock(Documento.class);
		when(documento.getNombre()).thenReturn("documento1");
		when(documento.getId()).thenReturn(5);
		
		this.repositorioDocumento.altaDocumento(documento);
		assertTrue(this.repositorioDocumento.obtenerTodosDocumentos().contains(documento));
	}
	
	
	@Test (expected = AdministracionElectronicaException.class)
	public void deberiaLanzarExcepcionAlAlmacenarDocumentoYaExistente() {
		final Documento documento = mock(Documento.class);
		when(documento.getNombre()).thenReturn("documento1");
		when(documento.getId()).thenReturn(5);
		
		this.repositorioDocumento.altaDocumento(documento);
		this.repositorioDocumento.altaDocumento(documento);
		
	}
	
	
	@Test
	public void deberiaModificarUnDocumento() {

		Documento documentoAlmacenado = new Documento(20, "Doc1", null, null, null);
		Documento documentoModificado = new Documento(20, "Doc2", null, null, null);
		
		this.repositorioDocumento.altaDocumento(documentoAlmacenado);
		this.repositorioDocumento.modificarDocumento(documentoModificado);
		
		assertEquals("Doc2", repositorioDocumento.obtenerTodosDocumentos().get(0).getNombre());
		
	}
	
	@Test (expected = AdministracionElectronicaException.class)
	public void deberiaDevolverUnaExcepcionAlIntentarModificarUnDocumentoQueNoExiste() {
		
		this.repositorioDocumento.modificarDocumento(documento);				
	}
	
	@Test
	public void deberiaEliminarUnDocumento() {
		when(documento.getId()).thenReturn(20);
		this.repositorioDocumento.altaDocumento(documento);
		
		this.repositorioDocumento.eliminarDocumento(20);
		
		assertTrue(this.repositorioDocumento.obtenerTodosDocumentos().isEmpty());
		//assertFalse(this.repositorioDocumento.obtenerTodosDocumentos().contains(documento));
	}
	
	@Test
	public void deberiaNoHacerNadaSiElDocumentoAEleminarNoExiste() {
		this.repositorioDocumento.eliminarDocumento(20);
	}
	
	
	@Test
	public void deberiaDevolverIdSiguienteConListaVacia() {
		assertEquals(1, this.repositorioDocumento.getSiguiente());
	}
	
	
	@Test
	public void deberiaDevolverElValorSiguiente() {		
		when(documento.getId()).thenReturn(1);
		
		this.repositorioDocumento.altaDocumento(documento);
				
		assertEquals(2, this.repositorioDocumento.getSiguiente());
	}
	
	
}
