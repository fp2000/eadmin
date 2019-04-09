package es.fpdual.eadmin.eadmin;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import es.fpdual.eadmin.eadmin.modelo.Documento;

public class ToPdf {

	public void writePDF(Documento documento) {

		try {
			Document document = new Document();

			PdfWriter.getInstance(document, new FileOutputStream(documento.getNombre() + ".pdf"));

			document.open();

			Paragraph paragraphContent = new Paragraph(
					"\n****************************************************\n documento creado correctamente\n id: "
							+ documento.getId() + "\n Nombre: " + documento.getNombre() + "\n Usuario: "
							+ documento.getUsuario() + "\n fecha: " + documento.getFecha() + "\n tipo de documento: "
							+ documento.getTipoDocumento() + "\n****************************************************");

			document.add(paragraphContent);

			document.close();

		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
	}

	public void logPDF() {

		try {
			String cadena;
			FileReader file = new FileReader("salida.log");
			BufferedReader br = new BufferedReader(file);
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream("log.pdf"));

			document.open();

			Paragraph paragraphContent = new Paragraph();
			try {
				while ((cadena = br.readLine()) != null) {
					paragraphContent.add(cadena + "\n");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

			document.add(paragraphContent);

			document.close();

		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
	}
}
