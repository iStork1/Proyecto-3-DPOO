package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import renticar.Renticar;

public class Categorias {
//	-idCategoria:String
//
//	//(temporada alta y temporada baja), se consulta en el static de aplicación
//	-tarifaDia:int
//
//	-valorEntregaOtraSede:int
//	-valorConductorAdicional:int
	
	
	private static File archivo;
	
	private static ArrayList<Categoria> listaCategorias = new ArrayList<Categoria>();
	
	
	public static Categoria crearCategoria(int valorEntregaOtraSede, int valorConductorAdicional,String nombre)	
	{
		Categoria categoria = new Categoria(valorEntregaOtraSede, valorConductorAdicional, nombre,listaCategorias.size());
		listaCategorias.add(categoria);
		
			try {
				guardarCategorias();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return categoria;
		
	}
	
	public Categorias(File file) {
		Categorias.archivo=file;
		cargarCategorias();
	}

	public static ArrayList<Categoria> getCategorias()
	{
		return listaCategorias;
	}	
	
	public static Categoria getCategoria(String nombreBuscado)
	{	boolean centinela=true;
		int i =0;
		while (centinela)
		{
			if (listaCategorias.get(i).getNombre().equals(nombreBuscado))
			{centinela=false;}
			else {i++;}
		}
		return listaCategorias.get(i);
	}
	
	
	
	public static String[] getCategorias1()
	{
		String[] vectorCategorias = new String[listaCategorias.size()+2];
		
		vectorCategorias[0] = " ------------------------- ";
		for (int i = 0; i < listaCategorias.size(); i++) {
			vectorCategorias[i+1] = listaCategorias.get(i).getNombre();
        }
		vectorCategorias[listaCategorias.size()+1] = "Crear una nueva categoria";
		return vectorCategorias;
	}
	
	
	@SuppressWarnings("unchecked")
	private void cargarCategorias() {
        try {
            FileInputStream fileIn = new FileInputStream(archivo);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            ArrayList<Categoria> listacategorias = (ArrayList<Categoria>) objectIn.readObject();
            objectIn.close();
            fileIn.close();
            Categorias.listaCategorias = listacategorias;
        } catch (IOException | ClassNotFoundException e) {
            // Si ocurre una excepción al cargar, simplemente regresamos null
            
        }
    }
	public static void guardarCategorias() throws IOException 
	{
		FileOutputStream fileOut = new FileOutputStream(Categorias.archivo);
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

        // Escribir el HashMap en el archivo
        objectOut.writeObject(Categorias.listaCategorias);

        // Cerrar el flujo
        objectOut.close();
        fileOut.close();
		
	}
	
	
}
