package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {

    private ServerSocket server;
    private Socket connection;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;

    public ChatServer(int portNumber) throws IOException {
        server = new ServerSocket(portNumber);
    }

    public void run() {

        waitForConnection();
        setupStreams();
        Thread inputThread = startThread(new InputRunnable(inputStream));
        Thread outputThread = startThread(new OutputRunnable(outputStream));

        try {
            inputThread.join();
            outputThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void waitForConnection() {
        System.out.println("Waiting for a connection");
        try {
            connection = server.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setupStreams() {
        try {
            inputStream = new DataInputStream(connection.getInputStream());
            outputStream = new DataOutputStream(connection.getOutputStream());
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Thread startThread(Runnable runnable) {
        Thread currentThread = new Thread(runnable);
        currentThread.start();
        return currentThread;

    }

}
