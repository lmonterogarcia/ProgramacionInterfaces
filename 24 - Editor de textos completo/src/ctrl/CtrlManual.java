package ctrl;

import java.io.RandomAccessFile;

public class CtrlManual {

	public static String mostrarTexto() {
		String sTexto = "";
		
		try {
			RandomAccessFile fch = new RandomAccessFile("manual.txt", "r");
			byte[] bytesLeidos = new byte[(int) fch.length()];
			fch.readFully(bytesLeidos);
			sTexto = new String(bytesLeidos);
			fch.close();
		} catch (Exception e) {
			System.err.println(e);
		}
		return sTexto;
	}

}
