package unico;

public class Window extends java.awt.Frame{

	public static void main(String[] args) {
		
		Window miApp = new Window();
		miApp.inicializarComponente();
		System.out.println("todo Ok");

	}

	
	public  void inicializarComponente() {
		
		setBounds(100,100,600,400);
		setVisible(true);
	}
}
