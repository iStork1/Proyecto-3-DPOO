package Interfaz;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Properties;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import modelo.DateLabelFormater;

public class PanelRegistroUsuario extends JPanel implements ActionListener{
	private VentanaPrincipal ventana;
	private JLabel lblTitulo;
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JLabel lblFechaNac;
	private JLabel lblTelefono;
	private JLabel lblEmail;
	private JLabel lblId;
	private JLabel lblIdLic;
	private JLabel lblFechaVen;
	private JLabel lblPais;
	private JLabel lblTipo;
	private JLabel lblUsuario;
	private JLabel lblContrasenia;
	private JLabel lblFoto;
	
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtTelefono;
	private JTextField txtEmail;
	private JTextField txtId;
	private JTextField txtIdLic;
	private JTextField txtUsuario;
	private JTextField txtContrasenia;

	private JComboBox<String> comboPais;
	private JComboBox<String> comboTipo;
	
	private JButton btnFoto;
	private JButton btnRegistrar;
	
	private String rol = "";
	
	private Date selectedDateFecVen;
	private Date selectedDateFecNac;
	
	
	public PanelRegistroUsuario(VentanaPrincipal ventana) {
		this.ventana = ventana;
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 4;
		gbc.insets = new Insets(10, 10, 10, 10);
		
		
		lblTitulo = new JLabel("Ingrese informaci�n para registrar usuario");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		lblNombre = 		new JLabel("                          Nombre:", SwingConstants.LEFT);
		lblApellidos = 		new JLabel("                       Apellidos:", SwingConstants.LEFT);
		lblFechaNac = 		new JLabel("             Fecha de nacimiento:", SwingConstants.LEFT);
		lblTelefono = 		new JLabel("                        Telefono:", SwingConstants.LEFT);
		lblEmail = 			new JLabel("                           Email:", SwingConstants.LEFT);
		lblId = 			new JLabel("                              ID:", SwingConstants.LEFT);
		lblIdLic = 			new JLabel("              Número de licencia:", SwingConstants.LEFT);
		lblFechaVen = 		new JLabel("Fecha de vencimiento de licencia:", SwingConstants.LEFT);
		lblPais = 			new JLabel("                            Pais:", SwingConstants.LEFT);
		lblTipo = 			new JLabel("                 Tipo de usuario:", SwingConstants.LEFT);
		lblUsuario = 		new JLabel("               Nombre de usuario:", SwingConstants.LEFT);
		lblContrasenia = 	new JLabel("                      Contraseña:", SwingConstants.LEFT);
		lblFoto = 			new JLabel("       Ingrese foto de documento:", SwingConstants.LEFT);
		
		
		
		UtilDateModel model1 = new UtilDateModel();
		Properties p1 = new Properties();
		p1.put("text.today", "Today");
		p1.put("text.month", "Month");
		p1.put("text.year", "Year");
		JDatePanelImpl datePanelFecNac = new JDatePanelImpl(model1, p1);
		JDatePickerImpl datePickerFecNac = new JDatePickerImpl(datePanelFecNac, new DateLabelFormater());
		selectedDateFecNac = (Date) datePickerFecNac.getModel().getValue();

		
		
		UtilDateModel model2 = new UtilDateModel();
		Properties p2 = new Properties();
		p2.put("text.today", "Today");
		p2.put("text.month", "Month");
		p2.put("text.year", "Year");
		JDatePanelImpl datePanelFecVen = new JDatePanelImpl(model2, p2);
		JDatePickerImpl datePickerFecVen = new JDatePickerImpl(datePanelFecVen, new DateLabelFormater());
		selectedDateFecVen = (Date) datePickerFecNac.getModel().getValue();
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setActionCommand("Registrar");
		
		btnFoto = new JButton("Agregar foto");
		btnFoto.addActionListener(this);
		btnFoto.setActionCommand("Foto");
		
		txtNombre = new JTextField(20);
		txtApellidos = new JTextField(20);
		txtTelefono = new JTextField(20);
		txtEmail = new JTextField(40);
		txtId = new JTextField(20);
		txtIdLic = new JTextField(20);
		txtUsuario = new JTextField(20);
		txtContrasenia = new JTextField(20);
		
		txtNombre.setSize(150, 30);
		
		String[] opciones = {"Cliente", "Empleado", "Administrador Local"};
        DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>(opciones);
		comboTipo = new JComboBox<String>(modelo);
		
		String[] paises = {"Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra", "Angola", "Anguilla", "Antarctica",
				"Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain",
				"Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia", "Bosnia and Herzegowina",
				"Botswana", "Bouvet Island", "Brazil", "British Indian Ocean Territory", "Brunei Darussalam", "Bulgaria", "Burkina Faso",
				"Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Cayman Islands", "Central African Republic", "Chad", "Chile",
				"China", "Christmas Island", "Cocos Islands", "Colombia", "Comoros", "Congo", "Democratic Republic of the Congo",
				"Cook Islands", "Costa Rica", "Cote d'Ivoire", "Croatia", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti",
				"Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia",
				"Ethiopia", "Falkland Islands (Malvinas)", "Faroe Islands", "Fiji", "Finland", "France", "France Metropolitan", "French Guiana",
				"French Polynesia", "French Southern Territories", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Gibraltar", "Greece",
				"Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti",
				"Heard and Mc Donald Islands", "Holy See (Vatican City State)", "Honduras", "Hong Kong", "Hungary", "Iceland", "India",
				"Indonesia", "Iran", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan",
				"Kenya", "Kiribati", "Korea, Democratic People's Republic of", "Korea, Republic of", "Kuwait", "Kyrgyzstan", "Latvia", "Lebanon",
				"Lesotho", "Liberia", "Libyan Arab Jamahiriya", "Liechtenstein", "Lithuania", "Luxembourg", "Macau", "Macedonia", "Madagascar",
				"Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Martinique", "Mauritania", "Mauritius", "Mayotte",
				"Mexico", "Micronesia, Federated States of", "Moldova, Republic of", "Monaco", "Mongolia", "Montserrat", "Morocco", "Mozambique",
				"Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "Netherlands Antilles", "New Caledonia", "New Zealand", "Nicaragua",
				"Niger", "Nigeria", "Niue", "Norfolk Island", "Northern Mariana Islands", "Norway", "Oman", "Pakistan", "Palau", "Palestine",
				"Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Pitcairn", "Poland", "Portugal", "Puerto Rico", "Qatar",
				"Reunion", "Romania", "Russian Federation", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines",
				"Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Seychelles", "Sierra Leone", "Singapore",
				"Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Georgia and the South Sandwich Islands", "Spain",
				"Sri Lanka", "St. Helena", "St. Pierre and Miquelon", "Sudan", "Suriname", "Svalbard and Jan Mayen Islands", "Swaziland",
				"Sweden", "Switzerland", "Syrian Arab Republic", "Taiwan", "Tajikistan", "Tanzania", "Thailand", "Togo", "Tokelau", "Tonga",
				"Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan", "Turks and Caicos Islands", "Tuvalu", "Uganda", "Ukraine",
				"United Arab Emirates", "United Kingdom", "United States", "United States Minor Outlying Islands", "Uruguay", "Uzbekistan",
				"Vanuatu", "Venezuela", "Vietnam", "Virgin Islands (British)", "Virgin Islands (U.S.)", "Wallis and Futuna Islands",
				"Western Sahara", "Yemen", "Yugoslavia", "Zambia", "Zimbabwe"};
        DefaultComboBoxModel<String> modeloPais = new DefaultComboBoxModel<>(paises);
		comboPais = new JComboBox<String>(modeloPais);
		
		add(new JLabel(), gbc);
		gbc.gridx++;
		add(lblTitulo, gbc);
		gbc.gridx++;
		add(new JLabel(), gbc);
		
		gbc.gridx=0;
		gbc.gridy++;
		add(lblNombre, gbc);
		gbc.gridy++;
		add(lblApellidos, gbc);
		gbc.gridy++;
		add(lblFechaNac, gbc);
		gbc.gridy++;
		add(lblTelefono, gbc);
		gbc.gridy++;
		add(lblEmail, gbc);
		gbc.gridy++;
		add(lblId, gbc);
		gbc.gridy++;
		add(lblIdLic, gbc);
		gbc.gridy++;
		add(lblFechaVen, gbc);
		gbc.gridy++;
		add(lblPais, gbc);
		gbc.gridy++;
		add(lblTipo, gbc);
		gbc.gridy++;
		add(lblUsuario, gbc);
		gbc.gridy++;
		add(lblContrasenia, gbc);
		gbc.gridy++;
		add(lblFoto, gbc);

		
		gbc.gridx+=4;
		gbc.gridy = 0;
		
		gbc.gridy++;
		add(txtNombre, gbc);
		gbc.gridy++;
		add(txtApellidos, gbc);
		gbc.gridy++;
		add(datePickerFecNac, gbc);
		gbc.gridy++;
		add(txtTelefono, gbc);
		gbc.gridy++;
		add(txtEmail, gbc);
		gbc.gridy++;
		add(txtId, gbc);
		gbc.gridy++;
		add(txtIdLic, gbc);
		gbc.gridy++;
		add(datePickerFecVen, gbc);
		gbc.gridy++;
		add(comboPais, gbc);
		gbc.gridy++;
		add(comboTipo, gbc);
		gbc.gridy++;
		add(txtUsuario, gbc);
		gbc.gridy++;
		add(txtContrasenia, gbc);
		gbc.gridy++;
		add(btnFoto, gbc);
		
		gbc.gridx = 0;
		gbc.gridy++;
		
		add(new JLabel(), gbc);
		gbc.gridx++;
		add(btnRegistrar, gbc);
		add(new JLabel(), gbc);
		gbc.gridx++;
		
		
		lblApellidos.setHorizontalAlignment(SwingConstants.RIGHT);
		
	}
	private void asignarRolDesdeComboBox() {
        // Obtener la opci�n seleccionada del JComboBox
        String opcionSeleccionada = (String) comboTipo.getSelectedItem();

        // Asignar el valor de rol seg�n la opci�n seleccionada
        if (opcionSeleccionada.equals("Cliente")) {
            rol = "cliente";
        } else if (opcionSeleccionada.equals("Administrador Local")) {
            rol = "administradorLocal";
        } else if (opcionSeleccionada.equals("Empleado")) {
            rol = "empleado";
        }
        
	}
	
