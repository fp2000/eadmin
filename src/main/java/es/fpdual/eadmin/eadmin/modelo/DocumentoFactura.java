package es.fpdual.eadmin.eadmin.modelo;

import java.time.LocalDate;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(callSuper = true)
@Getter
public class DocumentoFactura extends Documento {

	protected final int importe;

	public DocumentoFactura(int id, String nombre, Usuario usuario, LocalDate fechaCreacion, int importe) {
		super(id, nombre, usuario, fechaCreacion, TipoDocumento.DOCUMENTO_FACTURA);
		this.importe = importe;
	}
}
