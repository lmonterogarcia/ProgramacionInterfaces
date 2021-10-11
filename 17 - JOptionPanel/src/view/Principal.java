package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

//public class Principal extends javax.swing.JDialog{
public class Principal extends java.awt.Frame{

	//Colores
	final Color CLR_BG_FONDO = new Color(200,200,200);
	final Color CLR_FG_USUARIO = Color.red;
	final Color CLR_FG_PASSWORD = Color.orange;

	//Fuentes
	final Font FNT_LBL_NORMAL = new Font("Arial" , Font.PLAIN , 12);
	final Font FNT_LBL_TITULO = new Font("Arial" , Font.PLAIN , 16);
	final Font FNT_LBL_RESALTADO = new Font("Arial" , Font.BOLD , 12);

	public static void main(String[] args) {
		Principal miApp = new Principal();

		miApp.crearCrearVentana();

	}

	private void crearCrearVentana() {

		addWindowListener(
				new WindowAdapter() {
					public void windowClosing(WindowEvent we) {
						int iOpcSeleccionada = JOptionPane.showConfirmDialog(null,"¿Estás seguro que quiere salir?", "Asistente de salida", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
						if (iOpcSeleccionada == 0) {
							System.exit(0);
						}

					}
				}
				);

		setIconImage(Toolkit.getDefaultToolkit().createImage("faviconAhoraViajar.png"));
		setTitle("Ficha de alumno");
		setBounds(100,100,350,300);
		setBackground(CLR_BG_FONDO);
		setLayout(null);
		setResizable(false);


		crearComponente();
		setVisible(true);

	}

	private void crearComponente() {

		JButton btnMensaje = new JButton("MENSAJE");
		btnMensaje.setBounds(10,50,90,20);
		btnMensaje.addActionListener(e ->{
			//			JOptionPane.showMessageDialog(null,"El producto ha sido aniadido", "Gestion de Producto", JOptionPane.INFORMATION_MESSAGE);
			//			JOptionPane.showMessageDialog(null,"El producto no se ha podido eliminar", "Gestion de Producto", JOptionPane.ERROR_MESSAGE);
			//			JOptionPane.showMessageDialog(null,"El stock del producto es bajo", "Gestion de Producto", JOptionPane.WARNING_MESSAGE);
			//			JOptionPane.showMessageDialog(null,"El producto no esta disponible aun", "Gestion de Producto", JOptionPane.QUESTION_MESSAGE);
			JOptionPane.showMessageDialog(null,"Proceso completado", "Gestion de Producto", JOptionPane.PLAIN_MESSAGE);
		});

		JButton btnEntrada = new JButton("ENTRADA");
		btnEntrada.setBounds(110,50,90,20);
		btnEntrada.addActionListener(e ->{
			String sNombreProducto = JOptionPane.showInputDialog(null,"Introduzca el nuevo nombre del producto", "Gestion de Stock", JOptionPane.INFORMATION_MESSAGE);
			System.out.println(sNombreProducto);
		});

		JButton btnConfirmacion = new JButton("CONFIRMACION");
		btnConfirmacion.setBounds(210,50,130,20);
		btnConfirmacion.addActionListener(e ->{
			int iOpcSeleccionada = JOptionPane.showConfirmDialog(null,"¿Desea FORMATEAR el disco duro?", "Gestion de Disco", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
			System.out.println("Ha seleccionado la opcion: " + iOpcSeleccionada);
		});


		JButton btnVentana = new JButton("VENTANA");
		btnVentana.setBounds(10,80,90,20);
		btnVentana.addActionListener(e ->{

			new FrmProductos();
			
//			Dialog frmProducto = new Dialog(this, "Gestion Producto", true);
//			frmProducto.setBounds(200,200,400,200);
//			frmProducto.addWindowListener(new WindowAdapter() {
//				public void windowClosing(WindowEvent we) {
//					frmProducto.dispose();
//				}
//			});
//			frmProducto.setVisible(true);

		});

		//Aniadiar al FRAME
		add(btnMensaje);
		add(btnEntrada);
		add(btnConfirmacion);
		add(btnVentana);

	}

}
