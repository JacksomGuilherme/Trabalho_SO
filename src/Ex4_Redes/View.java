package Ex4_Redes;

import javax.swing.JOptionPane;

import Ex4_Redes.Controller;

public class View {

	public static void main(String args[]) {

		String so = System.getProperty("os.name");
		String link = "www.google.com.br";
		int opc = 0;
		Controller Control = new Controller();
		do {
			opc = Integer.parseInt(JOptionPane
					.showInputDialog("1 - " + "Ver Adaptador e IPv4" + "\n2 - Ver Ping de um site\n9 - Encerrar"));
			switch (opc) {
			case 1:
				Control.ip(so);
				break;
			case 2:
				Control.ping(so, link);
				break;
			case 9:
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida");
				break;
			}
		} while (opc != 9);
	}

}