package Interfaz;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

import Interfaz.PanelLogin;
import modelo.Categoria;
import modelo.Categorias;
import modelo.ControlUsuarios;
import modelo.HorarioAtencion;
import modelo.Sede;
import modelo.Vehiculo;
import renticar.Renticar;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class VentanaPrincipal extends JFrame {
	
	private Renticar renticar;
	private CardLayout cardLayout;
	private PanelLogin loginPanel;
	private PanelSeleccion seleccionPanel;
	private PanelRegistroVehiculo registroVehiculoPanel;
	private PanelRegistroUsuario registroUsuarioPanel;
	private PanelReserva panelReserva;
	private JPanel contPanel= new JPanel(); //este es un contenedor
	private PanelPrincipal principalPanel;

	public VentanaPrincipal() throws IOException {
		
		this.renticar=new Renticar();
		setSize( 1200, 800 );
		setTitle( "Renticar" );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		
		
		this.cardLayout =  new CardLayout();
		this.contPanel.setLayout(cardLayout);
		
		//paneles
		this.panelReserva = new PanelReserva(this);
		this.loginPanel = new PanelLogin(this);
		this.seleccionPanel = new PanelSeleccion(this);
		this.registroVehiculoPanel = new PanelRegistroVehiculo(this);
		registroUsuarioPanel= new PanelRegistroUsuario(this);
		this.principalPanel=new PanelPrincipal(this);
		
		
		contPanel.add(loginPanel, "login");
		contPanel.add(panelReserva, "reserva");
		contPanel.add(registroUsuarioPanel, "registroUsuario");
		contPanel.add(seleccionPanel, "menu");
		contPanel.add(registroVehiculoPanel, "registroVehiculo");
		contPanel.add(principalPanel, "principal");

        cardLayout.show(contPanel, "login");
        
        setLayout(new BorderLayout());

        setLocationRelativeTo(null);
        add(contPanel, BorderLayout.CENTER);
        //pack();
        
        
        
        
	}
	
	//metodos para conectar con la l�gica
	public boolean inicioSesion(String username,String passwordString){
		
		//cardLayout.show(contPanel, "menu");
		return this.renticar.loggin(username, passwordString);
	}
	
	public void registrarVehiculo(String modelo,Categoria categorias,String color,String placa,String transmision,Sede sedeUbicado) 
	{
		this.renticar.agregarVehiculo(modelo,categorias,color,placa,transmision,sedeUbicado);
	}
	
	public Vehiculo darVehiculo(String placa)
	{
		return this.renticar.darVehiculo(placa);
	}
	
	public void eliminarVehiculo(String placa)
	{
		this.renticar.eliminarVehiculo(placa);
	}
	
	public void registrarUsuario(String username,String password, String rol,String nombre,String telefono,String email,String apellido,String pais,Date fechaNacimiento, String idLicencia,Date fechaVencimientoLicencia,BufferedImage imagenLicencia,BufferedImage imagenDocumento,String idDocumento) throws IOException
	{
		this.renticar.crearUsuario(username,password, rol,nombre, telefono,email,apellido,pais,null, idLicencia,null,imagenLicencia,imagenDocumento,idDocumento);
	}
	
	
	public void crearSede(String nombre,String direccion,HorarioAtencion horariosAtencion)
	{
		try {
			this.renticar.crearSede(nombre,direccion,horariosAtencion);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Credenciales incorrectas");
			e.printStackTrace();
		}
	}
	
	public String[] darSedes()
	{
		return this.renticar.darSedes();
	}
	
	public Sede darSede(String nomSede)
	{
		return this.renticar.getSede(nomSede);
	}
	
	public boolean crearAlquiler(Categorias tipoCarro,Sede sedeDondeRecogera, LocalDateTime fechaRecoleccion,Sede sedeDondeSeEntrega,LocalDateTime fechaEntrega) throws IOException
	{
		return this.renticar.alquilarVehiculo(tipoCarro, sedeDondeRecogera, fechaRecoleccion, sedeDondeSeEntrega, fechaEntrega);
	}
	
	public boolean crearReserva(Categorias tipoCarro, Sede sedeDondeRecogera, LocalDateTime fechaRecoleccion,Sede sedeDondeSeEntrega, LocalDateTime fechaEntrega) throws IOException
	{
		return this.renticar.crearReserva(tipoCarro, sedeDondeRecogera, fechaRecoleccion, sedeDondeSeEntrega, fechaEntrega);
	}
	
	//metodos para cambiar layouts
	public void mostrarLogin() 
	{
		cardLayout.show(contPanel, "login");
	}
	public void mostrarMenu() 
	{
		cardLayout.show(contPanel, "menu");
	}
	public void mostraRegistro(String rol)
	{
		this.registroUsuarioPanel.definirComboBox(rol);
		cardLayout.show(contPanel, "registroUsuario");
	}
	public void mostrarPanelVehiculo()
	{
		cardLayout.show(contPanel, "registroVehiculo");
	}
	
	public void mostrarPanelReserva()
	{
		cardLayout.show(contPanel, "reserva");
	}
	
	public void mostrarPanelPrincipal()
	{
		cardLayout.show(contPanel, "principal");
	}
	
	

	public static void main(String[] args) throws IOException {
		VentanaPrincipal ventana = new VentanaPrincipal();
		ventana.setResizable( false );
		ventana.setVisible(true);
	}


}


