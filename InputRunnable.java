package com.company;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputRunnable implements Runnable {

    private DataInputStream inputStream;

    public InputRunnable(DataInputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
                char c;
                while((c = (char) inputStream.read()) != '\n') {
                    System.out.print((char) c);
                }
                System.out.println("");

            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}