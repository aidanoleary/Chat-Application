package com.company;

import java.io.IOException;
import java.util.Scanner;

public class MainClient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the port number to start the server on: ");
        int portNumber = sc.nextInt();

        ChatClient cClient = new ChatClient("127.0.0.1",portNumber);
        cClient.run();

    }
}
