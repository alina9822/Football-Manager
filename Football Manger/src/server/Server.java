package server;

import util.NetworkUtil;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import projectClasses.*;
import main.*;

public class Server {

    private ServerSocket serverSocket;
    public HashMap<String, String> userMap;

    Server() {
        userMap = new HashMap<>();
        userMap.put("Liverpool", "123");
        userMap.put("Arsenal", "123");
        userMap.put("Chelsea", "123");
        userMap.put("Manchester City", "123");
        userMap.put("Manchester United", "123");
        try {
            serverSocket = new ServerSocket(33333);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                serve(clientSocket);
            }
        } catch (Exception e) {
            System.out.println("Server starts:" + e);
        }
    }

    public void serve(Socket clientSocket) throws IOException {
        NetworkUtil networkUtil = new NetworkUtil(clientSocket);
        new ReadThreadServer(userMap, networkUtil);
    }

    public static void main(String[] args) {
        new Server();
    }
}
