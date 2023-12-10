package modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Reserva implements Serializable {

		private Categorias tipoCarro;
		private Sede sedeDondeRecogera;
		
		private LocalDateTime fechaRecoleccion; 
		private Sede sedeDondeSeEntrega;
		private LocalDateTime fechaEntrega;
		private int valorServicio;
		
		private Vehiculo vehiculo;
//		-otrosConductores:Licencia[]
		
		
		public Reserva(Categorias tipoCarro, Sede sedeDondeRecogera, LocalDateTime fechaRecoleccion,
				Sede sedeDondeSeEntrega, LocalDateTime fechaEntrega,Inventario inventario) {
			this.tipoCarro = tipoCarro;
			this.sedeDondeRecogera = sedeDondeRecogera;
			
			this.fechaRecoleccion = fechaRecoleccion;
			this.sedeDondeSeEntrega = sedeDondeSeEntrega;
			this.fechaEntrega = fechaEntrega;
			//this.valorServicio = valorServicio;
			
			this.vehiculo = inventario.conseguirCarro(fechaRecoleccion, sedeDondeSeEntrega, tipoCarro);
		}
		
		public boolean hayVehiculo()
		{
			return this.vehiculo!=null;
		}
		
		
}
