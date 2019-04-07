package es.fpdual.eadmin.eadmin.controlador;

import org.junit.Before;
import org.junit.Test;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.servicio.ServicioDocumento;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.*;

public class ControladorTest {
	
	private ControladorDocumento controlador;
	private ServicioDocumento servicioDocumento;
	
	@Before
	public void ejecutarAntesDeCadaTest() {
		this.servicioDocumento = mock(ServicioDocumento.class);
		this.controlador=new ControladorDocumento(servicioDocumento);
	}
	
	@Test
	public void deberiaAlmacenarDocumento() {
		
		Documento documentoInsertado = mock(Documento.class);
		DocumentoRequest documentoRequest = mock(DocumentoRequest.class);
				
		when(this.servicioDocumento.altaDocumento(any())).thenReturn(documentoInsertado);
		when(documentoRequest.getUsuario()).thenReturn("20");
		when(documentoRequest.getTipoDocumento()).thenReturn("DOCUMENTO_CONTABLE");
		
		final Documento resultado = this.controlador.altaDocumento(documentoRequest);
		
		assertSame(documentoInsertado, resultado);
	} 
	
	
	@Test
	public void deberiaObtenerDocumentoPorId(int id) {
		Documento documentoADevolver = mock(Documento.class);
		
		when(documentoADevolver.getId()).thenReturn(20);
		when(this.servicioDocumento.altaDocumento(any())).thenReturn(documentoADevolver);
		
		
	}
	
}
