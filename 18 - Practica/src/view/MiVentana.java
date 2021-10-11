package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class MiVentana extends java.awt.Frame{

	public static void main(String[] args) {
		MiVentana miApp = new MiVentana();

		miApp.crearVentana();

	}

	private void crearVentana() {

		addWindowListener(
				new WindowAdapter() {
					public void windowClosing(WindowEvent we) {
						salir();

					}
				}
				);
		setIconImage(Toolkit.getDefaultToolkit().createImage("faviconAhoraViajar.png"));
		setTitle("Practicas Dialog");
		setBounds(50,50,600,400);
		setLayout(null);
		setResizable(false);
		
		crearComponentes();
		setVisible(true);
		
	}

	private void crearComponentes() {
		
		MenuBar brMenu = new MenuBar();
		
		Menu mEditar = new Menu("Editar");
		
		MenuItem miColores = new MenuItem("Colores");
		MenuItem miExit = new MenuItem("Salir");
		
		miColores.addActionListener(e -> {
			new FrmColores();
			});
		
		miExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salir();
				
			}
		});
		
		mEditar.add(miColores);
		mEditar.addSeparator();
		mEditar.add(miExit);
		
		brMenu.add(mEditar);
		
		setMenuBar(brMenu);
		
		
		
	}
	
	private static void salir() {
		int iOpcSeleccionada = JOptionPane.showConfirmDialog(null,"¿Estás seguro que quiere salir?", "Asistente de salida", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
		if (iOpcSeleccionada == 0) {
			System.exit(0);
		}
	}

}
