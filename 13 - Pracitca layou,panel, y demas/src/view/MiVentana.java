package view;

import java.awt.*;
import java.awt.event.*;


public class MiVentana extends java.awt.Frame {

	//Colores
	final Color CLR_BG_FONDO = new Color(200,200,200);
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
		setTitle("Ficha de alumno");
		setBounds(100,100,230,300);
		setBackground(CLR_BG_FONDO);
		setLayout(new GridLayout(3,1));
		setResizable(false);
		setVisible(true);
		
		crearComponente();
	}

	private void crearComponente() {
		
		//CREACCION DE COMPONENTES**************************************************
		
		//PANELES
		Panel panDatos = new Panel();
		panDatos.setLayout(null);
		panDatos.setBounds(0,0,230,100);
		
		Panel panCursoTurno = new Panel();
		panCursoTurno.setLayout(new GridLayout(1,2));
		
		Panel panCurso = new Panel();
		panCurso.setLayout(null);
		
		Panel panTurno = new Panel();
		panTurno.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		Panel panResponsableEconomico = new Panel();
		panResponsableEconomico.setLayout(null);
		
		//panDatos
		Label lblNombre = new Label("Nombre:");
		lblNombre.setBounds(10,10,70,20);
		TextField txtNombre = new TextField(10);
		txtNombre.setBounds(85,10,90,20);
		Label lblApellidos = new Label("Apellidos:");
		lblApellidos.setBounds(10,40,70,20);
		TextField txtApellidos = new TextField(10);
		txtApellidos.setBounds(85,40,90,20);
		
		//panCurso
		Label lblCurso = new Label("Curso:");
		lblCurso.setBounds(10,-12,60,200);
		lblCurso.setBackground(CLR_FG_USUARIO);
		CheckboxGroup chkgrCurso = new CheckboxGroup();
		
		Checkbox chkDam = new Checkbox("DAM",true,chkgrCurso);
		chkDam.setBounds(10,-14,100,100);
		Checkbox chDaw = new Checkbox("DAW",false,chkgrCurso);
		chkDam.setBounds(10,-15,100,20);
		Checkbox chkAsir = new Checkbox("ASIR",false,chkgrCurso);
		chkDam.setBounds(10,-15,100,20);
		
		//panTurno
		Label lblTurno = new Label("Turno:");
		CheckboxGroup chkgrTurno = new CheckboxGroup();
		
		Checkbox chkManiana = new Checkbox("Maniana",true,chkgrTurno);
		Checkbox chTarde = new Checkbox("Tarde",false,chkgrTurno);
		
		//panResponsableEconomico
		Checkbox chkResponsable = new Checkbox("Es responsable economico",true);
		chkResponsable.setBounds(20,60,225,20);
		
		//Aniadir a panDatos
		panDatos.add(lblNombre);
		panDatos.add(txtNombre);
		panDatos.add(lblApellidos);
		panDatos.add(txtApellidos);
		
		//Aniadir a panCurso
		panCurso.add(lblCurso);
		panCurso.add(chkDam);
		panCurso.add(chDaw);
		panCurso.add(chkAsir);
		
		//Aniadir a panTurno
		panTurno.add(lblTurno);
		panTurno.add(chkManiana);
		panTurno.add(chTarde);
		
		//Aniadir a panCursoTurno
		panCursoTurno.add(panCurso);
		panCursoTurno.add(panTurno);
		
		//Aniadir a panResponsableEconomico
		panResponsableEconomico.add(chkResponsable);
		
		//Aniadir al FRAME
		add(panDatos);
		add(panCursoTurno);
		add(panResponsableEconomico);
		
	}

}
