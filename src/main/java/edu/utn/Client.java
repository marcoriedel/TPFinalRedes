package edu.utn;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main (String [] args) throws IOException {

        InputStream stream = System.in;
        Scanner scanner = new Scanner(stream);
        System.out.println("IP/Server name: [localhost por defecto] Envie X para cerrar la conexion");
        String host = scanner.nextLine();
        if (host.length() <= 0) host = "localhost";

        System.out.println("Puerto: [3000 por defecto]");
        String port = scanner.nextLine();
        if (port.length() <= 0) port = "3000";

        try {
            Socket socket = new Socket(host, Integer.parseInt(port));
            System.out.println("Conexion generada con "+socket.getInetAddress().getHostName() + ":"+port);
            PrintWriter outputStream = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            String message, eco = "";


            System.out.println("Mensaje: ");
            message = in.readLine();

            while (!message.equals("X")) {
                outputStream.println(message);
                eco = inputStream.readLine();
                System.out.println(eco);
                System.out.println("Mensage: ");
                message = in.readLine();
            }
            outputStream.close();
            inputStream.close();
            System.out.println("Conexion cerrada correctamente");
            in.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("No es posible crear la conexion");
        } catch (NumberFormatException e) {
            System.out.println("Verifique los datos ingresados");
        }
    }
}