package Interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import modelo.Vehiculo;

public class PanelPrincipal extends JPanel implements ActionListener {
	private VentanaPrincipal ventana;
	private MatrizColoreada Grafica;
	private JLabel lblDisponibilidad;
    private JLabel lblMarca;
    private JLabel lblPlaca;
    private JLabel lblTipoDeTransmision;
    private JLabel lblSede;
    private JLabel lblModeloDeVehiculo;
    private JLabel lblColor;
    private JLabel lblCapacidad;
    private JLabel lblTitulo;
    
    private JTextField txtDisponibilidad;
    private JTextField txtMarca;
    private JTextField txtPlaca;
    private JTextField txtTipoDeTransmision;
    private JTextField txtSede;
    private JTextField txtModeloDeVehiculo;
    private JTextField txtColor;
    private JTextField txtCapacidad;
    
    private JButton btnConsultarVehiculo;
    private JButton btnRegistrarVehiculo;
    private JButton btnEliminarVehiculo;
    private JButton btnReportarNovedades;
    private JButton btnVerGrafica;
    private JButton btnRegresarMenu;
    
    private JPanel panelBotones;
    private JPanel panelInformacion;
    private Vehiculo vehiculoActual;
    
    
	public PanelPrincipal(VentanaPrincipal ventana) {
		this.ventana = ventana;
		
		
		 setLayout(new BorderLayout( ));
		 panelBotones = new JPanel( );
		 setSize( 750, 600 );
		 lblTitulo=new JLabel("Pantalla Principal");
		
		 add(panelBotones,BorderLayout.EAST);
		 
	     panelInformacion = new JPanel( );
	     
	     
	     panelInformacion.setLayout(new GridLayout(8, 2, 100, 5)); 
	     
	     lblDisponibilidad=new JLabel("Disponibilidad:");
	     panelInformacion.add(lblDisponibilidad);
	     txtDisponibilidad=new JTextField(" ");
	     panelInformacion.add(txtDisponibilidad);
	     txtDisponibilidad.setEditable( false );
	     lblDisponibilidad.setHorizontalAlignment(SwingConstants.CENTER);
	     txtDisponibilidad.setPreferredSize(new Dimension(230, 30));
	     
	     lblMarca=new JLabel("Marca:");
	     panelInformacion.add(lblMarca);
	     txtMarca=new JTextField(" ");
	     panelInformacion.add(txtMarca);
	     txtMarca.setEditable( false );
	     lblMarca.setHorizontalAlignment(SwingConstants.CENTER);
	     
	     lblPlaca=new JLabel("Placa:");
	     panelInformacion.add(lblPlaca);
	     txtPlaca=new JTextField(" ");
	     panelInformacion.add(txtPlaca);
	     txtPlaca.setEditable( false );
	     lblPlaca.setHorizontalAlignment(SwingConstants.CENTER);
	     
	     lblTipoDeTransmision=new JLabel("Tipo De Transmision:");
	     panelInformacion.add(lblTipoDeTransmision);
	     txtTipoDeTransmision=new JTextField(" ");
	     panelInformacion.add(txtTipoDeTransmision);
	     txtTipoDeTransmision.setEditable( false );
	     lblTipoDeTransmision.setHorizontalAlignment(SwingConstants.CENTER);
	     
 	     lblSede=new JLabel("Sede:");
	     panelInformacion.add(lblSede);
	     txtSede=new JTextField(" ");
	     panelInformacion.add(txtSede);
	     txtSede.setEditable( false );
	     lblSede.setHorizontalAlignment(SwingConstants.CENTER);
	     
	     
	     lblModeloDeVehiculo=new JLabel("Modelo del vehiculo:");
	     panelInformacion.add(lblModeloDeVehiculo);
	     txtModeloDeVehiculo=new JTextField(" ");
	     panelInformacion.add(txtModeloDeVehiculo);
	     txtModeloDeVehiculo.setEditable( false );
	     lblModeloDeVehiculo.setHorizontalAlignment(SwingConstants.CENTER);
	     
	     lblColor=new JLabel("Color:");
	     panelInformacion.add(lblColor);
	     txtColor=new JTextField(" ");
	     panelInformacion.add(txtColor);
	     txtColor.setEditable( false );
	     lblColor.setHorizontalAlignment(SwingConstants.CENTER);
	     
	     lblCapacidad=new JLabel("Capacidad:");
	     panelInformacion.add(lblCapacidad);
	     txtCapacidad=new JTextField(" ");
	     panelInformacion.add(txtCapacidad);
	     txtCapacidad.setEditable( false );
	     lblCapacidad.setHorizontalAlignment(SwingConstants.CENTER);
	     
	     validate();
	    
	     add(panelInformacion,BorderLayout.CENTER);

	     //Panel Botones
	     panelBotones.setLayout(new GridLayout(11,1));
	     
	     panelBotones.add(new JLabel( ));
	     
	     btnConsultarVehiculo=new JButton("Consultar Vehículo");
	     panelBotones.add(btnConsultarVehiculo);
	     btnConsultarVehiculo.addActionListener( this );
	     btnConsultarVehiculo.setActionCommand( "Consultar" );
	     
	     panelBotones.add(new JLabel( ));
	     
	     btnRegistrarVehiculo=new JButton("Registrar Vehículo");
	     panelBotones.add(btnRegistrarVehiculo);
	     btnRegistrarVehiculo.addActionListener( this );
	     btnRegistrarVehiculo.setActionCommand( "Registrar" );
	     
	     panelBotones.add(new JLabel( ));
	     
	     btnEliminarVehiculo=new JButton("Eliminar Vehículo");
	     panelBotones.add(btnEliminarVehiculo);
	     btnEliminarVehiculo.addActionListener( this );
	     btnEliminarVehiculo.setActionCommand( "Eliminar" );
	     
	     panelBotones.add(new JLabel( ));
	     
	     btnReportarNovedades=new JButton("Reportar Novedades");
	     panelBotones.add(btnReportarNovedades);
	     btnReportarNovedades.addActionListener( this );
	     btnReportarNovedades.setActionCommand( "Novedades" );
	     
	     panelBotones.add(new JLabel( ));
	     
	     btnVerGrafica=new JButton("Ver Grafica");
	     panelBotones.add(btnVerGrafica);
	     btnVerGrafica.addActionListener( this );
	     btnVerGrafica.setActionCommand( "Grafica" );
	     
	     panelBotones.add(new JLabel( ));
	     
	     btnRegresarMenu=new JButton("Regresar al menu");
	     panelBotones.add(btnRegresarMenu);
	     btnRegresarMenu.addActionListener( this );
	     btnRegresarMenu.setActionCommand( "menu" );
	     panelBotones.add(new JLabel( ));
	     
	}
	public void actualizar(Vehiculo vehiculo)
    {
		if (vehiculo.isDisponible()){
			txtDisponibilidad.setText("Disponible");
		}else {
			txtDisponibilidad.setText("No Disponible");
		}
		txtMarca.setText( vehiculo.getmarca());
		txtPlaca.setText( vehiculo.getPlaca());
		txtTipoDeTransmision.setText( vehiculo.getTransmision());
		txtSede.setText( vehiculo.getsedeUbicado().getNombre());
		txtModeloDeVehiculo.setText( vehiculo.getmodelo());
		txtColor.setText( vehiculo.getcolor());
		vehiculoActual=vehiculo;
//		TODO txtCapacidad.setText( vehiculo.);

    }
	public void actionPerformed( ActionEvent evento )
    {
        // TODO Auto-generated method stub
        if(evento.getActionCommand( ).equals( "Consultar" ))
        {	String placa = JOptionPane.showInputDialog("Ingrese la placa del vehiculo");
        	this.vehiculoActual=ventana.darVehiculo(placa);
        	this.actualizar(vehiculoActual);
        }
        else if (evento.getActionCommand( ).equals( "Registrar" ))
        {
            this.ventana.mostrarPanelVehiculo();
        }
        else if (evento.getActionCommand( ).equals( "Eliminar" ))
        {
        	String placa = JOptionPane.showInputDialog("Ingrese la placa del vehiculo");
        	if(placa!=null)
            {
                try
                {
                  	this.ventana.eliminarVehiculo(placa);
                }
                catch( Exception e )
                {
                	JOptionPane.showMessageDialog(null, "No se encontró el vehiculo");
                }
            }
        	
        }
        else if (evento.getActionCommand( ).equals( "Novedades" ))
        {
        	String[] opciones = {"En Mantenimiento", "Alquilado", "Disponible"};
            JComboBox<String> desplegable = new JComboBox<>(opciones);

            int resultado = JOptionPane.showOptionDialog(
                    panelInformacion,
                    desplegable,
                    "Seleccione el estado del vehículo",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, null, null);

            if (resultado == JOptionPane.OK_OPTION) {
                String seleccion = (String) desplegable.getSelectedItem();
                // Aquí puedes realizar acciones con la opción seleccionada, por ejemplo, mostrar un mensaje
                JOptionPane.showMessageDialog(panelInformacion, "Estado seleccionado: " + seleccion,"Resultado", JOptionPane.INFORMATION_MESSAGE);
//             TODO   Cambia estado vehiculoActual.setEstado(seleccion, null);
            }
        	//cambiar estado vehiculo
        }
        else if (evento.getActionCommand( ).equals( "Grafica" ))
        {
        	Grafica=new MatrizColoreada();
        	Grafica.setVisible(true);
        	Grafica.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
        else if (evento.getActionCommand( ).equals( "menu" ))
        {
        	this.ventana.mostrarMenu();
        }
    }
}