package com.company;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class OutputRunnable implements Runnable {

    private DataOutputStream outputStream;

    public OutputRunnable(DataOutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(100);
                outputStream.write(System.in.read());
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}