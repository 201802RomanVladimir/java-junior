package com.acme.edu.network;

import com.acme.edu.LoggerController;
import com.acme.edu.formatter.PrefixFormatVisitor;
import com.acme.edu.message.Message;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class LoggerServer {
    private final static LoggerController loggerController = new LoggerController(
            System.out::println
    );

    public static void main(String[] args) {
        try (ServerSocket portListener = new ServerSocket(7779)) {
            while (true) { //Session loop
                try (Socket clientSession = portListener.accept();
                     InputStream inputStream = clientSession.getInputStream();
                     ObjectInputStream in = new ObjectInputStream(inputStream)) {
                    try {
                        while (true) {
                            loggerController.log((Message) in.readObject(), new PrefixFormatVisitor());
                        }
                    }
                    catch (EOFException e) {
                        loggerController.flush();
                    }
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
