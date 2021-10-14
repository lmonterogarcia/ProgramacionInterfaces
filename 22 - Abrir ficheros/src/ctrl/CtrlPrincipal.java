package ctrl;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class CtrlPrincipal {

	
	public static void abrirFichero() {
		JFileChooser selectorFch = new JFileChooser();
		selectorFch.setFileSelectionMode(JFileChooser.FILES_ONLY);
		
		FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("Formato de imagen", "jpg","bmp","gif","cr2");
		selectorFch.setFileFilter(imgFilter);
		
		int iBtnFch = selectorFch.showOpenDialog(null);
		
		if (iBtnFch != JFileChooser.CANCEL_OPTION) {
			File fileName = selectorFch.getSelectedFile();
			if (fileName != null && !fileName.getName().equals("")) {
				System.out.println(fileName.getAbsolutePath());
			}
		}
	}
}
