package br.ucsal.pooavancado.chat;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket cliente = new Socket("127.0.0.1", 12345);
        System.out.println("O cliente se conectou ao servidor!");

        File arquivo  = new File("/home/ezecky/Documentos/arquivo.txt");
        FileInputStream stream = new FileInputStream(arquivo);
        InputStreamReader reader = new InputStreamReader(stream);
        BufferedReader br = new BufferedReader(reader);
        String linha = "";
        while (br.ready()) {
            linha += br.readLine();
            linha +="\n";
        }

        System.out.println(linha);




        Scanner teclado = new Scanner(System.in);
        PrintStream saida = new PrintStream(cliente.getOutputStream());
        saida.println(linha);
        while (teclado.hasNextLine()) {
            saida.println(teclado.nextLine());
        }

        saida.close();
        teclado.close();
    }
}