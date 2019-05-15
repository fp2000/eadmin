package es.fpdual.eadmin.eadmin.modelo;

import java.time.LocalDate;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
@Getter
public class Documento extends AdministracionElectronicaBase {

	protected final TipoDocumento tipoDocumento;

	public Documento(Integer id, String nombre, Usuario usuario, LocalDate fechaCreacion, TipoDocumento tipoDocumento) {
		this.id = id;
		this.nombre = nombre;
		this.usuario = usuario;
		this.fechaCreacion = fechaCreacion;
		this.tipoDocumento = tipoDocumento;
	}

	public static DocumentoBuilder builder() {
		return Documento.DocumentoBuilder.builder();
	}

	public static class DocumentoBuilder {

		private int id;

		private String nombre;

		private Usuario usuario;

		private LocalDate fechaCreacion;

		private TipoDocumento tipoDocumento;

		public static DocumentoBuilder builder() {
			return new DocumentoBuilder();
		}

		public Documento build() {
			return new Documento(this.id, this.nombre, this.usuario, this.fechaCreacion, this.tipoDocumento);
		}

		public DocumentoBuilder clone(Documento documento) {
			this.id = documento.getId();
			this.nombre = documento.getNombre();
			this.usuario = documento.getUsuario();
			this.fechaCreacion = documento.getFechaCreacion();
			this.tipoDocumento = documento.getTipoDocumento();
			return this;
		}

		public DocumentoBuilder withId(int id) {
			this.id = id;
			return this;
		}

		public DocumentoBuilder withNombre(String nombre) {
			this.nombre = nombre;
			return this;
		}

		public DocumentoBuilder withUsuario(Usuario usuario) {
			this.usuario = usuario;
			return this;
		}

		public DocumentoBuilder withFechaCreacion(LocalDate fechaCreacion) {
			this.fechaCreacion = fechaCreacion;
			return this;
		}

		public DocumentoBuilder withTipoDocumento(TipoDocumento tipoDocumento) {
			this.tipoDocumento = tipoDocumento;
			return this;
		}
	}
}
