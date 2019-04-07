package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;

public class DocumentoFactura extends Documento{
	
	protected final int importe;

	public DocumentoFactura(int id, String nombre, Usuario usuario, Date fechaCreacion,
			int importe) {
		super(id, nombre, usuario, fechaCreacion, TipoDocumento.DOCUMENTO_FACTURA);
		this.importe = importe;
	}

	public int getImporte() {
		return importe;
	}
		
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof DocumentoFactura) {
			DocumentoFactura documentoFactura = (DocumentoFactura) obj;
			return this.getId() == documentoFactura.getId();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.getId();
	}
	

	
}
