package modelo;

import java.io.Serializable;
import java.time.LocalDate;

public class MedioDePago implements Serializable{

	private String tipoPago;
	private int numeroPago;
	private LocalDate fechaVencimientoPago;	
	

	public MedioDePago(String tipo, int numero, LocalDate fecha) {
		tipoPago = tipo;
		numeroPago = numero;
		fechaVencimientoPago = fecha;
	}
	
	
	
}
