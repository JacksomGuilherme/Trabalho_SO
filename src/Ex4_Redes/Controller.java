package Ex4_Redes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Controller {

	public Controller() {
		super();
	}

	public void ip(String so) {
		String adap = "";
		String path = "";
		if (so.contains("Windows")) {
			path = "ipconfig";
			try {
				Process proc = Runtime.getRuntime().exec(path);
				InputStream fluxo = proc.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					if (linha.contains("Adaptador")) {
						adap = linha;
					}
					if (linha.contains("IPv4")) {
						System.out.println(adap);
						System.out.println(linha);
					}
					linha = buffer.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (so.contains("Linux")) {
			path = "ifconfig";
			try {
				Process proc = Runtime.getRuntime().exec(path);
				InputStream fluxo = proc.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					if (linha.contains("Adaptador")) {
						adap = linha;
					}
					if (linha.contains("IPv4")) {
						System.out.println(adap);
						System.out.println(linha);
					}
					linha = buffer.readLine();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	public void ping(String so, String path) {
		int i = 1;
		String media = "";
		if (so.contains("Windows")) {
			path = "ping -n 10 " + path;
			try {
				Process proc = Runtime.getRuntime().exec(path);
				InputStream fluxo = proc.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					String backup = linha;
					String[] palavra = linha.split(" ");
					if (linha.contains("tempo")) {
						for (String word : palavra) {
							if (word.contains("tempo=")) {
								System.out.println(i + "ª iteração de " + word);
								i += 1;
							}
						}
					}
					String[] mediaPing = backup.split("=");
					if (backup.contains("M")) {
						String fim = "";
						for (String word : mediaPing) {
							if (word.contains("M")) {
								media = "Média de ping";
							} else {
								fim = word;
							}
						}
						media += " =" + fim;
					}
					linha = buffer.readLine();
				}
				System.out.println(media);
				linha = buffer.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}