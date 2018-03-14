package com.acme.edu.network;

import com.acme.edu.message.ByteMessage;
import com.acme.edu.message.IntMessage;
import com.acme.edu.message.StringMessage;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class LoggerClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 7779)) {
            try (OutputStream outputStream = socket.getOutputStream();
                 ObjectOutputStream out = new ObjectOutputStream(outputStream)) {
                out.writeObject(new IntMessage(7));
                out.writeObject(new IntMessage(8));
                out.writeObject(new StringMessage("test"));
                out.writeObject(new StringMessage("test"));
                out.writeObject(new ByteMessage((byte)77));
                out.writeObject(new ByteMessage((byte)1));
                out.writeObject(new StringMessage("test"));
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
