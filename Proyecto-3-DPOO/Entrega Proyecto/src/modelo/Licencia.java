package modelo;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.time.LocalDateTime;

public class Licencia implements Serializable {

	private String numeroLic;
	private String paisExpedicion;
	private LocalDateTime fechaVencimientoLic;
	private BufferedImage imagenLic;
	
	
	
	public Licencia(String num, String pais, LocalDateTime fecha, BufferedImage imagen) {
		numeroLic = num;
		paisExpedicion = pais;
		fechaVencimientoLic = fecha;
		imagenLic = imagen;
	}

}
