package es.fpdual.eadmin.eadmin.mapper;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.TipoDocumento;
import es.fpdual.eadmin.eadmin.modelo.Usuario;

public abstract class BaseDocumentoMapperTest {

	@Autowired
	DocumentoMapper mapper;

	@Test
	public void deberiaInsertarUnDocumento() throws Exception {
		// Declaracion
		LocalDate fechaActual = LocalDate.now();
		Usuario usuario = new Usuario(1, "Manuel", "Master Supremo del Universo");
		Documento documento = new Documento(1, "Documento de prueba", usuario, fechaActual,
				TipoDocumento.DOCUMENTO_PADRON);
		// Entrenamiento

		// Prueba
		Integer resultado = mapper.insertarDocumento(documento);
		// Comprobacion
		assertThat(resultado, is(1));

	}
}
