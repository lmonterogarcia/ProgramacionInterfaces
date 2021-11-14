package ctrl;

import javax.swing.table.DefaultTableModel;

public class CtrlPrincipal {

	
	public static void rellenarTabla() {
		
		DefaultTableModel tableModel = new DefaultTableModel();
		
		// ANIADIR LAS NOMBRES A LAS COLUMNAS
		tableModel.addColumn("ESPAÑA");
		tableModel.addColumn("FRANCIA");
		tableModel.addColumn("PORTUGAL");
		
		// ANIADIR LOS VALORES DE CADA FILA
		String[] aFila = new String[3];
		
		for (int i = 0; i < 50; i++) {
			for (int j = 0; j < aFila.length; j++) {
				aFila[j] = Integer.toString((int)(Math.random()*100));
			}
			tableModel.addRow(aFila);
		}
//		aFila[0] = "100";
//		aFila[1] = "150";
//		aFila[2] = "200";
//		tableModel.addRow(aFila);
//		aFila[0] = "200";
//		aFila[1] = "423";
//		aFila[2] = "876";
//		tableModel.addRow(aFila);
//		aFila[0] = "900";
//		aFila[1] = "600";
//		aFila[2] = "200";
//		tableModel.addRow(aFila);
//		aFila[0] = "400";
//		aFila[1] = "100";
//		aFila[2] = "100";
//		tableModel.addRow(aFila);
//		aFila[0] = "500";
//		aFila[1] = "200";
//		aFila[2] = "500";
//		tableModel.addRow(aFila);
		
		view.FrmPrincipal.tblResultado.setModel(tableModel);
		
	}
	
	
}
