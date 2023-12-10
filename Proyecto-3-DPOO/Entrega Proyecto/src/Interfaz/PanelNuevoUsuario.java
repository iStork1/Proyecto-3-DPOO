package Interfaz;

import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelNuevoUsuario extends JPanel{
	private VentanaPrincipal ventana;
	private JTextField nombreField;
	private JTextField apellidoField;
	private JTextField usernameField;
	
	public PanelNuevoUsuario(VentanaPrincipal ventana){
		this.ventana=ventana;
		
		setLayout(new GridBagLayout());
		
		
	}

}
