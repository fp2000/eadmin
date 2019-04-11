package es.fpdual.eadmin.eadmin.modelo;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.Date;
import org.junit.Test;

public class DocumentoTest {

	@Test
	public void deberiaDevolverTrueSiSonIguales() {
		final LocalDate fecha = LocalDate.now();
		final Usuario usuario1 = new Usuario(1, "asdfg", "asdfg");
		final Documento documento1 = new Documento(1, "dsfg", usuario1, fecha, TipoDocumento.DOCUMENTO_CONTABLE);
		final Documento documento2 = new Documento(1, "dsfg", usuario1, fecha, TipoDocumento.DOCUMENTO_CONTABLE);

		final boolean comparar = documento1.equals(documento2);
		assertTrue(comparar);

	}

	@Test
	public void deberiaCalcularHashCode() {
		final LocalDate fecha = LocalDate.now();
		final Usuario usuario1 = new Usuario(1, "asdfg", "asdfg");
		final Documento documento1 = new Documento(1, "dsfg", usuario1, fecha, TipoDocumento.DOCUMENTO_CONTABLE);

		final boolean compararHashCode = documento1.hashCode() == documento1.getId();
		assertTrue(compararHashCode);
	}

}