	public void definirComboBox(String rol)
	{
		//--------------opciones del Combo box-------
				String[] opciones = null;
				if (rol.equals("cliente"))
					{opciones = new String[]{"Cliente"};}
				else if (rol.equals("administradorLocal"))
				{
					opciones = new String[]{"Empleado Sede"};
				}
				else 
				{
					opciones = new String[]{"Administrador Local","Empleado Sede"};
				}
				
				// Obtener el modelo actual del JComboBox
		        DefaultComboBoxModel<String> modeloActual = (DefaultComboBoxModel<String>) comboTipo.getModel();

		        // Limpiar el modelo actual
		        modeloActual.removeAllElements();

		        // Agregar las nuevas opciones al modelo
		        for (String nuevaOpcion : opciones) {
		            modeloActual.addElement(nuevaOpcion);
		        }
		        
		        comboTipo.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		                // Llamamos a un m�todo que asigna el valor de rol seg�n la opci�n seleccionada
		                asignarRolDesdeComboBox();
		            }
		        });
				
	
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Registrar")) {
			
			String rol = this.rol; //deben ser "cliente","administradorLocal" o "empleado"
			System.out.print(rol);
			String username = txtUsuario.getText();
			String password = txtContrasenia.getText();
			String nombre = txtNombre.getText();
			String apellido = txtApellidos.getText();
			String telefono = txtTelefono.getText();
			String email = txtEmail.getText();
			String pais = String.valueOf(comboPais.getSelectedItem());
			Date fechaNacimiento = selectedDateFecNac;
			String idDocumento = txtId.getText();
			BufferedImage imagenDocumento = null; //La dirección de la foto queda guardada en String foto //TODO
			String idLicencia = txtIdLic.getText();
			BufferedImage imagenLicencia=null; //La dirección de la foto queda guardada en String licencia //TODO
			Date fechaVencimientoLicencia = selectedDateFecVen;
			try {
				this.ventana.registrarUsuario(username,password, rol,nombre, telefono,email,apellido,pais,fechaNacimiento, idLicencia,fechaVencimientoLicencia,imagenLicencia,imagenDocumento,idDocumento);
				JOptionPane.showMessageDialog(null, "Usuario creado");
				this.ventana.mostrarMenu();
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "Hubo un error");
				
				
			}
		} else if (e.getActionCommand().equals("Foto")) {
			String foto = JOptionPane.showInputDialog("Ingrese link de la foto");
			// Para que el usuario ingrese la dirección en la que se encuentra la imagen que debe estar en los archivos del programa
		}else if (e.getActionCommand().equals("Licencia")) {
			String licencia = JOptionPane.showInputDialog("Ingrese link de la foto");
			// Para que el usuario ingrese la dirección en la que se encuentra la imagen que debe estar en los archivos del programa
		}
		
		
		
	}

}
