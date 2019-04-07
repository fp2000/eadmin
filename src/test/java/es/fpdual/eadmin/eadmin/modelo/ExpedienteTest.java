package es.fpdual.eadmin.eadmin.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class ExpedienteTest {
	@Test
	public void deberiaDevolverTrueSiSonIguales() {
		final Date fecha = new Date(122584001);
		final Usuario usuario1 = new Usuario(1, "asdflg", "asdfg");
		final Expediente expediente1 = new Expediente(1, "dsfg", usuario1, fecha, TipoExpediente.EXPEDIENTE_NOMINAS, null);
		final Expediente expediente2 = new Expediente(1, "dsfg", usuario1, fecha, TipoExpediente.EXPEDIENTE_NOMINAS, null);

		final boolean comparar = expediente1.equals(expediente2);
		assertTrue(comparar);

	}

	@Test
	public void deberiaCalcularHashCode() {
		final Date fecha = new Date(122584001);
		final Usuario usuario1 = new Usuario(1, "asdfg", "asdfg");
		final Expediente expediente1 = new Expediente(1, "dsfg", usuario1, fecha, TipoExpediente.EXPEDIENTE_NOMINAS, null);
		
		final boolean compararHashCode = expediente1.hashCode() == expediente1.getId();
		assertTrue(compararHashCode);
	}
	
	@Test
	public void deberiaDevolverFalseSiSonDiferentes() {
		final Date fecha = new Date(122584001);
		final Usuario usuario1 = new Usuario(1, "asdfg", "asdfg");
		final Expediente expediente1 = new Expediente(1, "dsfg", usuario1, fecha, TipoExpediente.EXPEDIENTE_SUBVENCIONES, null);
		final Expediente expediente2 = new Expediente(2, "dsfg", usuario1, fecha, TipoExpediente.EXPEDIENTE_NOMINAS, null);

		final boolean comparar = expediente1.equals(expediente2);
		assertFalse(comparar);

	}
	
	
	@Test
	public void deberiaConstruirUnExpedienteConDocumentos() {				
		final Usuario usuario1 = new Usuario(1, "asdflg", "asdfg");	
		final Documento documento1 = new Documento(1, "dsfg", usuario1, new Date(), TipoDocumento.DOCUMENTO_CONTABLE);
		final Documento documento2 = new Documento(1, "dsfg", usuario1, new Date(), TipoDocumento.DOCUMENTO_CONTABLE);
		final Documento documento3 = new Documento(3, "dsfg", usuario1, new Date(), TipoDocumento.DOCUMENTO_PADRON);
		
		final List<Documento> documentos = new ArrayList<Documento>();
		documentos.add(documento1);
		documentos.add(documento2);
		documentos.add(documento3);

		final Expediente expediente = new Expediente(1, "dsfg", usuario1, new Date(), TipoExpediente.EXPEDIENTE_NOMINAS, documentos);
		
		assertEquals(documentos, expediente.getDocumentos());
		assertTrue(expediente.getDocumentos().contains(documento1));
		assertTrue(expediente.getDocumentos().contains(documento2));
		assertTrue(expediente.getDocumentos().contains(documento3));
		assertEquals(3, documentos.size());
					
		
		for (Documento documento : documentos) {
			if (esDocumentoContable(documento)) {
				System.out.println(documento);
			}			
		}
		
		documentos.stream().filter(documentoActual -> esDocumentoContable(documentoActual)).forEach(documentoActual -> System.out.println(documentoActual));
		
		documentos.stream().filter(this::esDocumentoContable).forEach(System.out::println);
		
		final List<Documento> documentosContables = documentos.stream().filter(this::esDocumentoContable).collect(Collectors.toList());
		
		documentos.stream()
			.map(Documento::getNombre)
			.map(String::length)
			.forEach(System.out::println);
		
		for (Documento documento: documentos) {
			System.out.println("nombre: "+ documento.getNombre() + " longitud: " + documento.getNombre().length());
			
		}
		
		
	}
	
	@Test
	public boolean deberiaObtenerLongitudNombresDocumentos() {
		final Usuario usuario1 = new Usuario(1, "asdflg", "asdfg");	
		final Documento documento1 = new Documento(1, "dsfg", usuario1, new Date(), TipoDocumento.DOCUMENTO_CONTABLE);
		final Documento documento2 = new Documento(1, "dsfg", usuario1, new Date(), TipoDocumento.DOCUMENTO_CONTABLE);
		final Documento documento3 = new Documento(3, "dsfg", usuario1, new Date(), TipoDocumento.DOCUMENTO_PADRON);
		
		final List<Documento> documentos = new ArrayList<Documento>();
		documentos.add(documento1);
		documentos.add(documento2);
		documentos.add(documento3);

		final Expediente expediente = new Expediente(1, "dsfg", usuario1, new Date(), TipoExpediente.EXPEDIENTE_NOMINAS, documentos);
		
		final List<Integer> resultado = expediente.obtenerLongitudNombresDocumentos();
		assertEquals(2, resultado.size());
		assertEquals(3, resultado.get(0).intValue());
		
		return false;
	}
	
	
	
	
	public boolean esDocumentoContable(Documento documento) {
		return documento.getTipoDocumento().equals(TipoDocumento.DOCUMENTO_CONTABLE);
	}
	
	

}
