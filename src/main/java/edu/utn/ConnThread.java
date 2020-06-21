package edu.utn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ConnThread extends Thread {

    BufferedReader inputStream;
    PrintWriter outputStream;
    Socket socket;

    public ConnThread(Socket socket){
        this.socket = socket;
        try {
            outputStream = new PrintWriter(socket.getOutputStream(),true);
            inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run(){

        String message = "";
        System.out.println("Conectado con Server desde " +socket.getInetAddress().getHostName());
        while (!message.trim().equals("X")){

            try {
                message = inputStream.readLine();
                System.out.println("Cliente "+socket.getInetAddress().getHostAddress()+"=> " +message);
                if (message != null){
                    outputStream.println("Server=> Recibido tu msj "+message.trim().toUpperCase());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Conexion cerrada con "+socket.getInetAddress().getHostName());
        try {
            outputStream.close();
            inputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
