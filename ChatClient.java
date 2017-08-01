package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ChatClient {

    private Socket socket;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;

    public ChatClient(String host, int port) {
        try {
            socket = new Socket(host, port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        System.out.println("Chat Client has started");
        setupInputStream();
        setupOutputStream();
        System.out.println("Input Streams are set up");
        Thread inputThread = startThread(new InputRunnable(inputStream));
        Thread outputThread = startThread(new OutputRunnable(outputStream));

        try {
            inputThread.join();
            outputThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void setupInputStream() {
        try {
            inputStream = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setupOutputStream() {
        try {
            outputStream = new DataOutputStream(socket.getOutputStream());
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
