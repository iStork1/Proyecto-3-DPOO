package modelo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Sede implements Serializable{
	public ArrayList<Usuario> Empleados=new ArrayList<Usuario>();
	private String nombre;
	private String direccion;
	private HorarioAtencion horariosAtencion;
	
	
	public Sede(String nombre, String direccion, HorarioAtencion horariosAtencion) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.horariosAtencion = horariosAtencion;
	}
	public boolean dentroHorariosAtencion(LocalDateTime fecha) {
		
		return horariosAtencion.disponibleEnHoras(fecha);
	}
	public String getNombre() {

		return this.nombre;
	}

}
