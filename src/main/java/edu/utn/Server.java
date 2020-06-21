package edu.utn;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {



    public static void main(String[] args) throws IOException {

        ServerSocket server;
        InputStream stream = System.in;
        Scanner scanner = new Scanner(stream);
        System.out.println("En que puerto escuchara el server:[3000 por defecto]");
        String port = scanner.nextLine();
        if (port.length() <= 0) port="3000";
        try {
            server = new ServerSocket(Integer.parseInt(port));

            System.out.println("Iniciando Servidor en Puerto "+port);

            while (true){
                Socket client = new Socket();
                client = server.accept();
                ConnThread conn = new ConnThread(client);
                conn.start();
                System.out.println("Nueva Conexion");
            }
        } catch (IOException e) {
            System.out.println("No es posible conectar");
        } catch (NumberFormatException e) {
            System.out.println("Verifique los datos ingresados");
        }


    }
}
