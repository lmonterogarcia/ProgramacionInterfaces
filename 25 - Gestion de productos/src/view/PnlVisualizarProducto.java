package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.FlowLayout;

public class PnlVisualizarProducto extends JPanel {

	/**
	 * Create the panel.
	 */
	public PnlVisualizarProducto() {

		setBounds(0,0,500,268);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(26, 25, 91, 91);
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(50, 190, 215, 55);
		add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton(new ImageIcon("principio.png"));
		panel.add(btnNewButton);
		
		JButton btnNewButton3 = new JButton(new ImageIcon("atras.png"));
		panel.add(btnNewButton3);
		
		JButton btnNewButton2 = new JButton(new ImageIcon("alante.png"));
		panel.add(btnNewButton2);
		
		JButton btnNewButton4 = new JButton(new ImageIcon("final.png"));
		panel.add(btnNewButton4);
		
		/*Para cambiar imagen por otras IMPORTANTE!!!!!!!!
		 * 
		 * String imageName = "Images/icono.png";
		 * ImageIcon icon = new ImageIcon(imageName);
		 * icon.getIamge.flush();
		 * etiqueta1.setIcon(icon);
		 * 
		 */
		
		
		setVisible(true);
	}
}
