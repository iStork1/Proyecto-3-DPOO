package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class ControlUsuarios {

	
	private HashMap<String, Usuario> usuarios;
	private File archivo;
	private Usuario usuarioActual;
	
	
 	public ControlUsuarios(File archivo) {
        this.archivo = archivo;
        this.usuarios = cargarUsuariosDesdeArchivo(); // Intenta cargar el HashMap desde el archivo
        if (this.usuarios == null) {
            this.usuarios = new HashMap<>(); // Si no se pudo cargar, crea un nuevo HashMap
        }
    }

    // Método para cargar el HashMap desde el archivo
    @SuppressWarnings("unchecked")
	private HashMap<String, Usuario> cargarUsuariosDesdeArchivo() {
        try {
            FileInputStream fileIn = new FileInputStream(archivo);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            HashMap<String, Usuario> usuarios = (HashMap<String, Usuario>) objectIn.readObject();
            objectIn.close();
            fileIn.close();
            return usuarios;
        } catch (IOException | ClassNotFoundException e) {
            // Si ocurre una excepción al cargar, simplemente regresamos null
            return null;
        }
    }
	

	
	


	public boolean verificarCredencialesUsuario(String username, String password) 
	{
		
		boolean respuesta;
		if (usuarios.containsKey(username))
		{
			Usuario usuario = usuarios.get(username);
			
			if (usuario.verificarCredenciales(username, password))
			{
				respuesta = true;
				this.usuarioActual=usuario;
			}
			else {respuesta = false;}
		}
		else  { respuesta = false;}
		
		return respuesta;
		
	}
	


	
	public void guardarUsuariosRegistrados() throws IOException 
	{
		FileOutputStream fileOut = new FileOutputStream(this.archivo);
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

        // Escribir el HashMap en el archivo
        objectOut.writeObject(usuarios);

        // Cerrar el flujo
        objectOut.close();
        fileOut.close();
		
	}
	
	public Object[] generarMenuSegunUsuario() {
		
		String rol = this.usuarioActual.getRol();
		
		//todos/puede alquilar
		String o1 = "1. Alquilar un vehículo";
		String o2 = "2. Reservar un vehículo.";
		String o3 = "3. Modificar una reserva.";
		
		//empleados
		String o4 = "4. Reportar novedad vehículo."; //mantenimiento o algo así
		String o5 = "5. Entrega vehículo"; //conductores adicionales y cosas así, modificar el alquiler
		String o6 = "6. Recibir vehículo"; //entrega, recibir en la empresa}
		
		String o7 ="7. Reserva especial para un cliente interno";//enviar un vehiculo de una sede a otra
		String o8 = "8. Actualizar el estado de un carro."; //mantenimiento, se estima una fecha cuando vuelva a estar disponible
		
		
		//admin local / sede
		
		String o9 ="9. Crear una cuenta para un empleado";
		//admin general
		String o10 = "10.  Agregar un vehículo al inventario.";
		String o11 = "11.  Dar de baja un vehículo en el inventario.";
		String o12 = "12. Crear una sede.";
		String o13 = "13. Modificar información de una sede.";
		
				
		String menu =new String();
		int i = 0;
		if (rol.equals("cliente"))
		{
			menu = o1+"/n"+o2+"/n"+o3;
			i=3;
		}
		if (rol.equals("empleado"))
		{
			menu= o1 + "\n" + o2 + "\n" + o3 + "\n" + o4 + "\n" + o5 + "\n" + o6 + "\n" + o7 + "\n" + o8;
			i=8;
		}
		
		if (rol.equals("administradorLocal"))
		{
			menu= o1 + "\n" + o2 + "\n" + o3 + "\n" + o4 + "\n" + o5 + "\n" + o6 + "\n" + o7 + "\n" + o8+ "\n"+o9;
			i=9;
		}
		
		
		if (rol.equals("administradorGeneral"))
		{
			menu = o1 + "\n" + o2 + "\n" + o3 + "\n" + o4 + "\n" + o5 + "\n" + o6 + "\n" + o7 + "\n" + o8 + "\n" + o9 + "\n" + o10 + "\n" + o11 + "\n" + o12+ "\n" + o13;
			i=13;
		}
		
		return new Object[] {menu,i};
		
	}
	
	public void crearUsuario(String username, String password, String rol) throws IOException {
		
		if (!this.usuarios.containsKey(username))
		{Usuario nuevoUsuario = new Usuario(username,password,rol);
		
		usuarios.put(username,nuevoUsuario);
		
		this.guardarUsuariosRegistrados();
		}
	}
	
	public void crearAdministrador(Usuario usuario,String username) throws IOException {
		
		if (!this.usuarios.containsKey(username))
		{usuarios.put(username,usuario);}
		
		this.guardarUsuariosRegistrados();
		
	}
	
	
	public String getRolUsuarioActual() 
	{
		return this.usuarioActual.getRol();
	}
	
	public Usuario getUsuario()
	{
		return this.usuarioActual;
	}
}
