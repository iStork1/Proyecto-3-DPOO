package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Sedes {
	
	private ArrayList<Sede> sedes;//TODO
	private File archivoSedes;
	
	public Sedes(File archivoSedes)
	{
		this.archivoSedes = archivoSedes;
		this.cargarSedes();
	}
	
	public void crearSede(String nombre,String direccion,HorarioAtencion horariosAtencion) throws IOException
	{
//		System.out.println("Para crear una nueva sede:");
		//String nombre, String direccion, HorarioAtencion horariosAtencion
		
		
		Sede sede = new Sede(nombre,direccion,horariosAtencion);
		
		this.sedes.add(sede);
		this.guardarSedes();
		
	}
	
	
	
	public String[] darSedes()
	{
		String[] arraySedes = new String[sedes.size()+1];
		
		arraySedes[0] = " ------------------------- ";
		for (int i = 0; i < sedes.size(); i++) {
			arraySedes[i+1] = sedes.get(i).getNombre();
        }
		return arraySedes;
	}
	
	public Sede getSede(String nombre)
	{
		boolean centinela =true;
		int i =0;
		while (centinela)
		{
			if (sedes.get(i).getNombre().equals(nombre))
			{
				centinela=false;
			}
			else {i++;}
		}
		return sedes.get(i);
	}
	
	

	// Método para cargar el HashMap desde el archivo
    @SuppressWarnings("unchecked")
	private void cargarSedes() {
        try {
            FileInputStream fileIn = new FileInputStream(archivoSedes);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            ArrayList<Sede> sedes = (ArrayList<Sede>) objectIn.readObject();
            objectIn.close();
            fileIn.close();
            this.sedes = sedes;
        } catch (IOException | ClassNotFoundException e) {
            // Si ocurre una excepción al cargar, simplemente regresamos null
            this.sedes = new ArrayList<Sede>();
        }
    }
    
    public void guardarSedes() throws IOException 
	{
		FileOutputStream fileOut = new FileOutputStream(this.archivoSedes);
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

        // Escribir el HashMap en el archivo
        objectOut.writeObject(this.sedes);

        // Cerrar el flujo
        objectOut.close();
        fileOut.close();
		
	}
}
