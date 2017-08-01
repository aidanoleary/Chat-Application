package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the port number to start the server on: ");
            int portNumber = sc.nextInt();

            ChatServer cServer = new ChatServer(portNumber);
            cServer.run();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
