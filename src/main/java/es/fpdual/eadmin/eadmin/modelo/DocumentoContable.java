package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import es.fpdual.eadmin.eadmin.EadminApplication;


public class DocumentoContable extends Documento{
	
	protected final String numeroOperacionContable;
	private static Logger logger = LogManager.getLogger(EadminApplication.class);


	public DocumentoContable(int id, String nombre, Usuario usuario, Date fechaCreacion,
			String numeroOperacionContable) {
		super(id, nombre, usuario, fechaCreacion, TipoDocumento.DOCUMENTO_CONTABLE);
		this.numeroOperacionContable = numeroOperacionContable;
		
		logger.trace("documentoContable creado correctamente");
		
	}

	public String getNumeroOperacionContable() {
		return numeroOperacionContable;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof DocumentoContable) {
			DocumentoContable documentoContable = (DocumentoContable) obj;
			return this.getId() == documentoContable.getId();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.getId();
	}
	
	
}
