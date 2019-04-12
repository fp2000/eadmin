package es.fpdual.eadmin.eadmin.modelo;

public enum TipoDocumento {

	DOCUMENTO_CONTABLE("1"), DOCUMENTO_FACTURA("2"), DOCUMENTO_NOMINA("3"), DOCUMENTO_SUBVENCION("4"), DOCUMENTO_PADRON(
			"5");

	private String id;

	private TipoDocumento(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

}
