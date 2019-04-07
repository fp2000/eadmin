package es.fpdual.eadmin.eadmin.servicio;

import org.junit.Before;
import org.junit.Test;
import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import java.util.ArrayList;
import java.util.List;

public class ServicioDocumentoImplTest{
	
	RepositorioDocumento repositorioDocumento;
	ServicioDocumentoImpl servicioDocumento;
	private Documento documento = mock(Documento.class);
	
	@Before
	public void inicializarAntesDeCadaTest() {
		this.repositorioDocumento = mock(RepositorioDocumento.class);
		this.servicioDocumento = mock(ServicioDocumentoImpl.class);
	}
	
	
	@Test
	public void deberiaObtenerTodosLosDocumentos() {
		RepositorioDocumento repositorioDocumento = mock(RepositorioDocumento.class);
		final ServicioDocumentoImpl servicioDocumento = new ServicioDocumentoImpl(repositorioDocumento);
		
		final List<Documento> resultado = servicioDocumento.obtenerTodosDocumentos();
		
		List<Documento> listaDevueltaPorElRepositorio = new ArrayList<>();
		when(repositorioDocumento.obtenerTodosDocumentos()).thenReturn(listaDevueltaPorElRepositorio);
		assertEquals(listaDevueltaPorElRepositorio, resultado);
	}
	
	@Test
	public void deberiaModificarElDocumeto() {
		
		servicioDocumento.modificarDocumento(documento);
		
		verify(this.repositorioDocumento).modificarDocumento(documento);
	}
	
	@Test
	public void deberiaEliminarDocumentoConCodigoFacilitado() {
		this.servicioDocumento.eliminarDocumento(20);
		verify(this.repositorioDocumento).eliminarDocumento(20);
	}
	
	@Test 
	public void deberiaAlmacenarDocumento() {
		when(this.repositorioDocumento.getSiguiente()).thenReturn(22);
		final Documento resultado = this.servicioDocumento.altaDocumento(documento);
	}
	
	
}
