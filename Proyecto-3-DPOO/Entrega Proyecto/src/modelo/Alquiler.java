package modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Alquiler implements Serializable{
	private Categorias tipoCarro;
	private Sede sedeDondeRecogera;
	private LocalDateTime fechaRecoleccion; 
	private Sede sedeDondeSeEntrega;
	private LocalDateTime fechaEntrega;
	private int valorServicio;
	private Vehiculo vehiculoAlquilado;
	private Usuario usuario;
//	-otrosConductores:Licencia[]
	
	
	
	public Alquiler(Categorias tipoCarro, Sede sedeDondeRecogera, LocalDateTime fechaRecoleccion,
			Sede sedeDondeSeEntrega, LocalDateTime fechaEntrega, Inventario inventario,Usuario usuario) {
		this.tipoCarro = tipoCarro;
		this.sedeDondeRecogera = sedeDondeRecogera;
		this.fechaRecoleccion = fechaRecoleccion;
		this.sedeDondeSeEntrega = sedeDondeSeEntrega;
		this.fechaEntrega = fechaEntrega;
		
		this.usuario = usuario;
		
		vehiculoAlquilado=inventario.conseguirCarro(fechaRecoleccion, sedeDondeRecogera, tipoCarro);
		
		if (this.hayVehiculo())
		{this.vehiculoAlquilado.setAlquiler(this);}
		
		
		
		//this.valorServicio = valorServicio;
	}
	public Usuario getUsuario()
	{
		return this.usuario;
	}
	public boolean hayVehiculo()
	{
		return this.vehiculoAlquilado!=null;
	}
	
	

}
