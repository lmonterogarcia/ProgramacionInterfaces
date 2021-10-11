package view;

import java.awt.*;
import java.awt.event.*;


public class MiVentana extends java.awt.Frame {

	//Colores
	final Color CLR_BG_FONDO = new Color(100,100,100);
	final Color CLR_FG_USUARIO = Color.red;
	final Color CLR_FG_PASSWORD = Color.orange;

	//Fuentes
	final Font FNT_LBL_NORMAL = new Font("Arial" , Font.PLAIN , 12);
	final Font FNT_LBL_TITULO = new Font("Arial" , Font.PLAIN , 16);
	final Font FNT_LBL_RESALTADO = new Font("Arial" , Font.BOLD , 12);


	public static void main(String[] args) {
		MiVentana miApp = new MiVentana();
		miApp.crearVentana();
	}

	private void crearVentana() {

		addWindowListener( new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		
		setIconImage(Toolkit.getDefaultToolkit().createImage("faviconAhoraViajar.png"));
		setTitle("Componentes 3");
		setBounds(100,100,600,400);
		setBackground(CLR_BG_FONDO);
		setLayout(new BorderLayout());
		setResizable(false);
		
		crearComponente();
		
		setVisible(true);//SIEMPRE EL ULTIMO

	}

	private void crearComponente() {

		//CREACCION DE MENU
		
				MenuBar brMenu = new MenuBar();
				
				//Barra Pral
				Menu mnuArchivo = new Menu("Archivo");
				Menu mnuEditar = new Menu("Editar");
				Menu mnuConvertir = new Menu("Convertir");
				Menu mnuAyuda = new Menu("Ayuda");
				
				//Archivo
				MenuItem mniAbrir = new MenuItem("Abrir");
				MenuItem mniGuardar = new MenuItem("Guardar");
				MenuItem mniGuardarComo = new MenuItem("Guardar Como");
				Menu mnuExportar = new Menu("Exportar");
				MenuItem mniSalir = new MenuItem("Salir");
				
				//Exportar
				MenuItem mniWord = new MenuItem("Word");
				MenuItem mniPdf = new MenuItem("PDF");
				MenuItem mniTexto = new MenuItem("Texto");
				
				//Editar
				MenuItem mniCopiar = new MenuItem("Copiar");
				MenuItem mniCortar = new MenuItem("Cortar");
				MenuItem mniPegar = new MenuItem("Pegar");
				MenuItem mniSelectAll = new MenuItem("Seleccionar Todo");
				
				//Convertir
				Menu mnuImagen = new Menu("Imagen");
				Menu mnuBD = new Menu("BD");
				
				//Imagen
				MenuItem mniJpg = new MenuItem("JPG");
				MenuItem mniPng = new MenuItem("PNG");
				MenuItem mniBmp = new MenuItem("BMP");
				
				//BD
				MenuItem mniOracle = new MenuItem("Oracle");
				MenuItem mniMySql = new MenuItem("MySql");
				MenuItem mniAccess = new MenuItem("Access");
				
				//Ayuda
				MenuItem mniManual = new MenuItem("Manual");
				MenuItem mniAcerca = new MenuItem("Acerca de");
				
				// Agregar componentes al Menu mnuArchivo
				mnuArchivo.add(mniAbrir);
				mnuArchivo.add(mniGuardar);
				mnuArchivo.add(mniGuardarComo);
				mnuArchivo.add(mnuExportar);
				mnuArchivo.addSeparator();
				mnuArchivo.add(mniSalir);
				
				//Agregar componentes al Menu mnuExportar
				mnuExportar.add(mniWord);
				mnuExportar.add(mniPdf);
				mnuExportar.add(mniTexto);
				
				//Agregar componentes al Menu mnuEditar
				mnuEditar.add(mniCopiar);
				mnuEditar.add(mniCortar);
				mnuEditar.add(mniPegar);
				mnuEditar.addSeparator();
				mnuEditar.add(mniSelectAll);
				
				//Agregar componentes al Menu mnuImagen
				mnuImagen.add(mniJpg);
				mnuImagen.add(mniPng);
				mnuImagen.add(mniBmp);
				
				//Agregar componentes al Menu mnuBD
				mnuBD.add(mniOracle);
				mnuBD.add(mniMySql);
				mnuBD.add(mniAccess);
				
				//Agregar componentes al Menu mnuConvertir
				mnuConvertir.add(mnuImagen);
				mnuConvertir.add(mnuBD);
				
				//Agregar componentes al Menu mnuAyuda
				mnuAyuda.add(mniManual);
				mnuAyuda.add(mniAcerca);
				
				//Agregar componentes al Barra de MenuBar
				brMenu.add(mnuArchivo);
				brMenu.add(mnuEditar);
				brMenu.add(mnuConvertir);
				brMenu.add(mnuAyuda);
				
				
				//Agregar componentes al Frame
				setMenuBar(brMenu);
				
				//Agregar Funcionalidad al MENU (EVENTOS)
				mniAbrir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ctrl.CrtlMiVentana.abrir();
					}
				});
				
				mniGuardar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ctrl.CrtlMiVentana.guardar();
					}
				});
				
				mniGuardarComo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ctrl.CrtlMiVentana.guardarCmo();
					}
				});
				
				mniSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ctrl.CrtlMiVentana.salir();
						
					}
				});
		
		//Cuadro de texto multilinea
		TextArea txtArComentario = new TextArea();

		//Agregar componentes al Frame
		add(txtArComentario, BorderLayout.CENTER);
	}

}
