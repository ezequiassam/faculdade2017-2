package br.ucsal.pooavancado.chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {
	public static void main(String[] args) throws IOException {
		ServerSocket servidor = new ServerSocket(12345);
		System.out.println("Porta 12345 aberta!");

		Socket cliente = servidor.accept();
		System.out.println("Nova conex�o com o cliente " + cliente.getInetAddress().getHostAddress());

		File arquivo = new File("arquivo.txt");
		FileWriter grava = new FileWriter(arquivo);
		PrintWriter escreve = new PrintWriter(grava);

		String texto = "";


		Scanner entrada = new Scanner(cliente.getInputStream());
		while (entrada.hasNextLine()) {
			texto = entrada.nextLine();
			escreve.println(texto);

		}
		escreve.close();
		grava.close();

		entrada.close();
		servidor.close();
	}
}
