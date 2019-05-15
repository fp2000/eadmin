package es.fpdual.eadmin.eadmin.modelo;

import java.time.LocalDate;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import es.fpdual.eadmin.eadmin.EadminApplication;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(callSuper = true)
@Getter
public class DocumentoContable extends Documento {

	protected final String numeroOperacionContable;
	private static Logger logger = LogManager.getLogger(EadminApplication.class);

	public DocumentoContable(int id, String nombre, Usuario usuario, LocalDate fechaCreacion,
			String numeroOperacionContable) {
		super(id, nombre, usuario, fechaCreacion, TipoDocumento.DOCUMENTO_CONTABLE);
		this.numeroOperacionContable = numeroOperacionContable;

		logger.trace("documentoContable creado correctamente");

	}

}
