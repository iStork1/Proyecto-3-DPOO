package Interfaz;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import modelo.Categoria;
import modelo.Categorias;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaDialogoCategoria extends JFrame {

    private JTextField valorEntregaOtraSedeField;
    private JTextField valorConductorAdicionalField;
    private JTextField nombreField;

    public VentanaDialogoCategoria() {
        // Configuración del JFrame
        setTitle("Ingrese los valores");
        setSize(400, 150);
        
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear un JPanel
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Agregamos un borde al panel
        
        // Etiquetas y campos de texto
        JLabel valorEntregaLabel = new JLabel("Valor Entrega a Otra Sede:");
        valorEntregaOtraSedeField = new JTextField();

        JLabel valorConductorLabel = new JLabel("Valor Conductor Adicional:");
        valorConductorAdicionalField = new JTextField();

        JLabel nombreLabel = new JLabel("Nombre de la Categoría:");
        nombreField = new JTextField();

        // Botón de aceptar
        JButton aceptarButton = new JButton("Aceptar");
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los valores ingresados
                String valorEntregaOtraSedeText = valorEntregaOtraSedeField.getText();
                String valorConductorAdicionalText = valorConductorAdicionalField.getText();
                String nombreText = nombreField.getText();

                // Validar y procesar los valores
                try {
                    int valorEntregaOtraSede = Integer.parseInt(valorEntregaOtraSedeText);
                    int valorConductorAdicional = Integer.parseInt(valorConductorAdicionalText);

                    // Crear una instancia de la clase Categoria con los valores obtenidos
                    Categoria categoria = Categorias.crearCategoria(valorEntregaOtraSede, valorConductorAdicional, nombreText);

                    // Hacer algo con la instancia de Categoria (por ejemplo, imprimir los valores)
                    //System.out.println(categoria);

                    // Cerrar la ventana
                    dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese valores numéricos válidos.");
                }
            }
        });

        // Agregar componentes al panel
        panel.add(valorEntregaLabel);
        panel.add(valorEntregaOtraSedeField);
        panel.add(valorConductorLabel);
        panel.add(valorConductorAdicionalField);
        panel.add(nombreLabel);
        panel.add(nombreField);
        panel.add(new JLabel()); // Espaciador
        panel.add(aceptarButton);

        // Agregar el panel al JFrame
        add(panel);

        // Hacer visible el JFrame
        setVisible(true);
    }

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            new VentanaDialogoCategoria();
//        });
//    }
}
