package ru.levelp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by Student-19 on 09.09.2016.
 */
public class ServerExample {
    private static final int PORT = 8080;
    private ArrayList<ClientHandler> clients = new ArrayList<ClientHandler>();
    public void start (){
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            while (true){
                Socket client = serverSocket.accept();
                ClientHandler handler = new ClientHandler(this, client);
                handler.start();
                clients.add(handler);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void remove (ClientHandler handler) {
        clients.remove(handler);
    }
}
