package modelo;

import java.io.Serializable;

import renticar.Renticar;

public class Categoria implements Serializable{

	private int idCategoria;
	private String nombre;
	private int tarifaDia;
	private int valorEntregaOtraSede;
	private int valorConductorAdicional;
	
	public Categoria(int valorEntregaOtraSede, int valorConductorAdicional,String nombre, int id) {
		this.idCategoria = id;
		this.nombre =nombre;
		this.tarifaDia = Renticar.getTemporada();
		this.valorEntregaOtraSede = valorEntregaOtraSede;
		this.valorConductorAdicional = valorConductorAdicional;
	}
	public String getNombre()
	{return nombre;}
}
