package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;

public class PnlCrearProducto extends JPanel {

	/**
	 * Create the panel.
	 */
	public PnlCrearProducto() {
		setBounds(0,0,500,268);
		setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton = new JButton("Crear Producto");
		add(btnNewButton, BorderLayout.CENTER);
		
		setVisible(true);

	}

}
