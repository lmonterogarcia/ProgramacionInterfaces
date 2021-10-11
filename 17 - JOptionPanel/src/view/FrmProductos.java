package view;

 import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class FrmProductos extends JDialog{

	public FrmProductos() {
		setTitle("Gestion de productos");
		setModal(true);
		setLayout(null);
		setBounds(200,200,400,200);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				dispose();
			}
		});
		
		crearComponentes();
		setVisible(true);
	}

	private void crearComponentes() {
		
		JButton btnCrear = new JButton("CREAR");
		btnCrear.setBounds(10,50,80,20);
		
		add(btnCrear);
		
	}
	
}
