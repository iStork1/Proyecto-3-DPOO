package Interfaz;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelSeleccion extends JPanel implements ActionListener{

	private VentanaPrincipal ventana; 
	private JLabel lblTitulo;
	private JButton btnVerVehiculos;
	private JButton btnRegistrarVehiculos;
	private JButton btnEliminarVehiculos;
	private JButton btnRegistrarEmpleado;
	private JButton btnCrearReserva;
	private JButton btnModificarReserva;
	
	public PanelSeleccion(VentanaPrincipal ventana) {
		this.ventana=ventana;
		// TODO Auto-generated constructor stub
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 4;
		gbc.insets = new Insets(10, 10, 10, 10);
		
		lblTitulo = new JLabel("Elegir ventana");
		btnVerVehiculos = new JButton("Ver vehículos");
		btnVerVehiculos.addActionListener(this);
		btnVerVehiculos.setActionCommand("VerVerhiculo");
		btnVerVehiculos.setPreferredSize(new Dimension(150,30));
		btnRegistrarVehiculos = new JButton("Registrar vehículo");
		btnRegistrarVehiculos.addActionListener(this);
		btnRegistrarVehiculos.setActionCommand("RegistrarVerhiculo");
		btnRegistrarVehiculos.setPreferredSize(new Dimension(150,30));
		btnEliminarVehiculos = new JButton("Eliminar vehículo");
		btnEliminarVehiculos.addActionListener(this);
		btnEliminarVehiculos.setActionCommand("EliminarVerhiculo");
		btnEliminarVehiculos.setPreferredSize(new Dimension(150,30));
		btnRegistrarEmpleado = new JButton("Registrar empleado");
		btnRegistrarEmpleado.addActionListener(this);
		btnRegistrarEmpleado.setActionCommand("RegistrarEmpleado");
		btnRegistrarEmpleado.setPreferredSize(new Dimension(150,30));
		btnCrearReserva = new JButton("Crear reserva");
		btnCrearReserva.addActionListener(this);
		btnCrearReserva.setActionCommand("CrearReserva");
		btnCrearReserva.setPreferredSize(new Dimension(150,30));
		btnModificarReserva = new JButton("Modificar reserva");
		btnModificarReserva.addActionListener(this);
		btnModificarReserva.setActionCommand("ModificarReserva");
		btnModificarReserva.setPreferredSize(new Dimension(150,30));
		
		
		add(lblTitulo, gbc);
		gbc.gridy++;
		gbc.gridy++;
		add(btnVerVehiculos, gbc);
		gbc.gridy++;
		add(btnRegistrarVehiculos, gbc);
		gbc.gridy++;
		add(btnEliminarVehiculos, gbc);
		gbc.gridy++;
		add(btnRegistrarEmpleado, gbc);
		gbc.gridy++;
		add(btnCrearReserva, gbc);
		gbc.gridy++;
		add(btnModificarReserva, gbc);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("VerVerhiculo")){
			this.ventana.mostrarPanelPrincipal();
		}else if(e.getActionCommand().equals("RegistrarVerhiculo")){
			this.ventana.mostrarPanelVehiculo();
		}else if(e.getActionCommand().equals("EliminarVerhiculo")){
			//Cambiar ventana a eliminar vehículos
		}else if(e.getActionCommand().equals("RegistrarEmpleado")){
			this.ventana.mostraRegistro("administraadorLocal");//TODO
		}else if(e.getActionCommand().equals("CrearReserva")){
			this.ventana.mostrarPanelReserva();
		}else if(e.getActionCommand().equals("ModificarReserva")){
			this.ventana.mostrarPanelReserva();
		}
	}

}
