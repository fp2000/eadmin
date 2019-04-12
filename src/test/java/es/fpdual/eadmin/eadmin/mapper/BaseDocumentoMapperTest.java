package es.fpdual.eadmin.eadmin.mapper;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.TipoDocumento;
import es.fpdual.eadmin.eadmin.modelo.Usuario;

@Transactional("eadminTransactionManager")
public abstract class BaseDocumentoMapperTest {

	LocalDate fechaActual;
	Usuario usuario;
	Documento documento;

	@Autowired
	DocumentoMapper mapper;

	@Before
	public void inicializarEnCadaTest() {
		this.fechaActual = LocalDate.now();
		this.usuario = new Usuario(1, "Manuel", "Master Supremo del Universo");
		this.documento = new Documento(1, "Documento de prueba", usuario, fechaActual, TipoDocumento.DOCUMENTO_PADRON);
	}

	@Test
	public void deberiaInsertarUnDocumento() throws Exception {
		// Declaracion
		// Entrenamiento

		// Prueba
		Integer resultado = this.mapper.insertarDocumento(this.documento);
		// Comprobacion
		assertThat(resultado, is(1));

	}

	@Test
	public void deberiaRescatarElDocumento() throws Exception {
		// Declaracion

		// Entrenamiento
		this.mapper.insertarDocumento(this.documento);
		// Prueba
		Documento resultado = mapper.getDocumento(1);
		// Comprobacion
		assertThat(resultado, is(documento));
	}

	@Test
	public void deberiaModificarElDocumento() throws Exception {
		// Declaracion
		Documento modificado = Documento.builder().clone(this.documento).withNombre("Documento de prueba").build();
		// Entrenamiento
		this.mapper.insertarDocumento(this.documento);
		// Prueba
		Integer resultado = this.mapper.actualizarDocumento(modificado);

		// Comprobacion
		assertThat(resultado, is(1));
		Documento documentoActualizado = this.mapper.getDocumento(1);
		assertThat(documentoActualizado, is(notNullValue()));
		assertThat(documentoActualizado.getNombre(), is("Documento de prueba"));

	}
}
