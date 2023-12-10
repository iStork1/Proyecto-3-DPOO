package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.Map.Entry;

public class Inventario {
	private Map<String, ArrayList<Vehiculo>> vehiculos;
	private File archivo;
	
	public Inventario(File archivo)
	{
		
		this.archivo = archivo;
		this.cargarInventario();
	}
	
	
	public Map<String, ArrayList<Vehiculo>> getInventario(){
		return vehiculos;	
	}
	
	public Vehiculo getVehiculo(String placa) {
		for (Entry<String, ArrayList<Vehiculo>> entrada : vehiculos.entrySet()) {
		    String sede = entrada.getKey();
		    List<Vehiculo> listaDeVehiculos = entrada.getValue();
//		    System.out.println("Sede: " + sede); para probar que funcione
		    for (Vehiculo vehiculo : listaDeVehiculos) {
                if (vehiculo.getPlaca().equals(placa)){
                	return vehiculo;
                }
            }
        }
		//System.out.println("No se encontr√≥ el vehiculo");
		return null;
	}
	
	public Registro getLogVehiculo (String placa) {
		Vehiculo vehiculo=getVehiculo(placa);
		Registro log=vehiculo.getRegistro();
		return log;
		
	}
	
	public void cambiarSedeVehiculo(Vehiculo vehiculo,Sede sedeDondeSeRecoje , Sede sedeDondeSeDeja) {
		ArrayList<Vehiculo> ListaSedeDondeSeRecoje=vehiculos.get(sedeDondeSeRecoje.getNombre());
		ArrayList<Vehiculo> ListaSedeDondeSeDeja=vehiculos.get(sedeDondeSeDeja.getNombre());
		ListaSedeDondeSeRecoje.remove(vehiculo);
		ListaSedeDondeSeDeja.add(vehiculo);
		
	}
	
	public void agregarVehiculo(Vehiculo vehiculo) {
		if (vehiculos.containsKey(vehiculo.getnombreSede())) {
            // Si la sede ya existe, obtener la lista de veh√≠culos asociada
            List<Vehiculo> listaDeVehiculos = vehiculos.get(vehiculo.getnombreSede());
            listaDeVehiculos.add(vehiculo);
	 }
		else {
			ArrayList<Vehiculo> nuevaListaDeVehiculos = new ArrayList<>();
            nuevaListaDeVehiculos.add(vehiculo);
            vehiculos.put(vehiculo.getsedeUbicado().getNombre(), nuevaListaDeVehiculos);
		}
		try {
			this.guardarVehiculo();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void eliminarVehiculo(String placa) {
		Vehiculo vehiculo=getVehiculo(placa);
		String SedeVehiculo=vehiculo.getnombreSede();
		ArrayList<Vehiculo> listaVehiculos = vehiculos.get(SedeVehiculo);
		listaVehiculos.remove(vehiculo);
		try {
			this.guardarVehiculo();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public Vehiculo conseguirCarro(LocalDateTime fechaRecoleccion ,Sede sede,Categorias categorias ) {
		String nombreSede=sede.getNombre();
		List<Vehiculo> listaDeVehiculosEnSede = vehiculos.get(nombreSede);
		for (Vehiculo vehiculo: listaDeVehiculosEnSede) {
			if (vehiculo.estaDisponible(fechaRecoleccion, categorias)) {
				return vehiculo;
			}
		}
		return null;
		
	}

	
	// MÈtodo para cargar el HashMap desde el archivo
    @SuppressWarnings("unchecked")
	private void cargarInventario() {
        try {
            FileInputStream fileIn = new FileInputStream(archivo);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            Map<String, ArrayList<Vehiculo>> vehiculos = (Map<String, ArrayList<Vehiculo>>) objectIn.readObject();
            objectIn.close();
            fileIn.close();
            this.vehiculos = vehiculos;
        } catch (IOException | ClassNotFoundException e) {
            // Si ocurre una excepciÛn al cargar, simplemente regresamos null
            this.vehiculos = new HashMap<String, ArrayList<Vehiculo>>();
        }
    }
    
    
    public void guardarVehiculo() throws IOException 
	{
		FileOutputStream fileOut = new FileOutputStream(this.archivo);
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

        // Escribir el HashMap en el archivo
        objectOut.writeObject(this.vehiculos);

        // Cerrar el flujo
        objectOut.close();
        fileOut.close();
		
	}
//	public void iniciarInventario() {
//		if (archivo.exists()) {
//            System.out.println("El archivo ya existe.");
//        } else {
//            try {
//                // Intenta crear el archivo
//                boolean creado = archivo.createNewFile();
//                if (creado) {
//                    System.out.println("El archivo se ha creado exitosamente.");
//                } else {
//                    System.out.println("No se pudo crear el archivo.");
//                }
//            } catch (IOException e) {
//                System.out.println("Error al crear el archivo: " + e.getMessage());
//            }
//        }
//	}

}
	
