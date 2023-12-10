//package consola;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamRea
//
//import renticar.Renticar;
//
//public class Aplicacion {
//	private Renticar renticar;
//	
//	
//	public Aplicacion() throws IOException 
//	{
//		this.renticar=new Renticar();
//	}
//	
////	+pedirCredencialesyMostrarMenu():String //rol
////	+ejecutarOpcionUsuario(String):void
//	
//	public void login() throws IOException
//	{
//		System.out.println("Bienvenido a la aplicación de Renticar");
//		
//		boolean funcionando =true;
//		int opcion =0;
//		while (funcionando)
//		{
//		System.out.println("\n--------------------------------------\n¿Tiene una cuenta?:");
//		
//		System.out.println("1 para sí\n2 para no");
//		
//		try {
//			opcion = Integer.parseInt(input("->"));
//			
//			if (opcion>0 &&opcion<=2)
//				{
//				funcionando=false;	
//				}
//			
//		}
//		catch(NumberFormatException e){System.out.println("Ingresa un valor adecuado");}
//		}
//		
//		if (opcion == 1) {pedirCredenciales();}
//		if (opcion ==2) {this.renticar.crearUsuarioCliente();pedirCredenciales();}
//		
//	}
//	
//	public void pedirCredenciales()
//	{
//		boolean centinela;
//		
//		
//		System.out.println("\n--------------------------------------\nPara iniciar:");
//		
//		String username = input("Ingrese su username: ");
//		String password = input("Ingrese su password: ");
//		
//		centinela = this.renticar.getcontrolUsuarios().verificarCredencialesUsuario(username, password);
//		
//		while (!centinela)
//		{
//			System.out.println("¡Credenciales incorrectas!");
//			String usernamep = input("Ingrese su username: ");
//			String passwordp = input("Ingrese su password: ");
//			
//			centinela=this.renticar.getcontrolUsuarios().verificarCredencialesUsuario(usernamep, passwordp);
//		}
//		
//		
//		}
//		private int mostrarmenu()
//		{
//			System.out.println("Menu");
//			Object[] resultado = this.renticar.getcontrolUsuarios().generarMenuSegunUsuario(); 
//			System.out.println((String) resultado[0]);
//			System.out.println("14. Salir de la aplicación.");
//		
//			return (int) resultado[1];
//		}
//	
//	private void ejecutarOpcionUsuario() throws IOException {
//		
//		boolean funcionando=true;
//		while (funcionando == true)
//		{	int nOpciones = this.mostrarmenu();
//			int opcion = Integer.parseInt(input("Ingrese la opción que desea ejecutar: "));
//			
//			if (opcion>0 & opcion<=nOpciones)
//			{//TODO ejecutar opciones
//				//OPCIONES:
////				//todos/puede alquilar
////				String o1 = "1. Alquilar un vehículo";
////				String o2 = "2. Reservar un vehículo.";
////				String o3 = "3. Modificar una reserva.";
////				
////				//empleados
////				String o4 = "4. Reportar novedad vehículo."; //mantenimiento o algo así
////				String o5 = "5. Entrega vehículo"; //conductores adicionales y cosas así, modificar el alquiler
////				String o6 = "6. Recibir vehículo"; //entrega, recibir en la empresa}
////				
////				String o7 ="7. Reserva especial para un cliente interno";//enviar un vehiculo de una sede a otra
////				String o8 = "8. Actualizar el estado de un carro."; //mantenimiento, se estima una fecha cuando vuelva a estar disponible
////				
////				
////				//admin local / sede
////				
////				String o9 ="9. Crear una cuenta para un empleado";
////				//admin general
////				String o10 = "10.  Agregar un vehículo al inventario.";
////				String o11 = "11.  Dar de baja un vehículo en el inventario.";
////				String o12 = "12. Crear una sede.";
////				String o13 = "13. Modificar información de una sede.";//pendiente
//				
//				
//				if (opcion ==1) {this.renticar.alquilarVehiculo();}
//				
//				
//				if (opcion ==4) {this.renticar.cambiarEstadoVehiculo();}
//				if (opcion ==5) {this.renticar.entregarVehiculo();}
//				if (opcion ==6) {this.renticar.recibirVehiculo();}
//				
//				if (opcion == 9) {this.renticar.crearUsuarioEmpleado();}
////				if (opcion == 10) {this.renticar.agregarVehiculo();}
//				if (opcion == 11) {this.renticar.eliminarVehiculo();}
//				if (opcion == 12) {this.renticar.crearSede();}
//				
//			}
//			if (opcion ==14) {funcionando = false;}
//			
//			else {System.out.println("Ingrese una opción válida.");}
//		}	
//		
//		
//		
//		
//	}
//	
//	
//	
////	public static void main(String[] args) throws IOException 
////	{
////		Aplicacion aplicacion= new Aplicacion();
////		
////		aplicacion.login();
////		
////		aplicacion.ejecutarOpcionUsuario();
////	}
////	
//	
//	
//
//
//	//input funcion
//	
//	public static String input(String mensaje)
//	{
//		try
//		{
//			System.out.print(mensaje);
//			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//			return reader.readLine();
//		}
//		catch (IOException e)
//		{
//			System.out.println("Error leyendo de la consola");
//			e.printStackTrace();
//		}
//		return null;
//	}
//	
//
//}
