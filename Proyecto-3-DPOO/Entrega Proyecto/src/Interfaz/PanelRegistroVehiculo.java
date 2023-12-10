package Interfaz;

import java.awt.Dialog;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.Categoria;
import modelo.Categorias;
import modelo.Sede;
import modelo.Sedes;

public class PanelRegistroVehiculo extends JPanel implements ActionListener {
	private VentanaPrincipal ventana;
	
	private JLabel lblTitulo;
	private JLabel lblId;
	private JLabel lblMarca;
	private JLabel lblPlaca;
	private JLabel lblTipo;
	private JLabel lblSede;
	private JLabel lblModelo;
	private JLabel lblColor;
	private JLabel lblCategoria;
	
	private JTextField txtId;
	private JTextField txtMarca;
	private JTextField txtPlaca;
	private JTextField txtTipo;
	private JComboBox<String> comboSede;
	private JTextField txtModelo;
	private JTextField txtColor;
	private JComboBox<String> comboCategoria;
	
	private JButton btnRegistrar;
	
	private Categoria categoria;
	private Sede sedeUbicado;
	
	
	public PanelRegistroVehiculo(VentanaPrincipal ventana) {
		// TODO Auto-generated constructor stub
		this.ventana = ventana;
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 4;
		gbc.insets = new Insets(10, 10, 10, 10);
		
		
		lblTitulo = new JLabel("Ingrese informaci�n para registrar veh�culo");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 15)); //hay que buscar una especie de directorio de funtes
		lblId = new JLabel("Disponilidad:");
		lblMarca = new JLabel("Marca:");
		lblPlaca = new JLabel("Placa:");
		lblTipo = new JLabel("Tipo de transmisi�n:");
		lblSede = new JLabel("Sede:");
		lblModelo = new JLabel("Modelo:");
		lblColor = new JLabel("Color:");
		lblCategoria = new JLabel("Categoria:");
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setActionCommand("Registrar");
		
		DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>(Categorias.getCategorias1());
		comboCategoria = new JComboBox<>(modelo);
		
		comboCategoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener la opci�n seleccionada
                String seleccion = comboCategoria.getSelectedItem().toString();
                if (seleccion.equals("Crear una nueva categoria"))
                {
                	abrirVentanaDialogo();
                	// Obtener el modelo actual del JComboBox
        	        DefaultComboBoxModel<String> modeloActual = (DefaultComboBoxModel<String>) comboCategoria.getModel();

        	        // Limpiar el modelo actual
        	        modeloActual.removeAllElements();

        	        // Agregar las nuevas opciones al modelo
        	        for (String nuevaOpcion : Categorias.getCategorias1()) {
        	            modeloActual.addElement(nuevaOpcion);
        	        }
                }
                else if (!(seleccion.equals(" ------------------------- "))) 
                {
                	categoria=Categorias.getCategoria(seleccion);
                }
                
                
//                JOptionPane.showMessageDialog(null, "Seleccionaste: " + seleccion);
            }
        });
		
		txtColor = new JTextField(20);
		txtId = new JTextField(20);
		txtId.setText("disponible");
		txtId.setEnabled(false);
		txtMarca = new JTextField(20);
		txtTipo = new JTextField(20);
		
		comboSede = new JComboBox<>(this.ventana.darSedes());
		comboSede.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener la opci�n seleccionada
                String seleccion = comboSede.getSelectedItem().toString();
                if (!seleccion.equals(" ------------------------- ")) 
                {
                	sedeUbicado=ventana.darSede(seleccion);
                }
                
//                JOptionPane.showMessageDialog(null, "Seleccionaste: " + seleccion);
            }
        });
		
		txtPlaca = new JTextField(20);
		txtModelo = new JTextField(20);
		
		//hice esto para poner el titulo en el centro
		add(new JLabel(), gbc);
		gbc.gridx++;
		add(lblTitulo, gbc);
		gbc.gridx++;
		add(new JLabel(), gbc);
		
		gbc.gridx=0;
		gbc.gridy++;
		add(lblId, gbc);
		gbc.gridy++;
		add(lblMarca, gbc);
		gbc.gridy++;
		add(lblPlaca, gbc);
		gbc.gridy++;
		add(lblTipo, gbc);
		gbc.gridy++;
		add(lblSede, gbc);
		gbc.gridy++;
		add(lblModelo, gbc);
		gbc.gridy++;
		add(lblColor, gbc);
		gbc.gridy++;
		add(lblCategoria, gbc);
		
		gbc.gridx+=4;
		gbc.gridy = 0;
		
		gbc.gridy++;
		add(txtId, gbc);
		gbc.gridy++;
		add(txtMarca, gbc);
		gbc.gridy++;
		add(txtPlaca, gbc);
		gbc.gridy++;
		add(txtTipo, gbc);
		gbc.gridy++;
		add(comboSede, gbc);
		gbc.gridy++;
		add(txtModelo, gbc);
		gbc.gridy++;
		add(txtColor, gbc);
		gbc.gridy++;
		add(comboCategoria, gbc);
		
		gbc.gridx = 0;
		gbc.gridy++;
		
		//lo mismo que con el t�tulo
		add(new JLabel(), gbc);
		gbc.gridx++;
		add(btnRegistrar, gbc);
		add(new JLabel(), gbc);
		gbc.gridx++;
	}
	
	 private void abrirVentanaDialogo() {
	        // Crear una instancia de la VentanaDialogoCategoria
	        VentanaDialogoCategoria dialogoCategoria = new VentanaDialogoCategoria();
	        
	        // Hacer que la ventana de di�logo sea visible
	        dialogoCategoria.setVisible(true);
//	        comboCategoria.setModel(new ComboBoxModel <String>(Categorias.getCategorias1()));
	        
	        
	    }
	 
	 
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Registrar")) {
//			TODO agregar las cosas para registrar
			String modelo = this.txtModelo.getText();
			String color = this.txtColor.getText();
			String placa = this.txtPlaca.getText() ;
			String transmision = this.txtTipo.getText();
			
			if (modelo.equals(null)||color.equals(null)||placa.equals(null)||transmision.equals(null)||this.categoria==null||this.sedeUbicado==null)
			{
				JOptionPane.showMessageDialog(null, "Por favor llene todos los campos");
			}
			else 
			{
				this.ventana.registrarVehiculo(modelo,this.categoria,color,placa,transmision,this.sedeUbicado);// Categoria categoria,,,Sede sedeUbicado
				this.ventana.mostrarMenu();
			}
		}
	}

}
