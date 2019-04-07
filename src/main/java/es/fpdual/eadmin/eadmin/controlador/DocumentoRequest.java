package es.fpdual.eadmin.eadmin.controlador;
public class DocumentoRequest {
	private String nombre;
	private String usuario;
	private String tipoDocumento;
	
	
	public DocumentoRequest() {
		super();
	}


	public DocumentoRequest(String nombre, String usuario, String tipoDocumento) {
		this.nombre = nombre;
		this.usuario = usuario;
		this.tipoDocumento = tipoDocumento;
	}
	

	public String getNombre() {
		return nombre;
	}

	public String getUsuario() {
		return usuario;
	}


	public String getTipoDocumento() {
		return tipoDocumento;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	
	
	
	
}
