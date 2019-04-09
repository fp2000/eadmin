package es.fpdual.eadmin.eadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.TipoDocumento;

import org.apache.log4j.*;

@SpringBootApplication
public class EadminApplication {

	private static Logger logger = LogManager.getLogger(EadminApplication.class);

	public static void main(String[] args) throws Exception {		
		logger.info("iniciando aplicacion");
		
		Documento documento1 = new Documento(1, "documento1", null, null, TipoDocumento.DOCUMENTO_CONTABLE);
		ToPdf pdf = new ToPdf();		
		pdf.writePDF(documento1);
		GenerateQRCode.generarCodigoQR(documento1);
		
		
		SpringApplication.run(EadminApplication.class, args);
		
		logger.info("finalizando servicios");		
		pdf.logPDF();
		
		
		
	}

}